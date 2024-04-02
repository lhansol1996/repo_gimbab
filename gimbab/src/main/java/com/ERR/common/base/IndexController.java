package com.ERR.common.base;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController extends BaseController{
	
	@RequestMapping(value="/1")
	public String index() throws Exception {
		
		return "portfolioIndex";
	}
}