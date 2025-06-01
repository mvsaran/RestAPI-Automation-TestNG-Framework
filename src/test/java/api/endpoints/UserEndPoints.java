package api.endpoints;
import static io.restassured.RestAssured.*;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

// To Perform CRUD operations on User

public class UserEndPoints {
	
	public static Response createUser(User payload) {
		
		Response response = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
			.when()
			.post(Routes.Post_url);
		return response;
			
	}
	
	public static Response readUser(String username) {
		
		Response response = given()
			.pathParam("username", username)
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.when()
			.get(Routes.Get_url);
		return response;
			
	}
	
	public static Response updateUser(String username, User payload) {
		
		Response response = given()
			.pathParam("username", username)
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
			.when()
			.put(Routes.Put_url);
		return response;
			
	}
	
	public static Response deleteUser(String username) {
		
		Response response = given()
			.pathParam("username", username)
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.when()
			.delete(Routes.Delete_url);
		return response;
			
	}

}
