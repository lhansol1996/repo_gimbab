package com.ERR.infra.party;

import java.util.List;

public interface PartyDao {

	// DTO 중 하나를 리턴
	public PartyDto selectOne(PartyDto dto);

	// 등록 버튼
	public int insert(PartyDto dto);

	// 수정 버튼
	public int update(PartyDto dto);

	// 삭제 버튼
	public int uelete(PartyDto dto);

	// 삭제 버튼(drop)
	public int delete(PartyDto dto);

	// 페이징 처리 리스트
	public List<PartyDto> selectListWithPaging(PartyVo vo);

	// 개수 리턴
	public Integer selectCount(PartyVo vo);

}
