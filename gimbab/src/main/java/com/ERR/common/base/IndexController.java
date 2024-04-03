package com.ERR.common.base;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController extends BaseController{
	
	@RequestMapping(value="/")
	public String index() throws Exception {
		
		return "portfolioIndex";
	}
}