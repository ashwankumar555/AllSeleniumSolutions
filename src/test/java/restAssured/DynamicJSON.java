package restAssured;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import files.PayLoad;
import files.ReusableMethods;

public class DynamicJSON {
	
	@Test(dataProvider="BookData")
	public void addBook(String isbn, String aisle)
	{
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response = given().log().all().header("Content-Type","application/json")
		.body(PayLoad.AddBook(isbn,aisle))
		.when().post("/Library/Addbook.php")
		.then().log().all().assertThat().statusCode(200)
		.extract().response().asString();
		
		JsonPath js = ReusableMethods.rawToJSON(response);
				String id = js.get("ID");
				System.out.println(id);
	}
	@DataProvider(name="BookData")
	public Object[][] getData()
	{
		return new Object[][] {{"aqwer","9898"},{"cwetee","67890"},{"omketr","54678"}};
	}
}
