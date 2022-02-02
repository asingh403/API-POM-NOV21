package com.qa.api.gorest.tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.api.gorest.restclient.RestClient;
import com.qa.api.gorest.util.Token;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
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
	
	@Epic("E-67766")
	@Story("B-55424")
	@Severity(SeverityLevel.TRIVIAL)
	@Description("Validate the api response in JSON")
	@Test(priority = 1)
	public void getAccountBlockStatus() {
		Map<String, String> authTokenMap = Token.getAuthToken();
		Response response = RestClient.doGet(null, "https://api.imgur.com", "/account/v1/"+accountUserName+"/block", authTokenMap, null, true);
		System.out.println(response.statusCode());
		System.out.println(response.prettyPrint());
	}	

	@Epic("E-67766")
	@Story("B-55424")
	@Feature("Validating the API Feature Image/GIF upload")
	@Severity(SeverityLevel.MINOR)
	@Description("Validate the Image/GIF uploaded by users")
	@Test(priority = 2)
	public void getAccountImageTest() {
		Map<String, String> authTokenMap = Token.getAuthToken();
		Response response = RestClient.doGet(null, "https://api.imgur.com", "/3/account/"+accountUserName+"/images", authTokenMap, null, true);
		System.out.println(response.statusCode());
		System.out.println(response.prettyPrint());
	}
	
	@Epic("E-98066")
	@Story("B-55423")
	@Feature("Validating the API for Comments made by users")
	@Severity(SeverityLevel.NORMAL)
	@Description("Validate the get comments services of API")
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
	
	@Epic("E-98066")
	@Story("B-55423")
	@Feature("Verify the users Image/GIF upload")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Verify Image/GIF upload by user in the service call")
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
