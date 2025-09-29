package restAssured;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.github.tomakehurst.wiremock.WireMockServer;

public class WireMockRestAssuredTest {

    private static WireMockServer wireMockServer;

    public static void setup() {
        wireMockServer = new WireMockServer(8089);
        wireMockServer.start();

        configureFor("localhost", 8089);

        stubFor(get(urlEqualTo("/users/1"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{ \"id\": 1, \"name\": \"Ashwin\" }")));

        stubFor(post(urlEqualTo("/users"))
                .withRequestBody(equalToJson("{ \"name\": \"Akhira\" }"))
                .willReturn(aResponse()
                        .withStatus(201)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{ \"id\": 2, \"name\": \"Akhira\" }")));
    }

 
    public static void teardown() {
        wireMockServer.stop();
    }

 
    public void testGetUser() {
        given()
                .baseUri("http://localhost:8089")
        .when()
                .get("/users/1")
        .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("name", equalTo("Ashwin"));
    }

 
    public void testPostUser() {
        given()
                .baseUri("http://localhost:8089")
                .header("Content-Type", "application/json")
                .body("{ \"name\": \"Akhira\" }")
        .when()
                .post("/users")
        .then()
                .statusCode(201)
                .body("id", equalTo(2))
                .body("name", equalTo("Akhira"));
    }
}

