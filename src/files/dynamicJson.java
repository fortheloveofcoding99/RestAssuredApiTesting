package files;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;

public class dynamicJson {
	
	@Test(dataProvider="AddBook")
	
	public void addBook(String aisle, String isbn)
	{
		RestAssured.baseURI = "http://216.10.245.166";
		String respCode1  = given().log().all().header("Content-type", "application/json").body(payLoads.libraryPayload1(aisle, isbn)).
		when().post("/Library/Addbook.php")
		.then().log().all()
		.assertThat().statusCode(200).extract().response().asString();
		
		System.out.println(respCode1);
		
		given().log().all().header("Content-type", "application/json");//add code
	}
	
	@DataProvider(name = "AddBook")
	public Object[][] getData()
	{
		return new Object[][] {{"lmnq","23239"},{"klkle","434341"},{"teraw","34009"}};
	}

}
