package com.ERR.infra.memberParty;

public interface MemberPartyDao {

	// 등록 버튼
	public int insert(MemberPartyDto dto);

	// 파티 신청 버튼
	public int insertRequest(MemberPartyDto dto);
	
	// 파티 허가 버튼
	public int updatePermit(MemberPartyDto dto);
}
