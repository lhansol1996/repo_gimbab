package com.ERR.common.base;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UsrController extends BaseController{
	private String UsrCommonPath= "usr/";
	

	
	@RequestMapping(value="/userIndex") 
	public String userIndex() throws Exception{
		
		
		return UsrCommonPath + "index";
	}

}
