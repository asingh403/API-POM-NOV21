package com.qa.api.gorest.tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import com.qa.api.gorest.restclient.RestClient;

public class DeleteUserTest {
	
	String baseURI = "https://gorest.co.in";
	String basePath = "/public/v1/users/6";
	String token = "62aa1f2dc00580c92239cdfcb96da7e6cae2b0022e2ea6be603dda8fd48b03c6";
	
	@Epic("E-98066")
	@Story("B-55423")
	@Feature("Verify delete Call for the API")
	@Severity(SeverityLevel.MINOR)
	@Description("Verify by DELETE call for the API, if the user already deleted")
	@Test(priority = 1)
	public  void deleteUserById() {
		Map<String, String> authTokenMap = new HashMap<>();
		authTokenMap.put("Authorization", "Bearer "+ token);
		
		Response response = RestClient.doDelete(token, baseURI, basePath, authTokenMap, authTokenMap, false, authTokenMap);
		System.out.println(response.prettyPrint());
		System.out.println(response.statusCode());
		
		Assert.assertEquals(response.statusCode(), 404);
	}
	

	

}
