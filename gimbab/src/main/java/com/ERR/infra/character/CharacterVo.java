package com.ERR.infra.character;

import com.ERR.common.base.BaseVo;

public class CharacterVo extends BaseVo {
	private String characterSeq;
	private String characterName;

	public String getCharacterSeq() {
		return characterSeq;
	}

	public void setCharacterSeq(String characterSeq) {
		this.characterSeq = characterSeq;
	}

	public String getCharacterName() {
		return characterName;
	}

	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}

}
