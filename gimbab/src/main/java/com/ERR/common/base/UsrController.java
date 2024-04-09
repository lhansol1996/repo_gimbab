package com.ERR.common.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ERR.infra.party.PartyDto;
import com.ERR.infra.party.PartyService;

@Controller
public class UsrController extends BaseController{
	private String UsrCommonPath= "usr/";
	
	@Autowired
	PartyService partyService;
	
	@RequestMapping(value="/userIndex") 
	public String userIndex(Model model, PartyDto dto) throws Exception{
		model.addAttribute("partyRecentList", partyService.searchPartyForRecent5(dto));
		System.out.println(partyService.searchPartyForRecent5(dto)+"===========");
		System.out.println(partyService.searchPartyForRecent5(dto)+"===========");
		System.out.println(model.toString());
		
		return UsrCommonPath + "index";
	}

}
