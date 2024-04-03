package com.ERR.infra.character;

import java.util.Date;

public class CharacterDto {
	private String characterSeq;
	private String characterName;
	private int characterHp;
	private int characterMp;
	private int characterDef;
	private int characterAtk;
	private String characterVideoPath;
	private String characterDept;
	private int characterDelNy;
	private Date characterRegDate;
	private Date characterModDate;
	
	private String XtopBarSearchInputValue;

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

	public int getCharacterHp() {
		return characterHp;
	}

	public void setCharacterHp(int characterHp) {
		this.characterHp = characterHp;
	}

	public int getCharacterMp() {
		return characterMp;
	}

	public void setCharacterMp(int characterMp) {
		this.characterMp = characterMp;
	}

	public int getCharacterDef() {
		return characterDef;
	}

	public void setCharacterDef(int characterDef) {
		this.characterDef = characterDef;
	}

	public int getCharacterAtk() {
		return characterAtk;
	}

	public void setCharacterAtk(int characterAtk) {
		this.characterAtk = characterAtk;
	}

	public String getCharacterVideoPath() {
		return characterVideoPath;
	}

	public void setCharacterVideoPath(String characterVideoPath) {
		this.characterVideoPath = characterVideoPath;
	}

	public int getCharacterDelNy() {
		return characterDelNy;
	}

	public void setCharacterDelNy(int characterDelNy) {
		this.characterDelNy = characterDelNy;
	}

	public Date getCharacterRegDate() {
		return characterRegDate;
	}

	public void setCharacterRegDate(Date characterRegDate) {
		this.characterRegDate = characterRegDate;
	}

	public Date getCharacterModDate() {
		return characterModDate;
	}

	public void setCharacterModDate(Date characterModDate) {
		this.characterModDate = characterModDate;
	}

	public String getCharacterDept() {
		return characterDept;
	}

	public void setCharacterDept(String characterDept) {
		this.characterDept = characterDept;
	}

	public String getXtopBarSearchInputValue() {
		return XtopBarSearchInputValue;
	}

	public void setXtopBarSearchInputValue(String xtopBarSearchInputValue) {
		XtopBarSearchInputValue = xtopBarSearchInputValue;
	}
	
	

}
