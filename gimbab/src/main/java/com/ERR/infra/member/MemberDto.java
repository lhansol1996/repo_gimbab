package com.ERR.infra.member;

import java.util.Date;

public class MemberDto {
	private String memberSeq;
	private String memberID;
	private String memberPwd;
	private String memberName;
	private String memberBirthday;
	private String memberEmail;
	private String memberDept;
	private Integer memberDelNy;
	private Integer memberAdminNy;
	private Integer memberTierCd;
	private double memberVictoryRate;
	private double memberKDA;
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

	public String getMemberDept() {
		return memberDept;
	}

	public void setMemberDept(String memberDept) {
		this.memberDept = memberDept;
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

	public Integer getMemberTierCd() {
		return memberTierCd;
	}

	public void setMemberTierCd(Integer memberTierCd) {
		this.memberTierCd = memberTierCd;
	}

	public double getMemberVictoryRate() {
		return memberVictoryRate;
	}

	public void setMemberVictoryRate(double memberVictoryRate) {
		this.memberVictoryRate = memberVictoryRate;
	}

	public double getMemberKDA() {
		return memberKDA;
	}

	public void setMemberKDA(double memberKDA) {
		this.memberKDA = memberKDA;
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

}
