package apiTesting;

// for given(), when(), then()
import static io.restassured.RestAssured.given;

import java.io.FileWriter;
import java.io.IOException;

import io.restassured.response.Response;

public class GetStatusCodeTest {

    public static void main(String[] args) {
    	Response response = given()
            .baseUri("https://reqres.in/api")
        .when()
            .get("/users/2")
        .then()
            .statusCode(200)    // validate status code
            .log().all().extract().response();

        // Convert response to String
        String jsonResponse = response.asPrettyString();
        //System.out.println(jsonResponse);

        // Save response to a .json file
        try (FileWriter file = new FileWriter("response.json")) {
            file.write(jsonResponse);
            System.out.println("✅ Response saved to response.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}