import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import files.payLoads;

public class checkApi extends payLoads{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI= "https://rahulshettyacademy.com";
		String response = given().queryParam("key", "qaclick123").header("Content-Type", "application/json")
		.body(payLoads.addPlace()).when().post("/maps/api/place/add/json").then().assertThat().statusCode(200)
		.body("scope", equalTo("APP")).extract().response().asString();
		
		JsonPath js= new JsonPath(response);
		String placeId = js.getString("place_id");
		
		given().queryParam("key", "qaclick123").header("Content-Type", "application/json").body("{\r\n"
				+ "\"place_id\":\""+placeId+"\",\r\n"
				+ "\"address\":\"70 sommer joggen, USA\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}").when().put("maps/api/place/update/json").then().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));
		
		String placeResponse = given().queryParam("key", "qaclick123").queryParam("place_id", placeId).when().get("/maps/api/place/get/json").then().assertThat()
		.statusCode(200).extract().response().asString();		
		
		System.out.println(placeResponse);
	}

}
