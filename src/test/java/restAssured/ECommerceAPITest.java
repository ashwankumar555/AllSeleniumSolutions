package restAssured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import files.PayLoad;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.LoginRequest;
import pojo.LoginResponse;
import pojo.OrderDetail;
import pojo.Orders;

public class ECommerceAPITest {
	
	public static void main(String[] args)
	{
		
		RequestSpecification req= new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.setContentType(ContentType.JSON).build();
		LoginRequest loginrequest = new LoginRequest();
		loginrequest.setUserEmail("ashwinkumar.ganji@gmail.com");
		loginrequest.setUserPassword("Star@12345");
		
		RequestSpecification reqLogin = given().log().all().spec(req).body(loginrequest);
		LoginResponse loginresponse = reqLogin.when().post("/api/ecom/auth/login").then().extract().response()
				.as(LoginResponse.class);
		System.out.println(loginresponse.getToken());
		String token = loginresponse.getToken();
		String userId = loginresponse.getUserId();
		System.out.println(loginresponse.getUserId());
		//Add product
		RequestSpecification addProductBaseRequest= new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addHeader("authorization", token).build();
		
		RequestSpecification reqAddingProduct = given().log().all().spec(addProductBaseRequest).param("productName", "Laptop")
		.param("productAddedBy", userId)
		.param("productCategory", "fashion")
		.param("productSubCategory", "shirts")
		.param("productPrice", "11500")
		.param("productDescription", "Addias Originals")
		.param("productFor", "men")
		.multiPart("productImage", new File("C:\\Users\\user\\Downloads\\sample_media_file.png"));
		
		String addProductResponse = reqAddingProduct.when().post("/api/ecom/product/add-product")
		.then().log().all().extract().response().asString();
		JsonPath js = new JsonPath(addProductResponse);
		String productId = js.get("productId");
		
		//Create order 
		RequestSpecification createOrderBaseReq= new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addHeader("authorization", token).setContentType(ContentType.JSON).build();
		
		OrderDetail orderdetail = new OrderDetail();
		orderdetail.setCountry("India");
		orderdetail.setProductOrderedId(productId);
		
		List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();
		orderDetailList.add(orderdetail);
		
		Orders orders = new Orders();
		orders.setOrders(orderDetailList);
		
		RequestSpecification createOrderReq = given().log().all().spec(createOrderBaseReq).body(orders);
		
		String responseAddOrder = createOrderReq.when().post("/api/ecom/order/create-order").then().log().all()
		.extract().response().asString();
		
		System.out.println(responseAddOrder);
		
		//Delete Product
		RequestSpecification deleteProductBaseReq= new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addHeader("authorization", token).setContentType(ContentType.JSON).build();
		
		RequestSpecification deleteProductReq = given().log().all().spec(deleteProductBaseReq)
				.pathParam("productId", productId);
		
		String deleteProductResponse = deleteProductReq.when().delete("/api/ecom/product/delete-product/{productId}")
				.then().log().all().extract().response().asString();
		
		JsonPath js1 = new JsonPath(deleteProductResponse);
		Assert.assertEquals("Product Deleted Successfully", js1.get("message"));
	}
}
