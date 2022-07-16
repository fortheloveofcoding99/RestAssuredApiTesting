
import static io.restassured.RestAssured.given;

import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;


public class OAuthApiTesting {

	public static void main(String[] args) {
		
//		System.setProperty("webdriver.chrome.driver", "C://Users//befor//New folder//chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
//		driver.get("https://accounts.google.com/o/oauth2/v2/auth/oauthchooseaccount?scope=https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email&auth_url=https%3A%2F%2Faccounts.google.com%2Fo%2Foauth2%2Fv2%2Fauth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https%3A%2F%2Frahulshettyacademy.com%2FgetCourse.php&flowName=GeneralOAuthFlow");
//		driver.findElement(By.id("yDmH0d")).sendKeys("somsarkar9698@gmail.com");
//		driver.findElement(By.xpath(null)).sendKeys(Keys.ENTER);
		
		String url = "https://rahulshettyacademy.com/getCourse.php?code=4%2F0AX4XfWiFknjWJTyWpSEtycupFTR5CmluTbmL7BYuivKvVLkPgm0jqx07PjcUq_b7HmHsYA&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&prompt=consent";
		String parCode = url.split("code=")[1];
		String code = parCode.split("&scope")[0];
		System.out.println(code);
		String accessTokenResponse = given().urlEncodingEnabled(false)
		.queryParams("code",code)
		.queryParams("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.queryParams("client_secret","erZOWM9g3UtwNRj340YYaK_W")
		.queryParams("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
		.queryParams("grant_type","authorization_code")
		.queryParams("state", "verifyfjdss")
		.queryParams("session_state", "ff4a89d1f7011eb34eef8cf02ce4353316d9744b..7eb8")
		.when()
		.post("https://www.googleapis.com/oauth2/v4/token").asString();
		
		JsonPath js = new JsonPath(accessTokenResponse);
		String accessToken = js.getString("access_token");
		
		String resp = given().queryParam("access_token", accessToken)
		.when()
		.log()
		.all()
		.get("https://rahulshettyacademy.com/getCourse.php").asString();
		
		System.out.println(resp);
		


		
	}
	
	
}
