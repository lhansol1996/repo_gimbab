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

	

	
}
