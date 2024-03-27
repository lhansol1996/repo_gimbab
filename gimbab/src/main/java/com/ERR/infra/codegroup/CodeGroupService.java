package com.ERR.infra.codegroup;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * 로직을 처리하는 클래스
 * DAO의 구현체를 호출하는 역할을 한다고 보면됨
 */

@Service
public class CodeGroupService {

	// @autowired : 객체 생성어노테이션
	@Autowired
	CodeGroupDao codeGroupDao;

	
	 
	//selectList 구현
//	public List<CodeGroupDto> selectList(CodeGroupVo vo) {
//
//  		List<CodeGroupDto> list = codeGroupDao.selectList();
//  		return list;
//
//		
//		return codeGroupDao.selectList(vo);
//	}

	public CodeGroupDto selectOne(CodeGroupDto dto) {
		return codeGroupDao.selectOne(dto);
	}
	
	//등록버튼
	public int insert(CodeGroupDto dto) {
		return codeGroupDao.insert(dto);
	}
	
	
	//수정버튼
	public int update(CodeGroupDto dto) {
		return codeGroupDao.update(dto);
	}
	
	//삭제버튼(uelete)
	public int uelete(CodeGroupDto dto) {
		return codeGroupDao.uelete(dto);
	}
	
	//삭제버튼(delete)
	public int delete(CodeGroupDto dto) {
		return codeGroupDao.delete(dto);
	}
		
	//페이징없는 코드그룹 리스트 
	public List<CodeGroupDto> selectListWithoutPaging() {
		return codeGroupDao.selectListWithoutPaging();
	}
	
	//페이징 처리 리스트 
	public List<CodeGroupDto> selectListWithPaging(CodeGroupVo vo){
		return codeGroupDao.selectListWithPaging(vo);
	}
		
	//개수 리턴
	public Integer selectCount(CodeGroupVo vo) {
		return codeGroupDao.selectCount(vo);
	}
		
}
