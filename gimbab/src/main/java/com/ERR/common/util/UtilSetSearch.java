package com.ERR.common.util;

import com.ERR.common.base.BaseVo;
import com.ERR.common.constants.Constants;

public class UtilSetSearch {
	public static void setSearch(BaseVo vo) throws Exception {
		vo.setVoDateStart(vo.getVoDateStart() == null
				? UtilDateTime.calculateDayReplace00TimeString(UtilDateTime.nowLocalDateTime(), Constants.DATE_INTERVAL)
				: UtilDateTime.add00TimeString(vo.getVoDateStart()));
		vo.setVoDateEnd(vo.getVoDateEnd() == null ? UtilDateTime.nowString()
				: UtilDateTime.addNowTimeString(vo.getVoDateEnd()));
	}
}
