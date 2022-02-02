package com.qa.api.gorest.tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.api.gorest.restclient.RestClient;
import com.qa.api.gorest.util.Token;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;


@Epic("get user for all the created users in system")
@Feature("get user api feature")
public class GetUserTest {
	
	String baseURI = "https://gorest.co.in";
	String basePath = "/public/v1/users";
	String token = "62aa1f2dc00580c92239cdfcb96da7e6cae2b0022e2ea6be603dda8fd48b03c6";
	
	@Description("get all user api test...verify all user list from the get call")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 1)
	public void getUserListAPITest() {
		Map<String, String> authTokenMap = new HashMap<>();
		authTokenMap.put("Authorization", "Bearer "+token);
		
		Response response = RestClient.doGet("JSON", baseURI, basePath, authTokenMap, null, true);
		
		System.out.println(response.prettyPrint());
		System.out.println(response.getStatusCode());
		
	}
	
	@Description("get all user api test...verify all user list thru QUERY Params")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 2)
	public void getUserWithQueryParamsAPITest() {
		Map<String, String> authTokenMap = new HashMap<>();
		authTokenMap.put("Authorization", "Bearer "+token);
		
		Map<String, String> params = new HashMap<>();
		params.put("name", "Nina Simon");
		params.put("gender", "male");
		
		Response response = RestClient.doGet("JSON", baseURI, basePath, authTokenMap, params, true);
		
		System.out.println(response.prettyPrint());
		System.out.println(response.getStatusCode());
		
		Assert.assertEquals(response.getStatusCode(), 201);
		
	}

}
