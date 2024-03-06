package com.ERR.infra.codegroup;

import java.util.List;

public interface CodeGroupDao {
	/*
	 * DAO는 인터페이스 역할로 mapper 파일과 DAO에 있는 기능 명 ex) selectList 을 맞춰주어
	 * 자동으로 매핑되게하는 인터페이스이다. 
	 * service파일의 기능등을 명시하는 인터페이스.
	 */
	//수많은 DTO 목록들을 리스트로 리턴
	public List<CodeGroupDto> selectList();
	
	//DTO 중 하나를 리턴
	public CodeGroupDto selectOne(CodeGroupDto dto);
	
	//등록 버튼
	public int insert(CodeGroupDto dto);
	
	//수정 버튼
	public int update(CodeGroupDto dto);
	
	//삭제 버튼
	public int uelete(CodeGroupDto dto);
	
	//삭제 버튼(drop)
	public int delete(CodeGroupDto dto);
}
