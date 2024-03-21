package com.ERR.infra.code;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CodeDto {
	private String codeSeq;
	private String codeName;
	private Integer codeDelNy;
	private Date codeRegDate;
	private Date codeModDate;
	
	private String codeGroupSeqF;
	private String xcodeGroupName;
	
//	캐시사용을 위한 list 생성
	public static List<CodeDto> cachedCodeArrayList = new ArrayList<CodeDto>();
	
	CodeDto () {}

	public String getCodeSeq() {
		return codeSeq;
	}

	public void setCodeSeq(String codeSeq) {
		this.codeSeq = codeSeq;
	}

	public String getCodeName() {
		return codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

	
	public Integer getCodeDelNy() {
		return codeDelNy;
	}

	public void setCodeDelNy(Integer codeDelNy) {
		this.codeDelNy = codeDelNy;
	}

	public Date getCodeRegDate() {
		return codeRegDate;
	}

	public void setCodeRegDate(Date codeRegDate) {
		this.codeRegDate = codeRegDate;
	}

	public Date getCodeModDate() {
		return codeModDate;
	}

	public void setCodeModDate(Date codeModDate) {
		this.codeModDate = codeModDate;
	}

	public String getCodeGroupSeqF() {
		return codeGroupSeqF;
	}

	public void setCodeGroupSeqF(String codeGroupSeqF) {
		this.codeGroupSeqF = codeGroupSeqF;
	}

	public String getXcodeGroupName() {
		return xcodeGroupName;
	}

	public void setXcodeGroupName(String xcodeGroupName) {
		this.xcodeGroupName = xcodeGroupName;
	}

	@Override
	public String toString() {
		return "CodeDto [codeSeq=" + codeSeq + ", codeName=" + codeName +" , codeDelNy="
				+ codeDelNy + ", codeRegDate=" + codeRegDate + ", codeModDate=" + codeModDate + ", codeGroupSeqF="
				+ codeGroupSeqF + ", xcodeGroupName=" + xcodeGroupName + "]";
	}

	
	
	
	
	
	
}
