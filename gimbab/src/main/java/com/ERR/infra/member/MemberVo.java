package com.ERR.infra.member;

import java.util.Date;

import com.ERR.infra.BaseVo;

public class MemberVo extends BaseVo {

	private String memberSeq;
	private String memberID;
	private String memberPwd;
	private String memberBirthday;
	private String memberEmail;
	private String memberDpt;

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

	public String getMemberDpt() {
		return memberDpt;
	}

	public void setMemberDpt(String memberDpt) {
		this.memberDpt = memberDpt;
	}

}
