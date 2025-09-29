package restAssured;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import org.testng.annotations.Test;
import files.ReusableMethods;

public class ExcelDriven {
	
	@Test
	public void postDataXML() throws IOException
	{	
		dataDriven d=new dataDriven();
		ArrayList data=d.getData("RestAddBook");
		HashMap<String, Object>  map = new HashMap<>();
		map.put("name", data.get(1));
		map.put("isbn", data.get(2));
		map.put("aisle", data.get(3));
		map.put("author", data.get(4));
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String resp=given().
				header("Content-Type","application/json").
		body(map).
		when().
		post("/Library/Addbook.php").
		then().assertThat().statusCode(200).
		extract().response().asString();
		 JsonPath js1= ReusableMethods.rawToJSON(resp);
		   String id=js1.get("ID");
		   System.out.println(id);
		   System.out.println(resp);
	}
	public static String GenerateStringFromResource(String path) throws IOException {
	    return new String(Files.readAllBytes(Paths.get(path)));
	}
}
