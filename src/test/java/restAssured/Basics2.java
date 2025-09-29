package restAssured;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import files.PayLoad;
import files.ReusableMethods;

public class Basics2 {

	public static void main(String[] args) {
		// given - all input details
		// when - submit the API
		// then - validate the response
		
		//Create (POST) API
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(PayLoad.AddPlace())
		.when().post("maps/api/place/add/json")
		.then().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("server", "Apache/2.4.52 (Ubuntu)").extract().response().asString();
		
		System.out.println(response);
		JsonPath js = new JsonPath(response);
		String placeID = js.getString("place_id");
		System.out.println(placeID);
		
		
		//Update (PUT) API
		String newAddress = "Ashwin Kingdom, Akhira";
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body("{\r\n"
				+ " \"place_id\": \""+placeID+"\",\r\n"
				+ " \"address\": \""+newAddress+"\",\r\n"
				+ " \"key\":\"qaclick123\"\r\n"
				+ "}")
		.when().put("maps/api/place/update/json")
		.then().assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));
		
		//Get (GET) API
		String getPlaceResponse = given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeID)
		.when().get("maps/api/place/get/json")
		.then().assertThat().log().all().statusCode(200).extract().response().asString();

		JsonPath js1 = ReusableMethods.rawToJSON(getPlaceResponse);
		String actualaddress = js1.getString("address");
		System.out.println(actualaddress);
		Assert.assertEquals(actualaddress, newAddress);
	}
}
