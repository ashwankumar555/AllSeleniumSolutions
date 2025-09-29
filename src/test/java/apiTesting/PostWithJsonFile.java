package apiTesting;

import java.io.File;
import static io.restassured.RestAssured.given;
public class PostWithJsonFile {

	public static void main(String[] args) {
		 File file = new File("src/test/resources/user.json"); 
		 
	        given() 
	            .baseUri("https://reqres.in") 
	            .contentType("application/json") 
	            .body(file) 
	        .when() 
	            .post("/api/users") 
	        .then() 
	            .statusCode(201) 
	            .log().body(); // TODO Auto-generated method stub

	}

}
