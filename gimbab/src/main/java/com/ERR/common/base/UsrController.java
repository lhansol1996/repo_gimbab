package com.ERR.common.base;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ERR.common.util.UtilSetSearch;
import com.ERR.infra.code.CodeService;
import com.ERR.infra.member.MemberDto;
import com.ERR.infra.member.MemberService;
import com.ERR.infra.party.PartyDto;
import com.ERR.infra.party.PartyService;
import com.ERR.infra.party.PartyVo;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpSession;

@Controller
public class UsrController extends BaseController {
	private String UsrCommonPath = "usr/";
	private String UsrCommomMemberPath = "usr/member/";
	private String UsrCommomMyProfilePath = "usr/myprofile/";
	
	//api 사용시 사용할 변수선언
	String apiKey = "tQvnRGNZTG3LVyUHPweI78qgK27NqVqs8MCWHwPT";
	
	
	@Autowired
	PartyService partyService;
	@Autowired
	MemberService memberService;
	@Autowired
	CodeService codeService;

	@RequestMapping(value = "/userIndex")
	public String userIndex(Model model, PartyDto dto) throws Exception {
		model.addAttribute("partyRecentList", partyService.searchPartyForRecent5(dto));

		// 사용자 index 페이지 이터널리턴 API 랭킹 1000위 사용

		URL url = new URL("https://open-api.bser.io/v1/rank/top/19/3");
		
		//HttpURLConnection 객체생성
		HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
		
		//x-api-key 설정
		httpURLConnection.setRequestProperty("x-api-key", apiKey);
		//방식 설정
		httpURLConnection.setRequestMethod("GET");
		
		BufferedReader bufferedReader;
		//api 호출 
		if (httpURLConnection.getResponseCode() >= 200 && httpURLConnection.getResponseCode() <= 300) {
			bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
		} else {
			bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
		}
		
		StringBuilder stringBuilder = new StringBuilder();
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			System.out.println("line: " + line);
			stringBuilder.append(line);
		}

		bufferedReader.close();
		httpURLConnection.disconnect();

		System.out.println("stringBuilder.toString(): " + stringBuilder.toString());
		
		//objectMapper 생성 
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map = objectMapper.readValue(stringBuilder.toString(), Map.class);
        
        System.out.println("######## Map");
		for (String key : map.keySet()) {
			String value = String.valueOf(map.get(key));
			System.out.println("[key]:" + key + ", [value]:" + value);
		}
		List<Map<String, Object>> topRanks = new ArrayList<>();
		topRanks = (List<Map<String, Object>>) map.get("topRanks");
		model.addAttribute("topRanks", topRanks);
		
//		Map<String, Object> topRanks = new HashMap<String, Object>();
//		topRanks = (Map<String, Object>) map.get("topRanks");
//		
//		Map<String, Object> header = new HashMap<String, Object>();
//		header = (Map<String, Object>) map.get("header");
//		
//		System.out.println("######## Header");
//		for (String key : header.keySet()) {
//			String value = String.valueOf(header.get(key));	// ok
//			System.out.println("[key]:" + key + ", [value]:" + value);
//		}
//		
//		String aaa = (String) header.get("resultCode");
		
//		System.out.println("header.get(\"resultCode\"): " + header.get("resultCode"));
//		System.out.println("header.get(\"resultMsg\"): " + header.get("resultMsg"));
		
		
		return UsrCommonPath + "index";
	}

	@RequestMapping(value = "/myProfileUpdate")
	public String myProfileUpdate(Model model, MemberDto dto, HttpSession httpSession) throws Exception {
		dto.setMemberSeq((String) httpSession.getAttribute("sessMemberSeq"));
		model.addAttribute("item", memberService.selectOne(dto));

		return UsrCommomMyProfilePath + "myProfileUpdate";
	}

	@RequestMapping(value = "/profileUpdt")
	public String profileUpdt(Model model, MemberDto dto, HttpSession httpSession) throws Exception {
		dto.setMemberSeq((String) httpSession.getAttribute("sessMemberSeq"));
		System.out.println(dto.getMemberSeq());
		memberService.updateProfile(dto);

		return "redirect:/myProfileUpdate";
	}

	@RequestMapping(value = "/myProfileMyPartys")
	public String myProfileMyPartys(@ModelAttribute("vo") PartyVo vo, Model model) throws Exception {
		UtilSetSearch.setSearch(vo);

		vo.setParamsPaging(partyService.selectCountProfileMyPartys(vo));

		if (vo.getTotalRows() > 0) {
			model.addAttribute("list", partyService.profilePartyListWithPaging(vo));
		}

		return UsrCommomMyProfilePath + "myProfileMyPartys";
	}

	@RequestMapping(value = "/myProfilePartyMake")
	public String myProfilePartyMake() throws Exception {

		return UsrCommomMyProfilePath + "myProfilePartyMake";
	}

	@RequestMapping(value = "/memberLoginRegister")
	public String memberLoginRegister() throws Exception {

		return UsrCommomMemberPath + "memberLoginRegister";
	}

	@RequestMapping(value = "/myProfilePartyRequest")
	public String myProfilePartyRequest(@ModelAttribute("vo") PartyVo vo, Model model) throws Exception {
		UtilSetSearch.setSearch(vo);

		vo.setParamsPaging(partyService.selectCountProfileRequest(vo));

		if (vo.getTotalRows() > 0) {
			model.addAttribute("list", partyService.profilePartyRequestListWithPaging(vo));
		}

		return UsrCommomMyProfilePath + "myProfilePartyRequest";
	}

	@RequestMapping(value = "/myProfilePartyPermit")
	public String myProfilePartyPermit(@ModelAttribute("vo") PartyVo vo, Model model) throws Exception {
		UtilSetSearch.setSearch(vo);

		vo.setParamsPaging(partyService.selectCountProfilePermit(vo));

		if (vo.getTotalRows() > 0) {
			model.addAttribute("list", partyService.profilePartyPermitListWithPaging(vo));
		}

		return UsrCommomMyProfilePath + "myProfilePartyPermit";
	}

	@RequestMapping(value = "/memberChangePwd")
	public String memberChangePwd() throws Exception {

		return UsrCommomMemberPath + "memberChangePwd";
	}

}
