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

import com.ERR.common.base.BaseController;
import com.ERR.common.constants.Constants;
import com.ERR.common.util.UtilDateTime;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController extends BaseController {

	private String XdmCommomMemberPath = "xdm/member/";
	private String UsrCommomMemberPath = "usr/member/";
	private String XdmCommomPath = "xdm/";

	@Autowired
	MemberService service;
//	memberService memberService;

	public void setSearch(MemberVo vo) throws Exception {
		/* 최초 화면 로딩시에 세팅은 문제가 없지만 */
		/* 이후 전체적으로 데이터를 조회를 하려면 null 값이 넘어 오는 관계로 문제가 전체 데이터 조회가 되지 못한다. */
		/* 해서 BaseVo.java 에서 기본값을 주어서 처리 */
//		vo.setShUseNy(vo.getShUseNy() == null ? 1 : vo.getShUseNy());
//		vo.setShDelNy(vo.getShDelNy() == null ? 0 : vo.getShDelNy());
//		vo.setShOptionDate(vo.getShOptionDate() == null ? 2 : vo.getShOptionDate());

		/* 초기값 세팅이 있는 경우 사용 */
		vo.setVoDateStart(vo.getVoDateStart() == null
				? UtilDateTime.calculateDayReplace00TimeString(UtilDateTime.nowLocalDateTime(), Constants.DATE_INTERVAL)
				: UtilDateTime.add00TimeString(vo.getVoDateStart()));
		vo.setVoDateEnd(vo.getVoDateEnd() == null ? UtilDateTime.nowString()
				: UtilDateTime.addNowTimeString(vo.getVoDateEnd()));

//		/* 초기값 세팅이 없는 경우 사용 */
//		vo.setShDateStart(vo.getShDateStart() == null || vo.getShDateStart() == "" ? null : UtilDateTime.add00TimeString(vo.getShDateStart()));
//		vo.setShDateEnd(vo.getShDateEnd() == null || vo.getShDateEnd() == "" ? null : UtilDateTime.add59TimeString(vo.getShDateEnd()));

	}

	@RequestMapping(value = "/memberXdmList")
	public String memberXdmList(@ModelAttribute("vo") MemberVo vo, Model model) throws Exception {
		setSearch(vo);

		vo.setParamsPaging(service.selectCount(vo));

		if (vo.getTotalRows() > 0) {
			model.addAttribute("list", service.selectListWithPaging(vo));
		}

		return XdmCommomMemberPath + "memberXdmList";
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

	@RequestMapping(value = "/memberView")
	public String memberView(MemberDto dto, Model model) throws Exception {

		model.addAttribute("item", service.selectOne(dto));

		return XdmCommomMemberPath + "memberView";
	}

	@RequestMapping(value = "/memberUpdateForm")
	public String memberUpdateForm(Model model, MemberDto dto) throws Exception {

		model.addAttribute("item", service.selectOne(dto));
		return XdmCommomMemberPath + "memberUpdateForm";
	}

	@RequestMapping(value = "/memberInsertForm")
	public String memberViewUpdate() throws Exception {
		return XdmCommomMemberPath + "memberInsertForm";
	}

	@RequestMapping(value = "/memberInsert")
	public String memberInsert(MemberDto dto, Model model) throws Exception {
		// System.out.println(dto.toString());
		dto.setMemberPwd(encodeBcrypt(dto.getMemberPwd(), 10));
		service.insert(dto);
		return "redirect:/memberXdmList";
	}

	@RequestMapping(value = "/memberUpdt")
	public String memberUpdt(MemberDto dto, Model model) throws Exception {

		System.out.println(dto.toString() + "==========업데이트 전 ==========");
		service.update(dto);
		return "redirect:/memberXdmList";
	}

	@RequestMapping(value = "/memberUelete")
	public String memberUelete(MemberDto dto, Model model) throws Exception {

		service.uelete(dto);
		System.out.println(dto.toString() + "--------------삭제후-------------------------");
		return "redirect:/memberXdmList";
	}

	@RequestMapping(value = "/memberDelete")
	public String memberDelete(MemberDto dto, Model model) throws Exception {

		service.delete(dto);
		return "redirect:/memberXdmList";
	}

	@RequestMapping(value = "/adminLoginRegister")
	public String adminLoginRegister() throws Exception {

		return XdmCommomPath + "member/adminLogin";
	}

	@RequestMapping(value = "/memberReg")
	public String memberReg(MemberDto dto, Model model) throws Exception {

		dto.setMemberPwd(encodeBcrypt(dto.getMemberPwd(), 10));
		service.memberReg(dto);
		return "redirect:/memberXdmList";
	}

	@ResponseBody
	@RequestMapping(value = "/memberLogin")
	public Map<String, Object> memberLogin(MemberDto dto, HttpSession httpSession, Model model) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();

		MemberDto checkDto = service.selectLogin(dto);

		if (checkDto != null) {
			String loginPwd = dto.getMemberPwd();
			String checkPwd = checkDto.getMemberPwd();
			System.out.println("++++++시작+++++++");
			if (matchesBcrypt(loginPwd, checkPwd, 10)) {
				System.out.println("성공");

				httpSession.setMaxInactiveInterval(60 * Constants.SESSION_MINUTE_XDM); // 60second * 30 = 30minute
				httpSession.setAttribute("sessMemberSeq", checkDto.getMemberSeq());
				httpSession.setAttribute("sessMemberId", checkDto.getMemberID());
				httpSession.setAttribute("sessMemberName", checkDto.getMemberName());

				returnMap.put("rt", "success");
			} else {
				System.out.println("실패");
				returnMap.put("rt", "fail");
			}

		} else {
			System.out.println("아이디값 없음실패");
			returnMap.put("rt", "fail");
		}
		System.out.println("---------------------");
		System.out.println("httpSession.getAttribute(\"sessMemberSeq\"): " + httpSession.getAttribute("sessMemberSeq"));
		System.out.println("httpSession.getAttribute(\"sessMemberId\"): " + httpSession.getAttribute("sessMemberId"));
		System.out
				.println("httpSession.getAttribute(\"sessMemberName\"): " + httpSession.getAttribute("sessMemberName"));
		System.out.println("---------------------");

		return returnMap;
	}

	@ResponseBody
	@RequestMapping(value = "/adminMemberLogin")
	public Map<String, Object> adminMemberLogin(MemberDto dto, HttpSession httpSession, Model model) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();

		MemberDto checkDto = service.selectLogin(dto);

		if (checkDto != null) {
			System.out.println("checkDto 존재 여부 체크");
			if (checkDto.getMemberAdminNy() == 1) {
				System.out.println("checkDto 관리자구분번호 체크");
				String loginPwd = dto.getMemberPwd();
				String checkPwd = checkDto.getMemberPwd();
				System.out.println("++++++시작+++++++");
				if (matchesBcrypt(loginPwd, checkPwd, 10)) {
					System.out.println("성공");

					httpSession.setMaxInactiveInterval(60 * Constants.SESSION_MINUTE_XDM); // 60second * 30 = 30minute
					httpSession.setAttribute("sessMemberSeq", checkDto.getMemberSeq());
					httpSession.setAttribute("sessMemberId", checkDto.getMemberID());
					httpSession.setAttribute("sessMemberName", checkDto.getMemberName());

					returnMap.put("rt", "success");
				} else {
					System.out.println("비밀번호 불일치 실패");
					returnMap.put("rt", "fail");
				}
			} else {
				System.out.println("관리자 권한 없음");
				returnMap.put("rt", "fail");
			}
		} else {
			System.out.println("아이디값 없음실패");
			returnMap.put("rt", "fail");
		}
		System.out.println("---------------------");
		System.out.println("httpSession.getAttribute(\"sessMemberSeq\"): " + httpSession.getAttribute("sessMemberSeq"));
		System.out.println("httpSession.getAttribute(\"sessMemberId\"): " + httpSession.getAttribute("sessMemberId"));
		System.out
				.println("httpSession.getAttribute(\"sessMemberName\"): " + httpSession.getAttribute("sessMemberName"));
		System.out.println("---------------------");

		return returnMap;
	}

	@ResponseBody
	@RequestMapping(value = "/memberLogout")
	public Map<String, Object> memberLogout(MemberDto dto, HttpSession httpSession, Model model) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		System.out.println();
		System.out.println(httpSession.getAttribute("sessMemberSeq"));
		httpSession.invalidate();

		returnMap.put("rt", "success");
		return returnMap;
	}

}
