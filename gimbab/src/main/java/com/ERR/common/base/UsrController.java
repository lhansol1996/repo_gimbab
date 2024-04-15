package com.ERR.common.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ERR.common.constants.Constants;
import com.ERR.common.util.UtilDateTime;
import com.ERR.infra.code.CodeService;
import com.ERR.infra.member.MemberDto;
import com.ERR.infra.member.MemberService;
import com.ERR.infra.party.PartyDto;
import com.ERR.infra.party.PartyService;
import com.ERR.infra.party.PartyVo;

import jakarta.servlet.http.HttpSession;

@Controller
public class UsrController extends BaseController {
	private String UsrCommonPath = "usr/";
	private String UsrCommonPartyPath = "usr/party/";
	private String UsrCommomMemberPath = "usr/member/";
	private String UsrCommomMyProfilePath = "usr/myprofile/";
	@Autowired
	PartyService partyService;
	@Autowired
	MemberService memberService;
	@Autowired
	CodeService codeService;
	
	public void setSearch(PartyVo vo) throws Exception {
		vo.setVoDateStart(vo.getVoDateStart() == null
				? UtilDateTime.calculateDayReplace00TimeString(UtilDateTime.nowLocalDateTime(), Constants.DATE_INTERVAL)
				: UtilDateTime.add00TimeString(vo.getVoDateStart()));
		vo.setVoDateEnd(vo.getVoDateEnd() == null ? UtilDateTime.nowString()
				: UtilDateTime.addNowTimeString(vo.getVoDateEnd()));
	}

	@RequestMapping(value = "/userIndex")
	public String userIndex(Model model, PartyDto dto) throws Exception {
		model.addAttribute("partyRecentList", partyService.searchPartyForRecent5(dto));

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
		setSearch(vo);

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
		setSearch(vo);

		vo.setParamsPaging(partyService.selectCountProfileRequest(vo));

		if (vo.getTotalRows() > 0) {
			model.addAttribute("list", partyService.profilePartyRequestListWithPaging(vo));
		}
		
		return UsrCommomMyProfilePath + "myProfilePartyRequest";
	}

	@RequestMapping(value = "/myProfilePartyPermit")
	public String myProfilePartyPermit(@ModelAttribute("vo") PartyVo vo, Model model) throws Exception {
		setSearch(vo);

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
