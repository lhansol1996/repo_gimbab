package com.ERR.infra;

/**
 * Vo 공통
 */

public class BaseVo {
	private Integer voOptionDate;  /* 날짜종류(Updt,Delt,Inst) 검색 옵션 */ 
	private Integer voDelNy;      	   /* 삭제여부 검색 옵션 */
	private Integer voOption;		   /* 검색종류 옵션 */	
	private String voValue;			   /* 검색한 내용 */
	
	/* 검색할 날짜 기간 (시작일, 종료일)  */
	private String voDateStart;		  
	private String voDateEnd;
	
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
	
	@Override
	public String toString() {
		return "BaseVo [voOptionDate=" + voOptionDate + ", voDelNy=" + voDelNy + ", voOption=" + voOption + ", voValue="
				+ voValue + ", voDateStart=" + voDateStart + ", voDateEnd=" + voDateEnd + "]";
	}	
	
	

	
	
	
	
}
