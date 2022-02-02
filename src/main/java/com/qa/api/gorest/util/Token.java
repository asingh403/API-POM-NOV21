package com.qa.api.gorest.util;

import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

import io.restassured.path.json.JsonPath;

public class Token {
	
	public static Map<Object, Object> appTokenMap;
	public static Map<String, String> tokenMap = new HashMap<>();
	public static String clientid = "03d684734973921";
	
	public static Map<Object, Object> getAccessToken() {
		
		Map<String, String> formParams = new HashMap<String, String>();
		formParams.put("refresh_token", "2015bc01ec9ee29187165de60b1c391da7d223ae");
		formParams.put("client_id", "03d684734973921");
		formParams.put("client_secret", "6f96ffa00ee3e3d09032733805bbcbbd7e1e7282");
		formParams.put("grant_type", "refresh_token");
		
		JsonPath tokenJson = 
		given()
			.formParams(formParams)
				.when()
				.post("https://api.imgur.com/oauth2/token")
					.then()
					.extract()
					.jsonPath();
		
		System.out.println(tokenJson.getMap(""));
		
		appTokenMap = tokenJson.getMap("");
		
		return appTokenMap;
		
	}
	
	public static Map<String, String> getAuthToken() {
		
		String authToken = appTokenMap.get("access_token").toString();
		System.out.println("Auth token ====> "+ authToken	);
		tokenMap.put("Authorization", "Bearer "+authToken);		
		return tokenMap;		
	}
	public static Map<String, String> getClientId() {
		
		System.out.println("Client ID is ====> "+ clientid	);
		tokenMap.put("Authorization", "Client-ID "+ clientid);		
		return tokenMap;		
	}	
	
}