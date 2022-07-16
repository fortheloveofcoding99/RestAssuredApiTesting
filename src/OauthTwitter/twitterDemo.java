package OauthTwitter;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class twitterDemo {
	
	@Test
	public void postTweet()
	{
		Response resp = RestAssured.given()
						.auth()
						.oauth("rZfiAtxjvPooAjuIYn3IVUzfb", 
								"o2ggh9FOfTmj9OXlaxaBpiHVmlp7q7GMY4qA2OxtG0PmV6WB6l",
								"3179973716-X5h8HjrvePSd7qFnJNhrXfR36yrAKi41BLw3bdf",
								"QvjpVSkJnzukbHP0Xm1dKpfUchHpK1jPwNLiMbOZikW0R")
						.post("https://api.twitter.com/1.1/statuses/update.json?status=mein ersten tweet via API ,checking oauth, auf eclipse");
		System.out.println(resp.getBody().asPrettyString());
	}	

}
