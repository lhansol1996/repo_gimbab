package com.ERR.infra.codegroup;

import java.util.List;

public interface CodeGroupDao {
	/*
	 * DAO는 인터페이스 역할로 mapper 파일과 DAO에 있는 기능 명 ex) selectList 을 맞춰주어
	 * 자동으로 매핑되게하는 인터페이스이다. 
	 * service파일의 기능등을 명시하는 인터페이스.
	 */
//	//수많은 DTO 목록들을 리스트로 리턴
//	public List<CodeGroupDto> selectList(CodeGroupVo vo);
	
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
	
	//페이징처리없는 코드그룹 리스트 리턴
	public List<CodeGroupDto> selectListWithoutPaging();
	
	//페이징 처리 리스트 
	public List<CodeGroupDto> selectListWithPaging(CodeGroupVo vo);
	
	//개수 리턴
	public Integer selectCount(CodeGroupVo vo);
	
}
