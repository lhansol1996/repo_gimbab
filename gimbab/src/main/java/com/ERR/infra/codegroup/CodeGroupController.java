package com.ERR.infra.codegroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ERR.common.base.BaseController;
import com.ERR.common.constants.Constants;
import com.ERR.common.util.UtilDateTime;
import com.ERR.common.util.UtilSetSearch;

@Controller
public class CodeGroupController extends BaseController{
	
	private String XdmCdgCommomPath = "xdm/cdg/";
	
	@Autowired
	CodeGroupService service;
//	CodeGroupService codeGroupService;
	
	

	
	@RequestMapping(value="/codeGroupXdmList")
	public String codeGroupXdmList(@ModelAttribute("vo")CodeGroupVo vo, Model model) throws Exception {
		UtilSetSearch.setSearch(vo);

		
		vo.setParamsPaging(service.selectCount(vo));
		
		if (vo.getTotalRows() > 0) {
			model.addAttribute("list", service.selectListWithPaging(vo));
		}
		
		return XdmCdgCommomPath + "codeGroupXdmList";
	}
	
	
//	@RequestMapping(value="/codeGroupView")
//	public String codeGroupView(CodeGroupDto dto, Model model) throws Exception{
//		/*
//		 * 넘겨 받은 변수 2개 확인하는 방법
//		 * 1번째 방법 : 받는 객체를 dto로 받는 방법
//		 * -> dto의 변수들 이름과 html에서 받는 이름이 같으면 자동으로 매핑됨(대소문자도 같아야함)
//		 */
//		System.out.println(dto.toString());
//		
//		model.addAttribute("item",service.selectOne(dto));
//		
//		return "codeGroupView";
//	}
	
	@RequestMapping(value="/codeGroupDView")
	public String codeGroupView(CodeGroupDto dto, Model model) throws Exception{
	
		model.addAttribute("item",service.selectOne(dto));
		
		return  XdmCdgCommomPath + "codeGroupDView";
	}
	@RequestMapping(value = "/codeGroupUpdateForm")
	public String codeGroupUpdateForm(Model model, CodeGroupDto dto) throws Exception {
		
		model.addAttribute("item", service.selectOne(dto));
		return  XdmCdgCommomPath + "codeGroupUpdateForm";
	}
	
	@RequestMapping(value = "/codeGroupInsertForm")
	public String codeGroupViewUpdate(Model model) throws Exception {
		return  XdmCdgCommomPath + "codeGroupInsertForm";
	}

	@RequestMapping(value="/codeGroupInsert")
	public String codeGroupInsert(CodeGroupDto dto ,Model model) throws Exception{
	//	System.out.println(dto.toString());

		service.insert(dto);
		return "redirect:/codeGroupXdmList";
	}
	
	@RequestMapping(value="/codeGroupUpdt")
	public String codeGroupUpdt(CodeGroupDto dto ,Model model) throws Exception{
		
		System.out.println(dto.toString()+"==========업데이트 전 ==========");
		service.update(dto);
		return "redirect:/codeGroupXdmList";
	}
	@RequestMapping(value="/codeGroupUelete")
	public String codeGroupUelete(CodeGroupDto dto ,Model model) throws Exception{
		
		service.uelete(dto);
		System.out.println(dto.toString()+"--------------삭제후-------------------------");
		return "redirect:/codeGroupXdmList";
	}
	
	@RequestMapping(value="/codeGroupDelete")
	public String codeGroupDelete(CodeGroupDto dto ,Model model) throws Exception{
		
		service.delete(dto);
		return "redirect:/codeGroupXdmList";
	}
	
}
