package restAssured;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import static io.restassured.RestAssured.given;

public class JiraAPIToken {

    public static void main(String[] args) {

        // Jira base URL
        //RestAssured.baseURI = "https://ashwinkumarganji.atlassian.net/";

        // Replace with your email + API token
        String email = "ashwinkumarganji@gmail.com";
        String apiToken = "1234";
        // Encode to Base64 (email:apiToken)
        String auth = Base64.getEncoder()
                .encodeToString((email + ":" + apiToken).getBytes(StandardCharsets.UTF_8));

        // 1️⃣ Create issue
        String createIssueResponse = given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Basic " + auth)
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
                        + "}")
                .log().all()
                .post("rest/api/3/issue")
                .then().log().all()
                .assertThat().statusCode(201)
                .extract().response().asString();

        JsonPath js = new JsonPath(createIssueResponse);
        String issueID = js.getString("id");
        System.out.println("✅ Created Issue ID: " + issueID);

        // 2️⃣ Attach file to issue
        String filePath = "C:\\Users\\user\\Downloads\\LibraryAPI.docx";
        File file = new File(filePath);

        given()
                .pathParam("key", issueID)
                .header("X-Atlassian-Token", "no-check")
                .header("Authorization", "Basic " + auth)
                .multiPart("file", file)
                .log().all()
                .post("rest/api/3/issue/{key}/attachments")
                .then().log().all()
                .assertThat().statusCode(200);

        System.out.println("📎 File attached successfully!");
    }
}
