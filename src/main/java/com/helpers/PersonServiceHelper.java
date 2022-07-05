package com.helpers;

import java.lang.reflect.Type;
import java.util.List;

import com.constants.Endpoints;

import com.fasterxml.jackson.core.type.TypeReference;
import com.model.MultiUsers;
import com.utils.ConfigManager;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PersonServiceHelper {
	/*
	 * We need to read the variables present in the config file.
	 * Also we need to tell the rest assured which URL and port we are using
	 */
	
	private static final String BASE_URL=ConfigManager.getInstance().getString("baseUrl");
//If there's any port present
//	private static final String BASE_PORT=ConfigManager.getInstance().getString("mention port key");
	
	public PersonServiceHelper() {
		RestAssured.baseURI=BASE_URL;
		//Setup the port if required
		//RestAssured.port=Integer.parseInt("BASE_PORT");
		
		//Mention the below line if we're using the local host
		RestAssured.useRelaxedHTTPSValidation();
	}
	
	public MultiUsers getAllUsers(){
		Response response=RestAssured.given()
						.contentType(ContentType.JSON)
						.log().all()
					.when()
						.get(Endpoints.GET_ALLUSERS)
						.andReturn();
	/*
	 * We need to make use of Type class to convert the response of MultiUser class
	 * Why we need the type is so that we can map the response one type to pojo			
	 */
		Type type=new TypeReference<MultiUsers>() {
		}.getType();
		
		MultiUsers users=response.as(type);
		return users;
	}
}
