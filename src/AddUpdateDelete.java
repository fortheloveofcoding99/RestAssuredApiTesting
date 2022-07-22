package AddingAndDeletingResource;
import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;



public class AddUpdateDelete {
	
	String id;
	@Test(dataProvider="Peopleprofile", enabled=true)
	public void test1(String names, String jobs)
	{
		RestAssured.baseURI = "https://reqres.in/";
		
		String resp = given().header("Content-type", "application/json").body(payloads.addBody(names, jobs)).when()
				.post("/api/users").then().extract().asString();
		System.out.println("Response starts here--"+resp);
		
		JsonPath js1 =new JsonPath(resp);
		
		id = js1.get("id");
		System.out.println(id);
			
	}
	
	@Test(dataProvider="updateprofile", enabled=true)
	public void test2(String names, String jobs)
	{
		RestAssured.baseURI = "https://reqres.in/";
		
		String resp = given().header("Content-type", "application/json").body(payloads.addBody(names, jobs)).when()
				.put("/api/users/"+id+"").then().extract().asString();
		System.out.println("Response starts here--"+resp);
		
			
	}
	@Test
	public void test3()
	{
		RestAssured.baseURI = "https://reqres.in/";
		
		Response resp = given().header("Content-type", "application/json").when()
				.delete("/api/users/"+id+"").then().extract().response();
		System.out.println(resp);
		
			
	}
	
	
	@DataProvider(name="Peopleprofile")
	  public Object[][] getData(){
		  //Multidimensional Array object [][]
		  return new Object[][] {{"Chris Haddfield","Astronaut1"},{"Roger Penstone","Physician"}};
	}		  
		  @DataProvider(name="updateprofile")
		  public Object[][] updateData(){
			  //Multidimensional Array object [][]
			  return new Object[][] {{"Stephen Hawking","Mathematician"},{"Tesla","Physician"}};
		  
	}
}
