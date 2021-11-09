package com.qa.api.gorest.tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.api.gorest.restclient.RestClient;
import com.qa.api.gorest.util.Token;

import io.restassured.response.Response;

public class GetImgurAPITest {
	
	Map<Object, Object> tokenMap;
	String accessToken;
	String accountUserName;
	String refreshToken;
	String commentSort = "newest";
	String page = "0";

	@BeforeMethod
	public void setUp() {
		tokenMap = Token.getAccessToken();
		accessToken = tokenMap.get("access_token").toString();
		accountUserName = tokenMap.get("account_username").toString();
		refreshToken = tokenMap.get("refresh_token").toString();
	}
	
	@Test(priority = 1)
	public void getAccountBlockStatus() {
		Map<String, String> authTokenMap = Token.getAuthToken();
		Response response = RestClient.doGet(null, "https://api.imgur.com", "/account/v1/"+accountUserName+"/block", authTokenMap, null, true);
		System.out.println(response.statusCode());
		System.out.println(response.prettyPrint());
	}	

	@Test(priority = 2)
	public void getAccountImageTest() {
		Map<String, String> authTokenMap = Token.getAuthToken();
		Response response = RestClient.doGet(null, "https://api.imgur.com", "/3/account/"+accountUserName+"/images", authTokenMap, null, true);
		System.out.println(response.statusCode());
		System.out.println(response.prettyPrint());
	}
	
	@Test(priority = 3)
	public void getComments() {
		Map<String, String> authTokenMap = Token.getAuthToken();
		Response response = RestClient.doGet(null, "https://api.imgur.com", "/3/account/"+accountUserName+"/comments/+commentSort+page", authTokenMap, null, true);
		System.out.println(response.statusCode());
		System.out.println(response.prettyPrint());
		
		String respStr = response.jsonPath().getString("data[0].comment");
		System.out.println(respStr);
		
		Assert.assertEquals(respStr, "let seehttps://i.imgur.com/3LY8DmC.gif");
	}
	
	@Test(priority = 4)
	public void uploadImagePostAPITest() {
		
		Map<String, String> clientIdMap= Token.getClientId();		
		Map<String, String> formMap = new HashMap<>();
		formMap.put("title", "test title API");
		formMap.put("description", "test title API");
		
		Response response = RestClient.doPost("multipart", "https://api.imgur.com", "/3/image", clientIdMap, null, true, formMap);
		System.out.println(response.prettyPrint());
		
		
	}
	
}
