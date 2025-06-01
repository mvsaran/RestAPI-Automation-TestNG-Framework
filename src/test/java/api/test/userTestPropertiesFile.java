package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.endpoints.UserEndPointsfromPropertiesFile;
import api.payload.User;
import io.restassured.response.Response;

public class userTestPropertiesFile {

	Faker faker;
	User userPayload;
	
	public Logger logger;
	@BeforeClass
	public void setupData()
	{
		faker = new Faker();
		userPayload = new User();
		
		// Generating random data for user payload
		
		userPayload.setId(faker.number().numberBetween(1, 1000));
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().emailAddress());
		userPayload.setPassword(faker.internet().password());
		userPayload.setPhone(faker.phoneNumber().phoneNumber());
		userPayload.setUserStatus(0); // 0 - active, 1 - inactive
		
		//Logging the generated user data
		
		logger = LogManager.getLogger(this.getClass());
		logger.debug("Generated User Data: " + userPayload.toString());
		
	}
	
	@Test(priority = 1)
	public void testPostUser() {
		// Code to test user creation
		// Use userPayload to create a new user
		System.out.println("Creating user with username: " + userPayload.getUsername());
		Response response = UserEndPointsfromPropertiesFile.createUser(userPayload);
		response.then().log().all();
		response.then().assertThat().statusCode(200);
			
	}
	@Test(priority = 2,dependsOnMethods = "testPostUser")
	public void testGetUser() {
		// Code to test getting user details
		// Use the username from userPayload
		logger.info("********Creating User**********");
		System.out.println("Fetching user with username: " + userPayload.getUsername());
		Response response = UserEndPointsfromPropertiesFile.readUser(this.userPayload.getUsername());
		response.then().log().all();
		response.then().assertThat().statusCode(200);
		logger.info("********User Created Successfully**********");
		
	}
	@Test(priority = 3, dependsOnMethods = "testGetUser")
	public void testUpdateUser() {
		// Code to test updating user details
		// Use userPayload to update the user
		logger.info("********Updating User**********");
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		
		Response response = UserEndPointsfromPropertiesFile.updateUser(this.userPayload.getUsername(), userPayload);
		response.then().log().all();
		response.then().assertThat().statusCode(200);
		logger.info("********User Updated Successfully**********");
		
	}
//	@Test(priority = 4,dependsOnMethods = "testUpdateUser")
//	public void testDeleteUser() {
//		// Code to test deleting user
//		// Use the username from userPayload
//		
//		Response response = UserEndPointsfromPropertiesFile.deleteUser(this.userPayload.getUsername());
//		response.then().log().all();
//		response.then().assertThat().statusCode(200);
//		
//	}
//	@AfterClass
//	public void tearDown() {
//		// Code to clean up after tests, if necessary
//		// For example, you might want to delete the user if it still exists
//		Response response = UserEndPointsfromPropertiesFile.deleteUser(userPayload.getUsername());
//		response.then().log().all();
//		response.then().assertThat().statusCode(200);
//	}
//	
//	
}
