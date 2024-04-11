package com.ERR.common.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ERR.infra.party.PartyDto;
import com.ERR.infra.party.PartyService;

@Controller
public class UsrController extends BaseController {
	private String UsrCommonPath = "usr/";
	private String UsrCommonPartyPath = "usr/party/";
	private String UsrCommomMemberPath = "usr/member/";
	private String UsrCommomMyProfilePath = "usr/myprofile/";
	@Autowired
	PartyService partyService;

	@RequestMapping(value = "/userIndex")
	public String userIndex(Model model, PartyDto dto) throws Exception {
		model.addAttribute("partyRecentList", partyService.searchPartyForRecent5(dto));

		return UsrCommonPath + "index";
	}

	@RequestMapping(value = "/myProfileUpdate")
	public String myProfileUpdate() throws Exception {
		

		return UsrCommomMyProfilePath + "myProfileUpdate";
	}

	@RequestMapping(value = "/myProfileMyPartys")
	public String myProfileMyPartys() throws Exception {

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

	@RequestMapping(value = "/memberChangePwd")
	public String memberChangePwd() throws Exception {

		return UsrCommomMemberPath + "memberChangePwd";
	}

}
