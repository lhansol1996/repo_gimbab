package com.ERR.common.base;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ERR.common.constants.Constants;
import com.ERR.common.util.UtilDateTime;

@Controller
public class BaseController {
	
	public BaseController() {
        // 실행되는 주체를 확인하기 위해서 클래스 이름을 콘솔에 출력.
    	String className = this.getClass().getName();
    	System.out.println(className);
    }
	
	/**
	 * 암호화 작업 메소드
	 * @param planeText : 입력받을 param
	 * @param strength  : 암호화 방법
	 * @return
	 */
	public String encodeBcrypt(String planeText, int strength) {
		  return new BCryptPasswordEncoder(strength).encode(planeText);
	}

	/**
	 * 
	 * @param planeText : 입력받을 param
	 * @param hashValue : 비교할 param
	 * @param strength : 암호화 방법
	 * @return
	 */
	public boolean matchesBcrypt(String planeText, String hashValue, int strength) {
	  BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(strength);
	  return passwordEncoder.matches(planeText, hashValue);
	}

	
/*	public void setSearch(BaseVo vo) throws Exception {
//		 최초 화면 로딩시에 세팅은 문제가 없지만 
//		이후 전체적으로 데이터를 조회를 하려면 null 값이 넘어 오는 관계로 문제가 전체 데이터 조회가 되지 못한다.
//		해서 BaseVo.java 에서 기본값을 주어서 처리
//		vo.setShUseNy(vo.getShUseNy() == null ? 1 : vo.getShUseNy());
//		vo.setShDelNy(vo.getShDelNy() == null ? 0 : vo.getShDelNy());
//		vo.setShOptionDate(vo.getShOptionDate() == null ? 2 : vo.getShOptionDate());
		
//		 초기값 세팅이 있는 경우 사용 
		vo.setVoDateStart(vo.getVoDateStart() == null
		    ? UtilDateTime.calculateDayReplace00TimeString(UtilDateTime.nowLocalDateTime(), Constants.DATE_INTERVAL)
		    : UtilDateTime.add00TimeString(vo.getVoDateStart()));
		vo.setVoDateEnd(vo.getVoDateEnd() == null
		    ? UtilDateTime.nowString()
		    : UtilDateTime.addNowTimeString(vo.getVoDateEnd()));		
		
//		 초기값 세팅이 없는 경우 사용 
//		vo.setShDateStart(vo.getShDateStart() == null || vo.getShDateStart() == "" ? null : UtilDateTime.add00TimeString(vo.getShDateStart()));
//		vo.setShDateEnd(vo.getShDateEnd() == null || vo.getShDateEnd() == "" ? null : UtilDateTime.add59TimeString(vo.getShDateEnd()));
		}
	*/
		
	
}
