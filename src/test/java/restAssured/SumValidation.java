package restAssured;

import org.testng.Assert;
import org.testng.annotations.Test;
import files.PayLoad;
import io.restassured.path.json.JsonPath;


public class SumValidation {

	@Test
	public void sumOfCourses()
	{
	JsonPath js = new JsonPath(PayLoad.CoursePrice());
	int count = js.getInt("courses.size()");
	int sum = 0;
	for(int i=0;i<count;i++)
	{	
		int price = js.get("courses["+i+"].price");
		int copies = js.get("courses["+i+"].copies");
		int amount = price*copies;
		System.out.println(amount);
		sum = sum + amount;
	}
	System.out.println("Total sum of courses proce is: "+sum);
	int totalAmount = js.getInt("dashboard.purchaseAmount");
	Assert.assertEquals(sum, totalAmount);
	}
}