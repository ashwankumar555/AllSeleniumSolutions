package files;

import io.restassured.path.json.JsonPath;

public class ReusableMethods {

	public static JsonPath rawToJSON(String placeresponse)  {
		JsonPath js1 = new JsonPath(placeresponse);
		return js1;
	}
	
}
