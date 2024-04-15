package com.ERR.infra.party;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ERR.common.base.BaseController;
import com.ERR.common.constants.Constants;
import com.ERR.common.util.UtilDateTime;
import com.ERR.infra.code.CodeService;
import com.ERR.infra.memberParty.MemberPartyDto;

import jakarta.servlet.http.HttpSession;

@Controller
public class PartyController extends BaseController {
	private String XdmPartyCommomPath = "xdm/party/";
	private String UsrPartyCommonPath = "usr/party/";

	@Autowired
	PartyService partyservice;
	@Autowired
	CodeService codeService;

	public void setSearch(PartyVo vo) throws Exception {
		vo.setVoDateStart(vo.getVoDateStart() == null
				? UtilDateTime.calculateDayReplace00TimeString(UtilDateTime.nowLocalDateTime(), Constants.DATE_INTERVAL)
				: UtilDateTime.add00TimeString(vo.getVoDateStart()));
		vo.setVoDateEnd(vo.getVoDateEnd() == null ? UtilDateTime.nowString()
				: UtilDateTime.addNowTimeString(vo.getVoDateEnd()));
	}

	@RequestMapping(value = "/partyXdmList")
	public String partyXdmList(@ModelAttribute("vo") PartyVo vo, Model model) throws Exception {
		setSearch(vo);

		vo.setParamsPaging(partyservice.selectCount(vo));

		if (vo.getTotalRows() > 0) {
			model.addAttribute("list", partyservice.selectListWithPaging(vo));
		}

		return XdmPartyCommomPath + "partyXdmList";
	}

	@RequestMapping(value = "/partyView")
	public String partyView(PartyDto dto, Model model) throws Exception {

		model.addAttribute("item", partyservice.selectOne(dto));

		return XdmPartyCommomPath + "partyView";
	}

	@RequestMapping(value = "/partyUpdateForm")
	public String partyUpdateForm(Model model, PartyDto dto) throws Exception {

		model.addAttribute("item", partyservice.selectOne(dto));
		return XdmPartyCommomPath + "partyXdmUpdateForm";
	}

	@RequestMapping(value = "/partyInsertForm")
	public String partyViewUpdate(Model model) throws Exception {

		return XdmPartyCommomPath + "partyInsertForm";
	}

	@RequestMapping(value = "/partyInsert")
	public String partyInsert(PartyDto partyDto, MemberPartyDto memberPartyDto, HttpSession httpSession, Model model)
			throws Exception {
		System.out.println(
				httpSession.getAttribute("sessMemberSeq") + "================================================");
		memberPartyDto.setMemberSeqF((String.valueOf(httpSession.getAttribute("sessMemberSeq"))));

		partyservice.insert(partyDto, memberPartyDto);
		return "redirect:/partyXdmList";
	}

	@RequestMapping(value = "/insertReq")
	public String insertReq(PartyDto partyDto, MemberPartyDto memberPartyDto, HttpSession httpSession, Model model)
			throws Exception {
		System.out.println(
				httpSession.getAttribute("sessMemberSeq") + "================================================");
		memberPartyDto.setMemberSeqF((String.valueOf(httpSession.getAttribute("sessMemberSeq"))));

		partyservice.insert(partyDto, memberPartyDto);
		return "redirect:/myProfilePartyRequest";
	}

	@RequestMapping(value = "/partyUpdt")
	public String partyUpdt(PartyDto dto, Model model) throws Exception {

		partyservice.update(dto);
		return "redirect:/partyXdmList";
	}

	@RequestMapping(value = "/partyUelete")
	public String partyUelete(PartyDto dto, Model model) throws Exception {

		partyservice.uelete(dto);
		return "redirect:/partyXdmList";
	}

	@RequestMapping(value = "/partyDelete")
	public String partyDelete(PartyDto dto, Model model) throws Exception {

		partyservice.delete(dto);
		return "redirect:/partyXdmList";
	}

	@RequestMapping(value = "/userPartySearchList")
	public String userPartySearchList(@ModelAttribute("vo") PartyVo vo, Model model) throws Exception {
		setSearch(vo);
		vo.setParamsPaging(partyservice.selectCount(vo));

		if (vo.getTotalRows() > 0) {
			model.addAttribute("list", partyservice.selectListWithPaging(vo));
		}

		return UsrPartyCommonPath + "userPartySearchList";
	}

	@RequestMapping(value = "/userPartyDetail")
	public String userPartyDetail(PartyDto dto, Model model) throws Exception {
		model.addAttribute("item", partyservice.selectOneDetail(dto));

		return UsrPartyCommonPath + "userPartyDetail";
	}

	@RequestMapping(value = "/partyUsrInsert")
	public String partyUsrInsert(PartyDto partyDto, MemberPartyDto memberPartyDto, HttpSession httpSession, Model model)
			throws Exception {
		System.out.println(
				httpSession.getAttribute("sessMemberSeq") + "================================================");
		memberPartyDto.setMemberSeqF((String.valueOf(httpSession.getAttribute("sessMemberSeq"))));

		partyservice.insert(partyDto, memberPartyDto);
		return "redirect:/myProfileMyPartys";
	}

	@RequestMapping(value = "/insertRequest")
	public String insertRequest(PartyDto partyDto, MemberPartyDto memberPartyDto, HttpSession httpSession, Model model)
			throws Exception {
		memberPartyDto.setMemberSeqF((String.valueOf(httpSession.getAttribute("sessMemberSeq"))));

		partyservice.insertRequest(partyDto, memberPartyDto);
		return "redirect:/myProfileMyPartys";
	}

	@RequestMapping(value = "/updatePermit")
	public String updatePermit(PartyDto partyDto, MemberPartyDto memberPartyDto, HttpSession httpSession, Model model)
			throws Exception {
		memberPartyDto.setMemberSeqF((String.valueOf(httpSession.getAttribute("sessMemberSeq"))));

		partyservice.updatePermit(partyDto, memberPartyDto);
		return "redirect:/myProfilePartyPermit";
	}

}
