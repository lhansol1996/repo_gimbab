package com.ERR.infra.member;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ERR.common.constants.Constants;
import com.ERR.common.util.UtilDateTime;

import jakarta.servlet.http.HttpSession;


@Controller
public class MemberController {
private String XdmCommomPath = "xdm/member/";
private String UsrCommonPath= "usr/";
	
	@Autowired
	MemberService service;
//	memberService memberService;
	
	public void setSearch(MemberVo vo) throws Exception {
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
	
	@RequestMapping(value="/memberXdmList")
	public String memberXdmList(@ModelAttribute("vo")MemberVo vo, Model model) throws Exception {
		System.out.println(vo.toString());
		System.out.println("-==================");
		
		
		
		model.addAttribute("list", service.selectList(vo));
//		model.addAttribute("vo", vo);
		setSearch(vo);
		System.out.println(vo.toString());
		System.out.println("-==================");
		
		return XdmCommomPath + "memberXdmList";
	}
	
	
//	@RequestMapping(value="/memberView")
//	public String memberView(memberDto dto, Model model) throws Exception{
//		/*
//		 * 넘겨 받은 변수 2개 확인하는 방법
//		 * 1번째 방법 : 받는 객체를 dto로 받는 방법
//		 * -> dto의 변수들 이름과 html에서 받는 이름이 같으면 자동으로 매핑됨(대소문자도 같아야함)
//		 */
//		System.out.println(dto.toString());
//		
//		model.addAttribute("item",service.selectOne(dto));
//		
//		return "memberView";
//	}
	
	@RequestMapping(value="/memberView")
	public String memberView(MemberDto dto, Model model) throws Exception{
	
		System.out.println("받아온 객체 ================");
		System.out.println(dto.toString());
		
		model.addAttribute("item",service.selectOne(dto));
		
		return  XdmCommomPath + "memberView";
	}
	@RequestMapping(value = "/memberUpdateForm")
	public String memberUpdateForm(Model model, MemberDto dto) throws Exception {
		
		model.addAttribute("item", service.selectOne(dto));
		return  XdmCommomPath + "memberUpdateForm";
	}
	
	@RequestMapping(value = "/memberInsertForm")
	public String memberViewUpdate(Model model) throws Exception {
		return  XdmCommomPath + "memberInsertForm";
	}

	@RequestMapping(value="/memberInsert")
	public String memberInsert(MemberDto dto ,Model model) throws Exception{
	//	System.out.println(dto.toString());

		service.insert(dto);
		return "redirect:/memberXdmList";
	}
	
	@RequestMapping(value="/memberUpdt")
	public String memberUpdt(MemberDto dto ,Model model) throws Exception{
		
		System.out.println(dto.toString()+"==========업데이트 전 ==========");
		service.update(dto);
		return "redirect:/memberXdmList";
	}
	@RequestMapping(value="/memberUelete")
	public String memberUelete(MemberDto dto ,Model model) throws Exception{
		
		service.uelete(dto);
		System.out.println(dto.toString()+"--------------삭제후-------------------------");
		return "redirect:/memberXdmList";
	}
	
	@RequestMapping(value="/memberDelete")
	public String memberDelete(MemberDto dto ,Model model) throws Exception{
		
		service.delete(dto);
		return "redirect:/memberXdmList";
	}
	
	@RequestMapping(value="/memberLoginRegisterT")
	public String memberLoginRegisterT(MemberDto dto ,Model model) throws Exception{
		
		
		return UsrCommonPath + "login-register";
	}
	
	
	@ResponseBody
	@RequestMapping(value="/memberLoginRegister")
	public Map<String, Object> memberLoginRegister(MemberDto dto, HttpSession httpSession, Model model) throws Exception{
		Map<String, Object> returnMap = new HashMap<String, Object>();

		String loginId = dto.getMemberID();
		String loginPwd = dto.getMemberPwd();
		service.selectLogin(dto);
//		dto.setMemberPwd(encodeBcrypt(loginPwd, 10));
		
//		select memberID, pwd from member where id=""; 값을 가지고 온단. 
		if(loginPwd.equals(dto.getMemberPwd()) ){
			returnMap.put("rt", "success");
		} else {
			returnMap.put("rt", "fail");
			
		}

		return returnMap;
	}
	
	public String encodeBcrypt(String planeText, int strength) {
		  return new BCryptPasswordEncoder(strength).encode(planeText);
	}

			
	public boolean matchesBcrypt(String planeText, String hashValue, int strength) {
	  BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(strength);
	  return passwordEncoder.matches(planeText, hashValue);
	}
	
}
