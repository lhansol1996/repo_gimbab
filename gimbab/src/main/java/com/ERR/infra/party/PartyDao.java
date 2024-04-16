package com.ERR.infra.party;

import java.util.List;

public interface PartyDao {

	// DTO 중 하나를 리턴
	public PartyDto selectOne(PartyDto dto);

	// 등록 버튼
	public int insert(PartyDto dto);

	// 등록, 신청을 위한 파티 seq 호출
	public String selectPartySeq(PartyDto dto);

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

	// 개수 리턴 - 나의파티 목록 개수
	public Integer selectCountProfileMyPartys(PartyVo vo);

	// 개수 리턴 - 허가신청할 목록 개수
	public Integer selectCountProfilePermit(PartyVo vo);

	// 개수 리턴 - 가입신청한 목록 개수
	public Integer selectCountProfileRequest(PartyVo vo);

	// usrIndex에 쓰일 최근 5개 나열 리스트
	public List<PartyDto> searchPartyForRecent5(PartyDto dto);

	// 페이징 처리 리스트 (프로파일 나의파티)
	public List<PartyDto> profilePartyListWithPaging(PartyVo vo);

	// 페이징 처리 리스트 (프로파일 나의 가입신청 파티)
	public List<PartyDto> profilePartyRequestListWithPaging(PartyVo vo);

	// 페이징 처리 리스트 (프로파일 나의 허가신청파티)
	public List<PartyDto> profilePartyPermitListWithPaging(PartyVo vo);

	// 파티 디테일 불러오기
	public PartyDto selectOneDetail(PartyDto dto);

	// 파티 멤버 불러오기
	public List<PartyDto> selectPartyMember(String partySeq);

}
