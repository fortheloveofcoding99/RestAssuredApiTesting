import files.payLoads;
import io.restassured.path.json.JsonPath;

public class complexJsonParse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JsonPath js2 = new JsonPath(payLoads.coursePrice());
		
		// Print the number of courses printed by API
		
		int count = js2.getInt("courses.size()");
		System.out.println(count);
		// print purchase amount
		
		float pur = js2.getFloat("dashboard.purchaseAmount");
		System.out.println(pur);
		
		String name1 = js2.getString("courses[0].title");
		System.out.println(name1);
		
		int copies1 = js2.getInt("courses[2].copies");
		System.out.println(copies1);
		
		for (int i = 0;i<count;i++)
		{
			System.out.println(js2.getString("courses["+i+"].title"));
			System.out.println(js2.getInt("courses["+i+"].price"));
		}
		
		
	}

}
