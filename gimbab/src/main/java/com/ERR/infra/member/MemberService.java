package com.ERR.infra.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * 로직을 처리하는 클래스
 * DAO의 구현체를 호출하는 역할을 한다고 보면됨
 */

@Service
public class MemberService {

	// @autowired : 객체 생성어노테이션
	@Autowired
	MemberDao memberDao;

	// selectList 구현
	public List<MemberDto> selectListWithPaging(MemberVo vo) {

		return memberDao.selectListWithPaging(vo);
	}

	public MemberDto selectOne(MemberDto dto) {
		return memberDao.selectOne(dto);
	}

	// 등록버튼
	public int insert(MemberDto dto) {
		return memberDao.insert(dto);
	}

	// 수정버튼
	public int update(MemberDto dto) {
		return memberDao.update(dto);
	}

	// 삭제버튼(uelete)
	public int uelete(MemberDto dto) {
		return memberDao.uelete(dto);
	}

	// 삭제버튼(delete
	public int delete(MemberDto dto) {
		return memberDao.delete(dto);
	}

	// 로그인
	public MemberDto selectLogin(MemberDto dto) {
		return memberDao.selectLogin(dto);
	}

	// 회원가입 - 관리자
	public int memberReg(MemberDto dto) {
		memberDao.memberReg(dto);
		return 1;
	}

	// 개수 리턴
	public Integer selectCount(MemberVo vo) {
		return memberDao.selectCount(vo);
	}

	// profile 수정
	public int updateProfile(MemberDto dto) {
		return memberDao.updateProfile(dto);
	}

}
