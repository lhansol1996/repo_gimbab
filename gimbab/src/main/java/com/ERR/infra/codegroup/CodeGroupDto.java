package com.ERR.infra.codegroup;

import java.util.Date;

public class CodeGroupDto {
	private String seq;
	private String name;
	private Integer delNy;
	private Date regDate;
	private Date modDate;
	
	private Integer xcount;
	
	public Integer getXcount() {
		return xcount;
	}
	public void setXcount(Integer xcount) {
		this.xcount = xcount;
	}
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
	@Override
	public String toString() {
		return "CodeGroupDto [seq=" + seq + ", name=" + name + ", delNy=" + delNy + ", regDate=" + regDate
				+ ", modDate=" + modDate + ", xcount=" + xcount + "]";
	}

	
	
	
	
}
