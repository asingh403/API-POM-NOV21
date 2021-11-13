package com.qa.api.gorest.restclient;

import java.io.File;
import java.util.Map;

import com.qa.api.gorest.util.TestUtil;

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
	
	/**
	 * This method is used to call GET api's
	 * @param contentType
	 * @param baseURI
	 * @param basePath
	 * @param token
	 * @param paramsMap
	 * @param log
	 * @return This method is returning Response from the GET call.
	 */

	public static Response doGet(String contentType, String baseURI, String basePath, Map<String, String> token,
			Map<String, String> paramsMap, boolean log) {
		
		if(setBaseUri(baseURI)) {
			RequestSpecification request = createRequest(contentType, token, paramsMap, log);
			return getResponse("GET", request, basePath);			
		}
		return null;
	}
	
	/**
	 * This method is used to call POST api's
	 * @param contentType
	 * @param baseURI
	 * @param basePath
	 * @param token
	 * @param paramsMap
	 * @param log
	 * @param obj
	 * @return This method is returning Response from the POST call.
	 */
	public static Response doPost(String contentType, String baseURI, String basePath, Map<String, String> token,
			Map<String, String> paramsMap, boolean log, Object obj) {
		
		if(setBaseUri(baseURI)) {
			RequestSpecification request = createRequest(contentType, token, paramsMap, log);
			addRequestPayload(request, obj);
			return getResponse("POST", request, basePath);			
		}
		return null;
	}
	
	public static Response doDelete(String contentType, String baseURI, String basePath, Map<String, String> token,
			Map<String, String> paramsMap, boolean log, Object obj) {
		
		if(setBaseUri(baseURI)) {
			RequestSpecification request = createRequest(contentType, token, paramsMap, log);
			addRequestPayload(request, obj);
			return getResponse("DELETE", request, basePath);			
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	/**
	 * Creating add payload for the doPost method
	 * @param request
	 * @param obj
	 */
	
	public static void addRequestPayload(RequestSpecification request, Object obj) {
		
		if(obj instanceof Map) {
			request.formParams((Map<String, String>)obj);
		}else {
			String jsonPayload = TestUtil.getSerializedJSON(obj);
			request.body(jsonPayload);			
		}		
	}
	
	private static boolean setBaseUri(String baseURI) {
		
		if(baseURI==null || baseURI.isEmpty()) {
			System.out.println("Please pass the baseURI....");
			return false;
		}
		
		try {
		RestAssured.baseURI = baseURI;
		return true;

		} catch(Exception e) {
			System.out.println("Some exception got occured while assigining the baseURI with Rest Assured. . .");
			return false;
		}
	}
	
	private static RequestSpecification createRequest(String contentType, Map<String, String> token, Map<String, String> paramMap, boolean log) {
		
		RequestSpecification request;
		
		if(log) {
			
			request = RestAssured.given().log().all();			
		} else {
			request = RestAssured.given();
		}
		
		if(token.size()>0) {
			//request.header("Authorization", "Bearer "+ token);
			request.headers(token);
		}
		
		if(!(paramMap == null)) {
			request.queryParams(paramMap);			
		}
		
		if(contentType!=null) {		
		if(contentType.equalsIgnoreCase("JSON")) {
			request.contentType(ContentType.JSON);
		}else if(contentType.equalsIgnoreCase("XML")) {
			request.contentType(ContentType.XML);
		}else if(contentType.equalsIgnoreCase("TEXT")) {
			request.contentType(ContentType.TEXT);
		}else if(contentType.equalsIgnoreCase("multipart")) {
			request.multiPart("image", new File(".\\src\\main\\java\\com\\qa\\api\\gorest\\testdata\\imgur-test.gif"));
		}		
		
	}
		return request;
}
	
	
	private static Response getResponse(String httpMethod, RequestSpecification request, String basePath) {
		
		return executeAPI(httpMethod, request, basePath);
	}
	
	private static Response executeAPI(String httpMethod, RequestSpecification request, String basePath) {
		
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
