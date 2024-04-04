package com.ERR.infra.code;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

/*
 * 로직을 처리하는 클래스
 * DAO의 구현체를 호출하는 역할을 한다고 보면됨
 */

@Service
public class CodeService {

	// @autowired : 객체 생성어노테이션
	@Autowired
	CodeDao codeDao;

	// selectList 구현 - 페이징처리
	public List<CodeDto> selectListWithPaging(CodeVo vo) {
		/*
		 * List<CodeGroupDto> list = codeGroupDao.selectList(); return list;
		 */
		return codeDao.selectListWithPaging(vo);
	}

	// 페이징 처리안된 리스트
	public List<CodeDto> selectListWithoutPaging() {
		return codeDao.selectListWithoutPaging();
	}

	// 개수 리턴
	public Integer selectCount(CodeVo vo) {
		return codeDao.selectCount(vo);
	}

	public CodeDto selectOne(CodeDto dto) {
		return codeDao.selectOne(dto);
	}

	// 등록버튼
	public int insert(CodeDto dto) {
		return codeDao.insert(dto);
	}

	// 수정버튼
	public int update(CodeDto dto) {
		return codeDao.update(dto);
	}

	// 삭제버튼(uelete)
	public int uelete(CodeDto dto) {
		return codeDao.uelete(dto);
	}

	// 삭제버튼(delete
	public int delete(CodeDto dto) {
		return codeDao.delete(dto);
	}

	/**
	 * code 명으로 표출하는 메소드
	 */

	@PostConstruct
	public void selectListCachedCodeArrayList() throws Exception {
		List<CodeDto> codeListFromDb = (ArrayList<CodeDto>) codeDao.selectListCachedCodeArrayList();
//			codeListFromDb = (ArrayList<Code>) dao.selectListCachedCodeArrayList();
		CodeDto.cachedCodeArrayList.clear();
		CodeDto.cachedCodeArrayList.addAll(codeListFromDb);
		System.out.println("cachedCodeArrayList: " + CodeDto.cachedCodeArrayList.size() + " chached !");
	}

	// 코드 한가지만 받아올 때 param 코드 번호
	public static String selectOneCachedCode(int code) throws Exception {
		String rt = "";
		for (CodeDto codeRow : CodeDto.cachedCodeArrayList) {
			if (codeRow.getCodeSeq().equals(Integer.toString(code))) {
				rt = codeRow.getCodeName();
			} else {
				// by pass
			}
		}
		return rt;
	}

	// 코드를 list로 받아와야 할 때 param 코드그룹 번호
	public static List<CodeDto> selectListCachedCode(String codeGroupSeq) throws Exception {
		List<CodeDto> rt = new ArrayList<CodeDto>();

		for (CodeDto codeRow : CodeDto.cachedCodeArrayList) {

			if (codeRow.getCodeGroupSeqF().equals(codeGroupSeq)) {
				rt.add(codeRow);
			} else {
				// by pass
			}
		}
		return rt;
	}

}
