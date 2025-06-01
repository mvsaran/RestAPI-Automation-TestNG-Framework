package api.endpoints;

// Swagger URI : https://petstore.swagger.io

public class Routes {
	
	public static String BASE_URL = "https://petstore.swagger.io/v2";
	
	// User Endpoints
	
	public static String Post_url = BASE_URL + "/user";
	public static String Get_url = BASE_URL + "/user/{username}";
	public static String Put_url = BASE_URL + "/user/{username}";
	public static String Delete_url = BASE_URL + "/user/{username}";

}
