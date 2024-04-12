package com.ERR.infra.member;

import com.ERR.common.base.BaseVo;

public class MemberVo extends BaseVo {

	private String memberSeq;
	private String memberID;
	private String memberPwd;
	private String memberName;
	private String memberBirthday;
	private String memberEmail;
	private String memberDept;

	// 관리자 , 사용자 구분자
	private Integer memberAdminNy = 1;
	private Integer memberGenderCd;

	public String getMemberSeq() {
		return memberSeq;
	}

	public void setMemberSeq(String memberSeq) {
		this.memberSeq = memberSeq;
	}

	public String getMemberID() {
		return memberID;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}

	public String getMemberPwd() {
		return memberPwd;
	}

	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberBirthday() {
		return memberBirthday;
	}

	public void setMemberBirthday(String memberBirthday) {
		this.memberBirthday = memberBirthday;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberDept() {
		return memberDept;
	}

	public void setMemberDept(String memberDept) {
		this.memberDept = memberDept;
	}

	public Integer getMemberAdminNy() {
		return memberAdminNy;
	}

	public void setMemberAdminNy(Integer memberAdminNy) {
		this.memberAdminNy = memberAdminNy;
	}

	public Integer getMemberGenderCd() {
		return memberGenderCd;
	}

	public void setMemberGenderCd(Integer memberGenderCd) {
		this.memberGenderCd = memberGenderCd;
	}

}
