package com.ERR.infra.character;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CharacterService {
	@Autowired
	CharacterDao characterDao;
	
	public CharacterDto selectOne(CharacterDto dto) {
		return characterDao.selectOne(dto);
	}
	
	public CharacterDto selectOneByName(CharacterDto dto) {
		return characterDao.selectOneByName(dto);
	}
	
	
	//등록버튼
	public int insert(CharacterDto dto) {
		return characterDao.insert(dto);
	}
	
	
	//수정버튼
	public int update(CharacterDto dto) {
		return characterDao.update(dto);
	}
	
	//삭제버튼(uelete)
	public int uelete(CharacterDto dto) {
		return characterDao.uelete(dto);
	}
	
	//삭제버튼(delete)
	public int delete(CharacterDto dto) {
		return characterDao.delete(dto);
	}
		
	//페이징없는 코드그룹 리스트 
	public List<CharacterDto> selectListWithoutPaging() {
		return characterDao.selectListWithoutPaging();
	}
	
	//페이징 처리 리스트 
	public List<CharacterDto> selectListWithPaging(CharacterVo vo){
		return characterDao.selectListWithPaging(vo);
	}
		
	//개수 리턴
	public Integer selectCount(CharacterVo vo) {
		return characterDao.selectCount(vo);
	}

}
