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
	
	//seq 호출
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

}