package com.ERR.common.base;

import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ERR.common.util.UtilApi;
import com.ERR.infra.code.CodeService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class RecordController extends BaseController {
	private String UsrCommonPath = "usr/";
	@Autowired
	CodeService codeService;

	@RequestMapping(value = "/record")
	public String record(@RequestParam("nickName") String nickName, Model model) throws Exception {

		// userNum 호출 API
		String getUserNumUrl = "https://open-api.bser.io/v1/user/nickname?query="
				+ URLEncoder.encode(nickName, "UTF-8");

		UtilApi.callERApi(getUserNumUrl);
		StringBuilder stringBuilder = UtilApi.callERApi(getUserNumUrl);

		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> getUserMap = objectMapper.readValue(stringBuilder.toString(), Map.class);
		System.out.println(getUserMap);
		Map<String, Object> getUserNumMap = (Map<String, Object>) getUserMap.get("user");
		String userNum = String.valueOf(getUserNumMap.get("userNum"));
		String userName = String.valueOf(getUserNumMap.get("nickname"));
		model.addAttribute("userNameItem", userName);

		// 받은 userNum 으로 전적 호출 API
		String getUserRecordUrl = "https://open-api.bser.io/v1/user/games/" + userNum;
		UtilApi.callERApi(getUserRecordUrl);
		StringBuilder stringBuilder2 = UtilApi.callERApi(getUserRecordUrl);
		// objectMapper 생성
		ObjectMapper objectMapper2 = new ObjectMapper();
		Map<String, Object> getUserRecord = objectMapper2.readValue(stringBuilder2.toString(), Map.class);
		List<Map<String, Object>> userGamesList = (List<Map<String, Object>>) getUserRecord.get("userGames");

		model.addAttribute("userGamesList", userGamesList);

		// 받은 userNum으로 해당 유저 상세 정보 호출 API
		String getUserStatUrl = "https://open-api.bser.io/v1/user/stats/" + userNum + "/23";
		UtilApi.callERApi(getUserStatUrl);
		StringBuilder stringBuilder3 = UtilApi.callERApi(getUserStatUrl);
		// objectMapper 생성
		ObjectMapper objectMapper3 = new ObjectMapper();
		Map<String, Object> getUserStat = objectMapper3.readValue(stringBuilder3.toString(), Map.class);
		List<Map<String, Object>> getUserStatItem = (List<Map<String, Object>>) getUserStat.get("userStats");
		System.out.println(getUserStatItem);

		model.addAttribute("getUserStatItem", getUserStatItem);

		return UsrCommonPath + "record";
	}

}
