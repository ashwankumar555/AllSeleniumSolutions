package restAssured;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.testng.Assert;
import files.PayLoad;
import files.ReusableMethods;

public class BugTest {

	public static void main(String[] args) {
		
		RestAssured.baseURI="https://ashwinkumarganji.atlassian.net/";
		
		String createIssueReponse = given().header("Content-Type","application/json")
		.header("Authorization", "Basic YXNod2lua3VtYXJnYW5qaUBnbWFpbC5jb206QVRBVFQzeEZmR0YwcUZMS0h1NU94RU81QUQ4ZkFlZmJXSHZjYWIza0dFenB5Uldud25KN0NzUjhvMVc3V1VZcXNFdTEtUzlURm1aSG5TX002bVZhS2tiZllOODQ4alQtWkZ2OU5sLWhxUHROSWwtdEhTNHVhM2xYc3lCeHU2MFp1RjVqb1lvbGkxLTJ0ZjNOV0xSLXo4Rng2MGs5TW1LOU1BTHhsWks2T0QwVTVmWlBrMEgtSjRFPUFCODY0NDcz")
		.body("{\r\n"
				+ "    \"fields\": {\r\n"
				+ "        \"project\": {\r\n"
				+ "            \"key\": \"SEL\"\r\n"
				+ "        },\r\n"
				+ "        \"summary\": \"Collection Menu links are not working\",\r\n"
				+ "        \"description\": {\r\n"
				+ "            \"type\": \"doc\",\r\n"
				+ "            \"version\": 1,\r\n"
				+ "            \"content\": [\r\n"
				+ "                {\r\n"
				+ "                    \"type\": \"paragraph\",\r\n"
				+ "                    \"content\": [\r\n"
				+ "                        {\r\n"
				+ "                            \"type\": \"text\",\r\n"
				+ "                            \"text\": \"Creating of an issue using project keys and issue type names using the REST API\"\r\n"
				+ "                        }\r\n"
				+ "                    ]\r\n"
				+ "                }\r\n"
				+ "            ]\r\n"
				+ "        },\r\n"
				+ "        \"issuetype\": {\r\n"
				+ "            \"name\": \"Bug\"\r\n"
				+ "        }\r\n"
				+ "    }\r\n"
				+ "}\r\n"
				+ "")
		.log().all()
		.post("rest/api/3/issue").then().log().all().assertThat().statusCode(201).extract().response().asString();
		
		JsonPath js = new JsonPath(createIssueReponse);
		String issueID = js.getString("id");
		System.out.println(issueID);
		String dirtyPath = "‪C:\\Users\\user\\Downloads\\LibraryAPI.docx";
		String cleanPath = dirtyPath.replaceAll("[^\\x00-\\x7F]", ""); // removes non-ASCII chars

		File file = new File(cleanPath);

		
		given()
		.pathParam("key", issueID)
		.header("X-Atlassian-Token","no-check")
		.header("Authorization", "Basic YXNod2lua3VtYXJnYW5qaUBnbWFpbC5jb206QVRBVFQzeEZmR0YwcUZMS0h1NU94RU81QUQ4ZkFlZmJXSHZjYWIza0dFenB5Uldud25KN0NzUjhvMVc3V1VZcXNFdTEtUzlURm1aSG5TX002bVZhS2tiZllOODQ4alQtWkZ2OU5sLWhxUHROSWwtdEhTNHVhM2xYc3lCeHU2MFp1RjVqb1lvbGkxLTJ0ZjNOV0xSLXo4Rng2MGs5TW1LOU1BTHhsWks2T0QwVTVmWlBrMEgtSjRFPUFCODY0NDcz")
		.multiPart("file",new File(cleanPath)).log().all()
		.post("rest/api/3/issue/{key}/attachments").then().log().all().assertThat().statusCode(200);
	}

}
