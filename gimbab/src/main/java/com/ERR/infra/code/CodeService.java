package com.ERR.infra.code;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * 로직을 처리하는 클래스
 * DAO의 구현체를 호출하는 역할을 한다고 보면됨
 */

@Service
public class CodeService {

	// @autowired : 객체 생성어노테이션
	@Autowired
	CodeDao codeDao;

	
	 
	//selectList 구현
	public List<CodeDto> selectList(CodeVo vo) {
/*
 * 		List<CodeGroupDto> list = codeGroupDao.selectList();
 * 		return list;
 */
		
		return codeDao.selectList(vo);
	}

	public CodeDto selectOne(CodeDto dto) {
		return codeDao.selectOne(dto);
	}
	
	//등록버튼
	public int insert(CodeDto dto) {
		return codeDao.insert(dto);
	}
	
	
	//수정버튼
	public int update(CodeDto dto) {
		return codeDao.update(dto);
	}
	
	//삭제버튼(uelete)
	public int uelete(CodeDto dto) {
		return codeDao.uelete(dto);
	}
	
	//삭제버튼(delete
		public int delete(CodeDto dto) {
			return codeDao.delete(dto);
		}
	
}
