package com.ERR.infra.code;

import java.util.Date;

public class CodeDto {
	private String seq;
	private String name;
	private String memo;
	private Integer delNy;
	private Date regDate;
	private Date modDate;
	
	private String xcodeGroupSeq;
	private String xcodeGroupName;
	
	CodeDto () {}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public Integer getDelNy() {
		return delNy;
	}
	public void setDelNy(Integer delNy) {
		this.delNy = delNy;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Date getModDate() {
		return modDate;
	}
	public void setModDate(Date modDate) {
		this.modDate = modDate;
	}
	public String getXcodeGroupSeq() {
		return xcodeGroupSeq;
	}
	public void setXcodeGroupSeq(String xcodeGroupSeq) {
		this.xcodeGroupSeq = xcodeGroupSeq;
	}
	public String getXcodeGroupName() {
		return xcodeGroupName;
	}
	public void setXcodeGroupName(String xcodeGroupName) {
		this.xcodeGroupName = xcodeGroupName;
	}
	@Override
	public String toString() {
		return "CodeDto [seq=" + seq + ", name=" + name + ", delNy=" + delNy + ", regDate=" + regDate + ", modDate="
				+ modDate + ", xcodeGroupSeq=" + xcodeGroupSeq + ", xcodeGroupName=" + xcodeGroupName + "]";
	}
	
	
	
	
	
	
}
