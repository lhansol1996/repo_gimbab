package com.ERR.infra.party;

import java.util.Date;

public class PartyDto {
	private String partySeq;
	private String partyName;
	private String partyDept;
	private Integer partyOwnerTierCd;
	private Integer partyMatchTypeCd;
	private double partyOwnerRate;
	private double partyOwnerKDA;
	private int partyDelNy;
	private Date partyRegDate;
	private Date partyModDate;
	
	private String xMemberName;
	private String xPartySeqF;
	private String xMemberSeqF;
	
	
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
	public Integer getPartyOwnerTierCd() {
		return partyOwnerTierCd;
	}
	public void setPartyOwnerTierCd(Integer partyOwnerTierCd) {
		this.partyOwnerTierCd = partyOwnerTierCd;
	}
	public Integer getPartyMatchTypeCd() {
		return partyMatchTypeCd;
	}
	public void setPartyMatchTypeCd(Integer partyMatchTypeCd) {
		this.partyMatchTypeCd = partyMatchTypeCd;
	}
	public double getPartyOwnerRate() {
		return partyOwnerRate;
	}
	public void setPartyOwnerRate(double partyOwnerRate) {
		this.partyOwnerRate = partyOwnerRate;
	}
	public double getPartyOwnerKDA() {
		return partyOwnerKDA;
	}
	public void setPartyOwnerKDA(double partyOwnerKDA) {
		this.partyOwnerKDA = partyOwnerKDA;
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

	
	
}
