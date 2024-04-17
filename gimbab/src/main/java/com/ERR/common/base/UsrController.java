package com.ERR.common.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ERR.common.util.UtilApi;
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
	
	@Autowired
	PartyService partyService;
	@Autowired
	MemberService memberService;
	@Autowired
	CodeService codeService;

	@RequestMapping(value = "/userIndex")
	public String userIndex(Model model, PartyDto dto) throws Exception {
		model.addAttribute("partyRecentList", partyService.searchPartyForRecent5(dto));
		
		String apiURL = "https://open-api.bser.io/v1/rank/top/19/3";
		UtilApi.callERApi(apiURL);

		// API 호출 및 stringBuilder 받아오기
	    StringBuilder stringBuilder = UtilApi.callERApi(apiURL);
		
		//objectMapper 생성 
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map = objectMapper.readValue(stringBuilder.toString(), Map.class);
        
//        System.out.println("######## Map");
//		for (String key : map.keySet()) {
//			String value = String.valueOf(map.get(key));
//			System.out.println("[key]:" + key + ", [value]:" + value);
//		}
		List<Map<String, Object>> topRanks = new ArrayList<>();
		topRanks = (List<Map<String, Object>>) map.get("topRanks");
		// "topRanks" 배열에서 0부터 9까지의 요소만 가져오기 - 실시간 10 
		List<Map<String, Object>> limitedTopRanks = new ArrayList<>(topRanks.subList(0, 10));
	
		model.addAttribute("topRanks", limitedTopRanks);
		
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
