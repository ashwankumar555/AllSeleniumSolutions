package restAssured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.List;

import files.PayLoad;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecBuilderTest {
	
	public static void main(String[] args)
	{
		AddPlaceSerialization p = new AddPlaceSerialization();
		p.setAccuracy(50);
		p.setAddress("25, ashwin layout, cohen 89");
		p.setLanguage("English");
		p.setPhone_number("(+91) 9949778355");
		p.setWebsite("https://ashwinakhiraworld.com");
		p.setName("Akhira");
		
		//Creating ArrayList to accept types items
		List<String> myList = new ArrayList<String>();
		myList.add("shoe park");
		myList.add("shop");
		p.setTypes(myList);
		
		//Creating LocationClass object to accept lat and lng
		LocationClass l = new LocationClass();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		p.setLocation(l);
		
		
		RequestSpecification req= new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addQueryParam("key", "qaclick123").setContentType(ContentType.JSON).build();
		
		ResponseSpecification respspec= new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		RequestSpecification res = given().spec(req).body(p);
		Response response = res.when().post("maps/api/place/add/json")
		.then().spec(respspec).extract().response();
		System.out.println(response);
	}
}
