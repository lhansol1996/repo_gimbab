package com.ERR.infra.character;

import java.util.List;

public interface CharacterDao {
	// DTO 중 하나를 리턴
	public CharacterDto selectOne(CharacterDto dto);
	
	// DTO 중 이름값으로 하나를 리턴
		public CharacterDto selectOneByName(CharacterDto dto);

	// 등록 버튼
	public int insert(CharacterDto dto);

	// 수정 버튼
	public int update(CharacterDto dto);

	// 삭제 버튼
	public int uelete(CharacterDto dto);

	// 삭제 버튼(drop)
	public int delete(CharacterDto dto);

	// 페이징처리없는 코드그룹 리스트 리턴
	public List<CharacterDto> selectListWithoutPaging();

	// 페이징 처리 리스트
	public List<CharacterDto> selectListWithPaging(CharacterVo vo);

	// 개수 리턴
	public Integer selectCount(CharacterVo vo);

}
