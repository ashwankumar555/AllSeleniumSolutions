package restAssured;

import files.PayLoad;
import files.ReusableMethods;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

	public static void main(String[] args) {
		JsonPath js = new JsonPath(PayLoad.CoursePrice());
		//Print no of courses returned by API.
		int count = js.getInt("courses.size()");
		System.out.println(count);
		
		//Print Purchase amount
		int totalAmount = js.getInt("dashboard.purchaseAmount");
		System.out.println(totalAmount);
		
		//Print title of the first course
		String titleFirstCourse = js.get("courses[0].title");
		System.out.println(titleFirstCourse);
		
		for(int i=0;i<count;i++)
		{
			String coursetitle = js.get("courses["+i+"].title");
			System.out.println(coursetitle);
			System.out.println(js.get("courses["+i+"].price").toString());
		}
		
		
		for(int i=0;i<count;i++)
		{
			String coursetitle = js.get("courses["+i+"].title");
			if(coursetitle.equalsIgnoreCase("RPA"))
			{
			System.out.println(js.get("courses["+i+"].copies").toString());
			break;
			}
		}
	}

}
