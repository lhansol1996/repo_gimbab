package com.ERR.common.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ERR.infra.character.CharacterService;

@Controller
public class UsrController extends BaseController{
	private String UsrCommonPath= "usr/";
	
	@Autowired
	CharacterService characterService;
	
	
	@RequestMapping(value="/userIndex") 
	public String userIndex() throws Exception{
		
		
		return UsrCommonPath + "index";
	}
}
