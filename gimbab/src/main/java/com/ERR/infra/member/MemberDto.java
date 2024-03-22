package com.ERR.infra.member;

import java.util.Date;

public class MemberDto {
	private String memberSeq;
	private String memberID;
	private String memberPwd;
	private String memberName;
	private String memberBirthday;
	private String memberEmail;
	private String memberDpt;
	private Integer memberDelNy;
	private Integer memberAdminNy;
	private Integer memberGenderCd;
	private Date memberRegDate;
	private Date memberModDate;
	
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
	public String getMemberDpt() {
		return memberDpt;
	}
	public void setMemberDpt(String memberDpt) {
		this.memberDpt = memberDpt;
	}
	public Integer getMemberDelNy() {
		return memberDelNy;
	}
	public void setMemberDelNy(Integer memberDelNy) {
		this.memberDelNy = memberDelNy;
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
	public Date getMemberRegDate() {
		return memberRegDate;
	}
	public void setMemberRegDate(Date memberRegDate) {
		this.memberRegDate = memberRegDate;
	}
	public Date getMemberModDate() {
		return memberModDate;
	}
	public void setMemberModDate(Date memberModDate) {
		this.memberModDate = memberModDate;
	}
	@Override
	public String toString() {
		return "MemberDto [memberSeq=" + memberSeq + ", memberID=" + memberID + ", memberPwd=" + memberPwd
				+ ", memberName=" + memberName + ", memberBirthday=" + memberBirthday + ", memberEmail=" + memberEmail
				+ ", memberDpt=" + memberDpt + ", memberDelNy=" + memberDelNy + ", memberAdminNy=" + memberAdminNy
				+ ", memberGenderCd=" + memberGenderCd + ", memberRegDate=" + memberRegDate + ", memberModDate="
				+ memberModDate + "]";
	}

	

}
