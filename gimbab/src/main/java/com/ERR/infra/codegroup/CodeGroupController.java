package com.ERR.infra.codegroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CodeGroupController {
	
	@Autowired
//	CodeGroupService codeGroupService;
	CodeGroupService service;
	
	@RequestMapping(value="/tables")
	public String codeGroupXdmList(Model model) throws Exception {
		
//		List <CodeGroupDto> codeGroupDtos = codeGroupService.selectList();	
//			model.addAttribute("listcodeGroups", codeGroupDtos);
		
		model.addAttribute("list", service.selectList());
			
		
		return "xdm/tables";
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
	
	@RequestMapping(value="/codeGroupView")
	public String codeGroupView(CodeGroupDto dto, Model model) throws Exception{
	
		System.out.println("받아온 객체 ================");
		System.out.println(dto.toString());
		
		model.addAttribute("item",service.selectOne(dto));
		
		return "xdm/codeGroupView";
	}
	
	@RequestMapping(value = "/codeGroupInsertForm")
	public String codeGroupViewUpdate(Model model) throws Exception {
		return "xdm/codeGroupInsertForm";
	}

	@RequestMapping(value="/codeGroupInsert")
	public String codeGroupInsert(CodeGroupDto dto ,Model model) throws Exception{
//		System.out.println(dto.toString());

		service.insert(dto);
		return "redirect:/tables";
	}
	
	@RequestMapping(value="/codeGroupUpdt")
	public String codeGroupUpdt(CodeGroupDto dto ,Model model) throws Exception{
		
		System.out.println(dto.toString()+"==========업데이트 전 ==========");
		service.update(dto);
		return "redirect:/tables";
	}
	@RequestMapping(value="/codeGroupUelete")
	public String codeGroupUelete(CodeGroupDto dto ,Model model) throws Exception{
		
		service.uelete(dto);
		System.out.println(dto.toString()+"--------------삭제후-------------------------");
		return "redirect:/tables";
	}
	
	@RequestMapping(value="/codeGroupDelete")
	public String codeGroupDelete(CodeGroupDto dto ,Model model) throws Exception{
		
		service.delete(dto);
		return "redirect:/codeGroupXdmList";
	}
	
	@RequestMapping(value="/")
	public String test() throws Exception{
		
		
		return "xdm/codeGroupInsertForm";
	}
}
