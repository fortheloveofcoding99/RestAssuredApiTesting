import java.util.Scanner;

import org.testng.Assert;

import files.payLoads;
import io.restassured.path.json.JsonPath;

public class JsonNodesOnConditionLogic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JsonPath js3 = new JsonPath(payLoads.coursePrice());
		int count = js3.getInt("courses.size()");
		
		System.out.println("Print the number of courses sold by a specific course");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name of the course");
		String corse = sc.nextLine();
		sc.close();
		
		for (int i=0;i<count;i++)
		{
			String corse_name = js3.getString("courses["+i+"].title");
			if (corse_name.equalsIgnoreCase(corse))
			{
				System.out.println(js3.getInt("courses["+i+"].price"));
				break;
			}
			
		}
		
		System.out.println("print the total amnt");
		int expected_total = js3.getInt("dashboard.purchaseAmount");
		int net_total = 0;
		for (int i=0;i<count;i++)
		{
			int corse_price = js3.getInt("courses["+i+"].price");
			int copies_sold = js3.getInt("courses["+i+"].copies");
			int course_total = corse_price*copies_sold;
			net_total = net_total+course_total;
					
		}	
		System.out.println(net_total);
		
		Assert.assertEquals(net_total, expected_total);
		
	}

}
