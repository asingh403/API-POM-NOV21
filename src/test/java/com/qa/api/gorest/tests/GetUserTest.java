package com.qa.api.gorest.tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;
import com.qa.api.gorest.restclient.RestClient;
import com.qa.api.gorest.util.Token;

import io.restassured.response.Response;

public class GetUserTest {
	
	String baseURI = "https://gorest.co.in";
	String basePath = "/public/v1/users";
	String token = "62aa1f2dc00580c92239cdfcb96da7e6cae2b0022e2ea6be603dda8fd48b03c6";
	
	
	@Test
	public void getUserListAPITest() {
		Map<String, String> authTokenMap = new HashMap<>();
		authTokenMap.put("Authorization", "Bearer "+token);
		
		Response response = RestClient.doGet("JSON", baseURI, basePath, authTokenMap, null, true);
		
		System.out.println(response.prettyPrint());
		System.out.println(response.getStatusCode());
		
	}
	
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
		
	}

}
