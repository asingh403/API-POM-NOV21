package com.qa.api.gorest.restclient;

import java.util.Map;

import io.restassured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


/**
 * This class is having all http method which will call the api and having
 * generic method for getting the response and fetch the value from the response
 * 
 * @author ASHUTOSH SINGH
 *
 */
public class RestClient {

	// HTTP Method: GET, POST, PUT, DELETE

	public static Response doGet(String contentType, String baseURI, String basePath, String token,
			Map<String, String> paramsMap, boolean log) {
		
		setBaseUri(baseURI);
		RequestSpecification request = createRequest(contentType, token, paramsMap, log);
		return getResponse("GET", request, basePath);
		
	}
	
	public static void setBaseUri(String baseURI) {
		RestAssured.baseURI = baseURI; 
	}
	
	public static RequestSpecification createRequest(String contentType, String token, Map<String, String> paramMap, boolean log) {
		
		RequestSpecification request;
		
		if(log) {
			
			request = RestAssured.given().log().all();			
		} else {
			request = RestAssured.given();
		}
		
		if(token != null) {
			request.header("Authorization", "Bearer "+ token);
		}
		
		if(!(paramMap == null)) {
			request.queryParams(paramMap);			
		}
		
		if(contentType.equalsIgnoreCase("JSON")) {
			request.contentType(ContentType.JSON);
		}
		
		if(contentType.equalsIgnoreCase("XML")) {
			request.contentType(ContentType.XML);
		}
		
		if(contentType.equalsIgnoreCase("TEXT")) {
			request.contentType(ContentType.TEXT);
		}
		
		return request;
		
	}
	
	
	public static Response getResponse(String httpMethod, RequestSpecification request, String basePath) {
		
		return executeAPI(httpMethod, request, basePath);
	}
	
	public static Response executeAPI(String httpMethod, RequestSpecification request, String basePath) {
		
		Response response = null;
		
		switch (httpMethod) {
		case "GET":
			response = request.get(basePath);
			break;
			
		case "POST":
			response = request.post(basePath);
			break;
			
		case "PUT":
			response = request.put(basePath);
			break;
			
		case "DELETE":
			response = request.delete(basePath);
			break;
			
		default: 
			
			System.out.println("Please pass the correct http method....");
			break;
			
		}
		
		return response;
		
	}

}
