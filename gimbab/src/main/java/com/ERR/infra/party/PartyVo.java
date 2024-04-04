package com.ERR.infra.party;

import com.ERR.common.base.BaseVo;

public class PartyVo extends BaseVo {
	private String partySeq;
	private String partyName;
	private String MatchType;

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

	public String getMatchType() {
		return MatchType;
	}

	public void setMatchType(String matchType) {
		MatchType = matchType;
	}

}
