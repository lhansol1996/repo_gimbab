package com.ERR.infra.code;

import java.util.List;

public interface CodeDao {

	// 수많은 DTO 목록들을 리스트로 리턴 - 페이징 처리
	public List<CodeDto> selectListWithPaging(CodeVo vo);

	//페이징 처리안된 리스트 리턴
	public List<CodeDto> selectListWithoutPaging();
	
	// 개수 리턴
	public Integer selectCount(CodeVo vo);

	// DTO 중 하나를 리턴
	public CodeDto selectOne(CodeDto dto);

	// 등록 버튼
	public int insert(CodeDto dto);

	// 수정 버튼
	public int update(CodeDto dto);

	// 삭제 버튼
	public int uelete(CodeDto dto);

	// 삭제 버튼(drop)
	public int delete(CodeDto dto);

	// 캐시사용 서비스
	public List<CodeDto> selectListCachedCodeArrayList();

}
