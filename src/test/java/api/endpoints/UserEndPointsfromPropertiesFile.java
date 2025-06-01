package api.endpoints;
import static io.restassured.RestAssured.*;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

// To Perform CRUD operations on User

public class UserEndPointsfromPropertiesFile {
	
	static ResourceBundle getURL()
	{
		
		ResourceBundle routes = ResourceBundle.getBundle("routes");
		return routes;
	}
	
	public static Response createUser(User payload) 
	{
		String post_url = getURL().getString("post_url");
		// Using the ResourceBundle to get the URL from properties file
		Response response = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
			.when()
			.post(post_url);
		return response;
			
	}
	
	public static Response readUser(String username) {
		
		String get_url = getURL().getString("get_url");
		// Using the ResourceBundle to get the URL from properties file
		Response response = given()
			.pathParam("username", username)
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.when()
			.get(get_url);
		return response;
			
	}
	
	public static Response updateUser(String username, User payload) {
		
		String put_url = getURL().getString("put_url");
		
		Response response = given()
			.pathParam("username", username)
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
			.when()
			.put(put_url);
		return response;
			
	}
	
	public static Response deleteUser(String username) {
		
		String delete_url = getURL().getString("delete_url");
		// Using the ResourceBundle to get the URL from properties file
		Response response = given()
			.pathParam("username", username)
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.when()
			.delete(delete_url);
		return response;
			
	}

}
