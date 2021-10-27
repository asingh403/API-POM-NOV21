package com.qa.api.gorest.tests;

import org.testng.annotations.Test;

import com.qa.api.gorest.restclient.RestClient;
import com.qa.gorest.pojo.User;

import io.restassured.response.Response;

public class CreateUserTest {
	
	String baseURI = "https://gorest.co.in";
	String basePath = "/public/v1/users";
	String token = "62aa1f2dc00580c92239cdfcb96da7e6cae2b0022e2ea6be603dda8fd48b03c6";
	
	@Test
	public void createUserAPIPOSTTest() {
		
		User user = new User("Aditya", "adi0012@hotmail.com", "male", "25-aug-1998", "active");
		Response response = RestClient.doPost("JSON", baseURI, basePath, token, null, true, user);
		
		System.out.println(response.asPrettyString());
		System.out.println(response.statusCode());
		
	}
	
	

}
