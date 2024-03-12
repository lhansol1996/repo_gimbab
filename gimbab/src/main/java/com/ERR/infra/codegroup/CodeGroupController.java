package com.ERR.infra.codegroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ERR.common.constants.Constants;
import com.ERR.common.util.UtilDateTime;

@Controller
public class CodeGroupController {
	
	private String XdmCommomPath = "xdm/";
	
	@Autowired
	CodeGroupService service;
//	CodeGroupService codeGroupService;
	
	public void setSearch(CodeGroupVo vo) throws Exception {
		/* 최초 화면 로딩시에 세팅은 문제가 없지만 */
		/*이후 전체적으로 데이터를 조회를 하려면 null 값이 넘어 오는 관계로 문제가 전체 데이터 조회가 되지 못한다.*/
		/*해서 BaseVo.java 에서 기본값을 주어서 처리*/
//		vo.setShUseNy(vo.getShUseNy() == null ? 1 : vo.getShUseNy());
//		vo.setShDelNy(vo.getShDelNy() == null ? 0 : vo.getShDelNy());
//		vo.setShOptionDate(vo.getShOptionDate() == null ? 2 : vo.getShOptionDate());
		
		/* 초기값 세팅이 있는 경우 사용 */
		vo.setVoDateStart(vo.getVoDateStart() == null
		    ? UtilDateTime.calculateDayReplace00TimeString(UtilDateTime.nowLocalDateTime(), Constants.DATE_INTERVAL)
		    : UtilDateTime.add00TimeString(vo.getVoDateStart()));
		vo.setVoDateEnd(vo.getVoDateEnd() == null
		    ? UtilDateTime.nowString()
		    : UtilDateTime.addNowTimeString(vo.getVoDateEnd()));		
		
//		/* 초기값 세팅이 없는 경우 사용 */
//		vo.setShDateStart(vo.getShDateStart() == null || vo.getShDateStart() == "" ? null : UtilDateTime.add00TimeString(vo.getShDateStart()));
//		vo.setShDateEnd(vo.getShDateEnd() == null || vo.getShDateEnd() == "" ? null : UtilDateTime.add59TimeString(vo.getShDateEnd()));
		
		
	}
	
	@RequestMapping(value="/codeGroupXdmList")
	public String codeGroupXdmList(@ModelAttribute("vo")CodeGroupVo vo, Model model) throws Exception {
		System.out.println(vo.toString());
		System.out.println("-==================");
		
		
		
		model.addAttribute("list", service.selectList(vo));
//		model.addAttribute("vo", vo);
		setSearch(vo);
		System.out.println(vo.toString());
		System.out.println("-==================");
		
		return XdmCommomPath + "codeGroupXdmList";
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
	
		System.out.println("받아온 객체 ================");
		System.out.println(dto.toString());
		
		model.addAttribute("item",service.selectOne(dto));
		
		return  XdmCommomPath + "codeGroupDView";
	}
	@RequestMapping(value = "/codeGroupUpdateForm")
	public String codeGroupUpdateForm(Model model, CodeGroupDto dto) throws Exception {
		
		model.addAttribute("item", service.selectOne(dto));
		return  XdmCommomPath + "codeGroupUpdateForm";
	}
	
	@RequestMapping(value = "/codeGroupInsertForm")
	public String codeGroupViewUpdate(Model model) throws Exception {
		return  XdmCommomPath + "codeGroupInsertForm";
	}

	@RequestMapping(value="/codeGroupInsert")
	public String codeGroupInsert(CodeGroupDto dto ,Model model) throws Exception{
//		System.out.println(dto.toString());

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
	
	@RequestMapping(value="/")
	public String test() throws Exception{
		
		
		return  XdmCommomPath + "codeGroupInsertForm";
	}
}
