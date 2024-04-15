package com.ERR.infra.party;

import com.ERR.common.base.BaseVo;

public class PartyVo extends BaseVo {
	private String voPartySeq;
	private String voPartyName;
	private String voPartyMatchTypeCd;
	
	private String voXMemberName;
	private String voXPartySeqF;
	private String voXMemberSeqF;
	private Integer voXMemberTierCd;

	public String getVoPartySeq() {
		return voPartySeq;
	}

	public void setVoPartySeq(String voPartySeq) {
		this.voPartySeq = voPartySeq;
	}

	public String getVoPartyName() {
		return voPartyName;
	}

	public void setVoPartyName(String voPartyName) {
		this.voPartyName = voPartyName;
	}

	public String getVoPartyMatchTypeCd() {
		return voPartyMatchTypeCd;
	}

	public void setVoPartyMatchTypeCd(String voPartyMatchTypeCd) {
		this.voPartyMatchTypeCd = voPartyMatchTypeCd;
	}

	public Integer getVoXMemberTierCd() {
		return voXMemberTierCd;
	}

	public void setVoXMemberTierCd(Integer voXMemberTierCd) {
		this.voXMemberTierCd = voXMemberTierCd;
	}

	public String getVoXMemberName() {
		return voXMemberName;
	}

	public void setVoXMemberName(String voXMemberName) {
		this.voXMemberName = voXMemberName;
	}

	public String getVoXPartySeqF() {
		return voXPartySeqF;
	}

	public void setVoXPartySeqF(String voXPartySeqF) {
		this.voXPartySeqF = voXPartySeqF;
	}

	public String getVoXMemberSeqF() {
		return voXMemberSeqF;
	}

	public void setVoXMemberSeqF(String voXMemberSeqF) {
		this.voXMemberSeqF = voXMemberSeqF;
	}

}
