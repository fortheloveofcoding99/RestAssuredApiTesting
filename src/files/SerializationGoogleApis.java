package files;

import org.testng.annotations.Test;

import Pojo.Addplace;
import Pojo.Location;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SerializationGoogleApis {
	
	@Test
	public void googleApis()
	{
		Addplace ap = new Addplace();
		ap.setAccuracy(50);
		ap.setAddress("212 fruhling Strasse");
		ap.setLanguage("Deutsch - IN");
		ap.setName("UnserHaus");
		ap.setPhone_number("(+91) 983 893 3900");
		ap.setWebsite("www.html.com");
		List <String> mylist = new ArrayList<String>();
		mylist.add("bioladen");
		mylist.add("kaufhaus");
		ap.setTypes(mylist);
		Location lo = new Location();
		lo.setLat(-38.389494);
		lo.setLng(33.427162);
		ap.setLocation(lo);
		
		
		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123")
									.setContentType(ContentType.JSON).build();
		
		ResponseSpecification resspec=  new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		RequestSpecification res = given().spec(req)
		.body(ap);
		Response response =	res.when().post("/maps/api/place/add/json")
		.then().spec(resspec).extract().response();
		
		String responseString = response.asPrettyString();
		System.out.println(responseString);
		
	}
}
