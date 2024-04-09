package com.ERR.infra.party;

import java.util.Date;

public class PartyDto {
	private String partySeq;
	private String partyName;
	private String partyDept;
	private Integer partyMatchTypeCd;
	private int partyDelNy;
	private Date partyRegDate;
	private Date partyModDate;

	private String xMemberName;
	private String xPartySeqF;
	private String xMemberSeqF;
	private String xMasterNy;
	private String xPartyJoinNy;
	private Integer xMemberTierCd;
	private Integer xMemberVitoryRate;
	private double xMemberKDA;

	public String getPartySeq() {
		return partySeq;
	}

	public void setPartySeq(String partySeq) {
		this.partySeq = partySeq;
	}

	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	public String getPartyDept() {
		return partyDept;
	}

	public void setPartyDept(String partyDept) {
		this.partyDept = partyDept;
	}

	public Integer getPartyMatchTypeCd() {
		return partyMatchTypeCd;
	}

	public void setPartyMatchTypeCd(Integer partyMatchTypeCd) {
		this.partyMatchTypeCd = partyMatchTypeCd;
	}

	public int getPartyDelNy() {
		return partyDelNy;
	}

	public void setPartyDelNy(int partyDelNy) {
		this.partyDelNy = partyDelNy;
	}

	public Date getPartyRegDate() {
		return partyRegDate;
	}

	public void setPartyRegDate(Date partyRegDate) {
		this.partyRegDate = partyRegDate;
	}

	public Date getPartyModDate() {
		return partyModDate;
	}

	public void setPartyModDate(Date partyModDate) {
		this.partyModDate = partyModDate;
	}

	public String getxMemberName() {
		return xMemberName;
	}

	public void setxMemberName(String xMemberName) {
		this.xMemberName = xMemberName;
	}

	public String getxPartySeqF() {
		return xPartySeqF;
	}

	public void setxPartySeqF(String xPartySeqF) {
		this.xPartySeqF = xPartySeqF;
	}

	public String getxMemberSeqF() {
		return xMemberSeqF;
	}

	public void setxMemberSeqF(String xMemberSeqF) {
		this.xMemberSeqF = xMemberSeqF;
	}

	public String getxMasterNy() {
		return xMasterNy;
	}

	public void setxMasterNy(String xMasterNy) {
		this.xMasterNy = xMasterNy;
	}

	public String getxPartyJoinNy() {
		return xPartyJoinNy;
	}

	public void setxPartyJoinNy(String xPartyJoinNy) {
		this.xPartyJoinNy = xPartyJoinNy;
	}

	public Integer getxMemberTierCd() {
		return xMemberTierCd;
	}

	public void setxMemberTierCd(Integer xMemberTierCd) {
		this.xMemberTierCd = xMemberTierCd;
	}

	public Integer getxMemberVitoryRate() {
		return xMemberVitoryRate;
	}

	public void setxMemberVitoryRate(Integer xMemberVitoryRate) {
		this.xMemberVitoryRate = xMemberVitoryRate;
	}

	public double getxMemberKDA() {
		return xMemberKDA;
	}

	public void setxMemberKDA(double xMemberKDA) {
		this.xMemberKDA = xMemberKDA;
	}

	@Override
	public String toString() {
		return "PartyDto [partySeq=" + partySeq + ", partyName=" + partyName + ", partyDept=" + partyDept
				+ ", partyMatchTypeCd=" + partyMatchTypeCd + ", partyDelNy=" + partyDelNy + ", partyRegDate="
				+ partyRegDate + ", partyModDate=" + partyModDate + ", xMemberName=" + xMemberName + ", xPartySeqF="
				+ xPartySeqF + ", xMemberSeqF=" + xMemberSeqF + ", xMasterNy=" + xMasterNy + ", xPartyJoinNy="
				+ xPartyJoinNy + ", xMemberTierCd=" + xMemberTierCd + ", xMemberVitoryRate=" + xMemberVitoryRate
				+ ", xMemberKDA=" + xMemberKDA + "]";
	}

	
	
}
