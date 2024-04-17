package com.ERR.common.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class UtilApi {

	// 이터널리턴 API 호출 및 응답을 처리하는 메서드
	// 호출하는 컨트롤러에서 stringBuilder를 받아 mapper생성을위해 stringBuilder를 받음
	public static StringBuilder callERApi(String apiURL) throws Exception {

		// api 사용시 사용할 변수선언 - 내 이터널리턴 api 인증키
		String apiKey = "tQvnRGNZTG3LVyUHPweI78qgK27NqVqs8MCWHwPT";
		//api url
		URL url = new URL(apiURL);

		// HttpURLConnection 객체생성
		HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

		// x-api-key 설정
		httpURLConnection.setRequestProperty("x-api-key", apiKey);
		// 방식 설정
		httpURLConnection.setRequestMethod("GET");

		BufferedReader bufferedReader;
		// api 호출
		if (httpURLConnection.getResponseCode() >= 200 && httpURLConnection.getResponseCode() <= 300) {
			bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
		} else {
			bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
		}

		StringBuilder stringBuilder = new StringBuilder();
		String line;
		while ((line = bufferedReader.readLine()) != null) {
//			System.out.println("line: " + line);
			stringBuilder.append(line);
		}

		bufferedReader.close();
		httpURLConnection.disconnect();

//		System.out.println("stringBuilder.toString(): " + stringBuilder.toString());
		return stringBuilder; 
	}

}
