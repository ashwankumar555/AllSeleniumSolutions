package restAssured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.List;

import files.PayLoad;
import io.restassured.RestAssured;

public class SerializeTest {
	
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
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String response = given().queryParam("key", "qaclick123").body(p)
		.when().post("maps/api/place/add/json")
		.then().assertThat().statusCode(200).extract().response().asString();
		System.out.println(response);
	}

}
