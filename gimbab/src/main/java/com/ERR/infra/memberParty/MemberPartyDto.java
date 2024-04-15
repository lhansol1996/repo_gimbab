package com.ERR.infra.memberParty;

import java.util.Date;

public class MemberPartyDto {
	private String memberPartySeq;
	private String memberSeqF;
	private String partySeqF;
	private Integer masterNy;
	private Integer partyJoinNy;
	private Date partyJoinDate;
	private Date partyOutDate;

	public String getMemberPartySeq() {
		return memberPartySeq;
	}

	public void setMemberPartySeq(String memberPartySeq) {
		this.memberPartySeq = memberPartySeq;
	}

	public String getMemberSeqF() {
		return memberSeqF;
	}

	public void setMemberSeqF(String memberSeqF) {
		this.memberSeqF = memberSeqF;
	}

	public String getPartySeqF() {
		return partySeqF;
	}

	public void setPartySeqF(String partySeqF) {
		this.partySeqF = partySeqF;
	}

	public Integer getMasterNy() {
		return masterNy;
	}

	public void setMasterNy(Integer masterNy) {
		this.masterNy = masterNy;
	}

	public Integer getPartyJoinNy() {
		return partyJoinNy;
	}

	public void setPartyJoinNy(Integer partyJoinNy) {
		this.partyJoinNy = partyJoinNy;
	}

	public Date getPartyJoinDate() {
		return partyJoinDate;
	}

	public void setPartyJoinDate(Date partyJoinDate) {
		this.partyJoinDate = partyJoinDate;
	}

	public Date getPartyOutDate() {
		return partyOutDate;
	}

	public void setPartyOutDate(Date partyOutDate) {
		this.partyOutDate = partyOutDate;
	}

}
