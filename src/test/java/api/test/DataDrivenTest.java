package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class DataDrivenTest {
	
	@Test(priority = 1, dataProvider = "Userdata",dataProviderClass = api.utilities.DataProviders.class)
	public void testPostUser(String UserID, String UserName, String UserFirstName, String UserLastName, String UserEmail, String UserPassword,String UserPhone, String UserStatus) {
		System.out.println("UserId: " + UserID);
		System.out.println("UserName: " + UserName);
		System.out.println("UserFirstName: " + UserFirstName);
		System.out.println("UserLastName: " + UserLastName);
		System.out.println("UserEmail: " + UserEmail);
		System.out.println("UserPassword: " + UserPassword);
		System.out.println("UserPhone: " + UserPhone);
		
		User userPayload = new User();
		
		userPayload.setId(Integer.parseInt(UserID));
		userPayload.setUsername(UserName);
		userPayload.setFirstName(UserFirstName);
		userPayload.setLastName(UserLastName);
		userPayload.setEmail(UserEmail);
		userPayload.setPassword(UserPassword);
		userPayload.setPhone(UserPhone);
		userPayload.setUserStatus(Integer.parseInt(UserStatus));
		
		Response response = UserEndPoints.createUser(userPayload);
		Assert.assertEquals(response.getStatusCode(), 200);
	}
 
//	@Test(priority = 2, dataProvider = "UserNames",dataProviderClass = api.utilities.DataProviders.class,dependsOnMethods = {"testPostUser"})
//	public void testDeleteUser(String UserName) {
//		System.out.println("UserName: " + UserName);
//		
//		Response response = UserEndPoints.deleteUser(UserName);
//		Assert.assertEquals(response.getStatusCode(), 200);
//	}
}
