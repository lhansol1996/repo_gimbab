package com.ERR.infra.party;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ERR.infra.memberParty.MemberPartyDao;
import com.ERR.infra.memberParty.MemberPartyDto;

@Service
public class PartyService {

	@Autowired
	PartyDao partyDao;
	@Autowired
	MemberPartyDao memberPartyDao;

	// DTO 중 하나를 리턴
	public PartyDto selectOne(PartyDto dto) {
		return partyDao.selectOne(dto);
	}

	// seq 호출
	public String selectPartySeq(PartyDto partyDto) {
		return partyDao.selectPartySeq(partyDto);
	}

	// 등록 버튼
	public int insert(PartyDto partyDto, MemberPartyDto memberPartyDto) {
		partyDao.insert(partyDto);
		memberPartyDto.setPartySeqF(partyDao.selectOne(partyDto).getPartySeq());
		memberPartyDao.insert(memberPartyDto);
		return 1;
	}

	// 신청 버튼
	public int insertRequest(PartyDto partyDto, MemberPartyDto memberPartyDto) {
		memberPartyDto.setPartySeqF(partyDao.selectOne(partyDto).getPartySeq());
		memberPartyDao.insertRequest(memberPartyDto);
		return 1;
	}

	// 허가 버튼
	public int updatePermit(PartyDto partyDto, MemberPartyDto memberPartyDto) {
		memberPartyDao.updatePermit(memberPartyDto);
		return 1;
	}

	// 수정 버튼
	public int update(PartyDto dto) {
		return partyDao.update(dto);
	}

	// 삭제 버튼
	public int uelete(PartyDto dto) {
		return partyDao.uelete(dto);
	}

	// 삭제 버튼(drop)
	public int delete(PartyDto dto) {
		return partyDao.delete(dto);
	}

	// 페이징 처리 리스트
	public List<PartyDto> selectListWithPaging(PartyVo vo) {
		return partyDao.selectListWithPaging(vo);
	}

	// 개수 리턴
	public Integer selectCount(PartyVo vo) {
		return partyDao.selectCount(vo);
	}

	// 개수 리턴 - 내파티 목록 개수
	public Integer selectCountProfileMyPartys(PartyVo vo) {
		return partyDao.selectCountProfileMyPartys(vo);
	}
	// 개수 리턴 - 허가신청할 목록 개수
	public Integer selectCountProfilePermit(PartyVo vo) {
		return partyDao.selectCountProfilePermit(vo);
	}

	// 개수 리턴 - 가입신청한 목록 개수
	public Integer selectCountProfileRequest(PartyVo vo) {
		return partyDao.selectCountProfileRequest(vo);
	}

	// usrIndex에 쓰일 최근 5개 나열 리스트
	public List<PartyDto> searchPartyForRecent5(PartyDto dto) {
		return partyDao.searchPartyForRecent5(dto);
	}

	// 페이징 처리 리스트 (프로파일 나의파티)
	public List<PartyDto> profilePartyListWithPaging(PartyVo vo) {
		return partyDao.profilePartyListWithPaging(vo);
	}

	// 페이징 처리 리스트 (프로파일 신청한파티)
	public List<PartyDto> profilePartyRequestListWithPaging(PartyVo vo) {
		return partyDao.profilePartyRequestListWithPaging(vo);
	}

	// 페이징 처리 리스트 (프로파일 가입허가 파티)
	public List<PartyDto> profilePartyPermitListWithPaging(PartyVo vo) {
		return partyDao.profilePartyPermitListWithPaging(vo);
	}

	// 파티 디테일 불러오기
	public PartyDto selectOneDetail(PartyDto dto) {
		return partyDao.selectOneDetail(dto);
	}
	
	//파티 멤버 불러오기
	public List<PartyDto> selectPartyMember(String partySeq) {
		return partyDao.selectPartyMember(partySeq);
	}

}
