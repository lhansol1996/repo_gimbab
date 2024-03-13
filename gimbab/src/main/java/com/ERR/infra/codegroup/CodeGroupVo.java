package com.ERR.infra.codegroup;

public class CodeGroupVo {
	private Integer voOptionDate;  /* 날짜종류(Updt,Delt,Inst) 검색 옵션 */ 
	private Integer voDelNy;      	   /* 삭제여부 검색 옵션 */
	private Integer voOption;		   /* 검색종류 옵션 */	
	private String voValue;			   /* 검색한 내용 */
	
	/* 검색할 날짜 기간 (시작일, 종료일)  */
	private String voDateStart;		  
	private String voDateEnd;	
	
	/*
	 * 코드 검색할 시 코드번호 검색 값과 시퀀스 번호 값 비교를 위함. 
	 */
	private String seq;

	public Integer getVoOptionDate() {
		return voOptionDate;
	}

	public void setVoOptionDate(Integer voOptionDate) {
		this.voOptionDate = voOptionDate;
	}

	public Integer getVoDelNy() {
		return voDelNy;
	}

	public void setVoDelNy(Integer voDelNy) {
		this.voDelNy = voDelNy;
	}

	public Integer getVoOption() {
		return voOption;
	}

	public void setVoOption(Integer voOption) {
		this.voOption = voOption;
	}

	public String getVoValue() {
		return voValue;
	}

	public void setVoValue(String voValue) {
		this.voValue = voValue;
	}

	public String getVoDateStart() {
		return voDateStart;
	}

	public void setVoDateStart(String voDateStart) {
		this.voDateStart = voDateStart;
	}

	public String getVoDateEnd() {
		return voDateEnd;
	}

	public void setVoDateEnd(String voDateEnd) {
		this.voDateEnd = voDateEnd;
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	@Override
	public String toString() {
		return "CodeGroupVo [voOptionDate=" + voOptionDate + ", voDelNy=" + voDelNy + ", voOption=" + voOption
				+ ", voValue=" + voValue + ", voDateStart=" + voDateStart + ", voDateEnd=" + voDateEnd + ", seq=" + seq
				+ "]";
	}  
	
	
	
	
	
}
