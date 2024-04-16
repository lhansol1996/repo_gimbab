package com.ERR.infra.character;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ERR.common.base.BaseController;
import com.ERR.common.constants.Constants;
import com.ERR.common.util.UtilDateTime;
import com.ERR.common.util.UtilSetSearch;

@Controller
public class CharacterController extends BaseController {

	private String XdmCharacterCommonPath = "xdm/character/";
	private String UsrCharacterCommonPath = "usr/character/";

	@Autowired
	CharacterService characterService;

	
	@RequestMapping(value = "/characterXdmList")
	public String characterXdmList(@ModelAttribute("vo") CharacterVo vo, Model model) throws Exception {

		UtilSetSearch.setSearch(vo);
		vo.setParamsPaging(characterService.selectCount(vo));
		if (vo.getTotalRows() > 0) {
			model.addAttribute("list", characterService.selectListWithPaging(vo));
		}

		return XdmCharacterCommonPath + "characterXdmList";
	}

	@RequestMapping(value = "/characterView")
	public String characterView(CharacterDto dto, Model model) throws Exception {

		model.addAttribute("item", characterService.selectOne(dto));
		return XdmCharacterCommonPath + "characterView";
	}

	@RequestMapping(value = "/characterUpdateForm")
	public String characterUpdateForm(Model model, CharacterDto dto) throws Exception {

		model.addAttribute("item", characterService.selectOne(dto));
		return XdmCharacterCommonPath + "characterUpdateForm";
	}

	@RequestMapping(value = "/characterInsertForm")
	public String characterViewUpdate(Model model) throws Exception {

		return XdmCharacterCommonPath + "characterInsertForm";
	}

	@RequestMapping(value = "/characterInsert")
	public String characterInsert(CharacterDto dto, Model model) throws Exception {

		characterService.insert(dto);
		return "redirect:/characterXdmList";
	}

	@RequestMapping(value = "/characterUpdt")
	public String characterUpdt(CharacterDto dto, Model model) throws Exception {

		characterService.update(dto);
		return "redirect:/characterXdmList";
	}

	@RequestMapping(value = "/characterUelete")
	public String characterUelete(CharacterDto dto, Model model) throws Exception {

		characterService.uelete(dto);
		return "redirect:/characterXdmList";
	}

	@RequestMapping(value = "/characterDelete")
	public String characterDelete(CharacterDto dto, Model model) throws Exception {

		characterService.delete(dto);
		return "redirect:/characterXdmList";
	}

	@RequestMapping(value = "/characterDetail")
	public String characterDetail(Model model, CharacterDto dto) throws Exception {

		CharacterDto character = characterService.selectOneByName(dto);

		if (character != null) {
			if (Constants.CHARACTER_NAMES.contains(character.getCharacterName())) {
				model.addAttribute("item", character);
				System.out.println(model);
				return UsrCharacterCommonPath + "character-detail";
			} else {
				return "";
			}
		}
		return "";
	}

}
