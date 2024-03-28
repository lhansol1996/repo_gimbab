package com.ERR.infra.member;

import java.util.List;

public interface MemberDao {

	// 수많은 DTO 목록들을 리스트로 리턴
	public List<MemberDto> selectList(MemberVo vo);

	// DTO 중 하나를 리턴
	public MemberDto selectOne(MemberDto dto);

	// 등록 버튼
	public int insert(MemberDto dto);

	// 수정 버튼
	public int update(MemberDto dto);

	// 삭제 버튼
	public int uelete(MemberDto dto);

	// 삭제 버튼(drop)
	public int delete(MemberDto dto);
	
	//로그인
	public MemberDto selectLogin(MemberDto dto);

}
