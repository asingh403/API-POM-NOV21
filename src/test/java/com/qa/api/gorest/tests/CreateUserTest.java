package com.qa.api.gorest.tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.qa.api.gorest.restclient.RestClient;
import com.qa.api.gorest.util.ExcelUtil;
import com.qa.api.gorest.util.Token;
import com.qa.gorest.pojo.User;

import io.restassured.response.Response;

public class CreateUserTest {
	
	String baseURI = "https://gorest.co.in";
	String basePath = "/public/v1/users";
	String token = "62aa1f2dc00580c92239cdfcb96da7e6cae2b0022e2ea6be603dda8fd48b03c6";
	
	@DataProvider
	public Object[][] getUserData() {
		
		Object [][] userData = ExcelUtil.getTestData("userdata");
		return userData;
	} 
	
	@Test(dataProvider = "getUserData")
	public void createUserAPIPOSTTest(String name, String email, String gender, String dob, String status) {
		
		Map<String, String> authTokenMap = new HashMap<>();
		authTokenMap.put("Authorization", "Bearer "+token);
		
//		User user = new User("Aditya", "adi0012@hotmail.com", "male", "25-aug-1998", "active");
		User user = new User(name,  email, gender, dob, status);
		Response response = RestClient.doPost("JSON", baseURI, basePath, authTokenMap, null, true, user);
		
		System.out.println(response.prettyPrint());
		System.out.println(response.statusCode());
		
		System.out.println("==============================================");
		
	}
}
