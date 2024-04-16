package com.ERR.infra.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ERR.common.base.BaseController;
import com.ERR.common.constants.Constants;
import com.ERR.common.util.UtilDateTime;
import com.ERR.common.util.UtilSetSearch;
import com.ERR.infra.codegroup.CodeGroupService;

@Controller
public class CodeController extends BaseController {

	private String XdmCodeCommomPath = "xdm/code/";

	@Autowired
	CodeService codeService;
	@Autowired
	CodeGroupService codeGroupService;


	@RequestMapping(value = "/codeXdmList")
	public String codeXdmList(@ModelAttribute("vo") CodeVo vo, Model model) throws Exception {
		UtilSetSearch.setSearch(vo);

		vo.setParamsPaging(codeService.selectCount(vo));

		if (vo.getTotalRows() > 0) {
			model.addAttribute("list", codeService.selectListWithPaging(vo));
		}

		return XdmCodeCommomPath + "codeXdmList";
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

	@RequestMapping(value = "/codeView")
	public String codeView(CodeDto dto, Model model) throws Exception {

		model.addAttribute("item", codeService.selectOne(dto));

		return XdmCodeCommomPath + "codeView";
	}

	@RequestMapping(value = "/codeUpdateForm")
	public String codeUpdateForm(Model model, CodeDto dto) throws Exception {

		model.addAttribute("item", codeService.selectOne(dto));
		return XdmCodeCommomPath + "codeUpdateForm";
	}

	@RequestMapping(value = "/codeInsertForm")
	public String codeInsertForm(Model model) throws Exception {
		model.addAttribute("codeGroupList", codeGroupService.selectListWithoutPaging());
		System.out.println(model + "==================================================");
		return XdmCodeCommomPath + "codeInsertForm";
	}

	@RequestMapping(value = "/codeInsert")
	public String codeInsert(CodeDto dto, Model model) throws Exception {
		System.out.println("==================================================");
		codeService.insert(dto);
		return "redirect:/codeXdmList";
	}

	@RequestMapping(value = "/codeUpdt")
	public String codeUpdt(CodeDto dto, Model model) throws Exception {

		System.out.println(dto.toString() + "==========업데이트 전 ==========");
		codeService.update(dto);
		return "redirect:/codeXdmList";
	}

	@RequestMapping(value = "/codeUelete")
	public String codeUelete(CodeDto dto, Model model) throws Exception {

		codeService.uelete(dto);
		System.out.println(dto.toString() + "--------------삭제후-------------------------");
		return "redirect:/codeXdmList";
	}

	@RequestMapping(value = "/codeDelete")
	public String codeDelete(CodeDto dto, Model model) throws Exception {

		codeService.delete(dto);
		return "redirect:/codeXdmList";
	}
}
