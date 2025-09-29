package apistepDefinations;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlaceSerialization;
import pojo.LocationClass;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

public class StepDefination extends Utils{
	
	ResponseSpecification respspec;
	RequestSpecification res;
	Response response;
	TestDataBuild data = new TestDataBuild();
	static String place_id;
	
	@Given("Add Place Payload with {string}   {string}  {string}")
	public void add_place_payload_with(String name, String language, String address) throws IOException {
	    		
		res = given().spec(requestSpecification()).body(data.addPlacePayLoad(name,language,address));
		    
	}
	
	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String apiCallType) {
		
		APIResources resourcesAPI = APIResources.valueOf(resource);
		System.out.println(resourcesAPI.getResource());
		
		respspec= new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		if(apiCallType.equalsIgnoreCase("POST"))
		response = res.when().post(resourcesAPI.getResource());
		else if(apiCallType.equalsIgnoreCase("GET"))
			response = res.when().get(resourcesAPI.getResource());
					else if(apiCallType.equalsIgnoreCase("DELETE"))
						response = res.when().post(resourcesAPI.getResource());
				//.then().spec(respspec).extract().response();
	}
	
	@Then("the API call is success with status code {int}")
	public void the_api_call_is_success_with_status_code(Integer int1) {
	   assertEquals(response.getStatusCode(),200);
	}
	
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String ExpectedValue) {
	    
		assertEquals(getJsonPath(response, keyValue),ExpectedValue);
	}
	
	@Then("verify place_Id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String expectedName, String resource) throws IOException {
	   
		place_id = getJsonPath(response, "place_id");
		res = given().spec(requestSpecification()).queryParam("place_id", place_id);
		user_calls_with_http_request(resource, "GET");
		
		String actualName = getJsonPath(response, "name");
		assertEquals(expectedName, actualName);
	}
	
	@Given("DeletePlace Payload")
	public void delete_place_payload() throws IOException {
		res = given().spec(requestSpecification()).body(data.deletePlacePayLoad(place_id));
	}
	
}
