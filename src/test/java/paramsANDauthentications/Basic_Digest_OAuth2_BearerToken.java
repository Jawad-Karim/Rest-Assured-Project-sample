package paramsANDauthentications;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Basic_Digest_OAuth2_BearerToken {


	@Test
	public void basic_auth() {

		RestAssured.baseURI = "https://postman-echo.com";
		RequestSpecification request = RestAssured.given();
		request.auth().basic("postman", "password");
		Response response = request.get("/basic-auth");
		Assert.assertEquals(200, response.getStatusCode());

	}


	@Test
	public void basic_auth_premptive() {

		RestAssured.baseURI = "https://postman-echo.com";
		RequestSpecification request = RestAssured.given();
		request.auth().preemptive().basic("postman", "password");
		Response response = request.get("/basic-auth");
		Assert.assertEquals(200, response.getStatusCode());

	}


	@Test
	public void digest_auth() {

		RestAssured.baseURI = "https://postman-echo.com";
		RequestSpecification request = RestAssured.given();
		request.auth().digest("postman", "password");
		Response response = request.get("/digest-auth");
		response.then().log().all();
		Assert.assertEquals(200, response.getStatusCode());

	}

	String token = "";

	//@Test
	public void Oauth_2() {
		
		//given().auth().preemptive().oauth2(accessToken);

		RestAssured.baseURI = "https://postman-echo.com";
		RequestSpecification request = RestAssured.given();
		request.auth().oauth2(token);
		Response response = request.get("/Oauth2");		
		response.then().assertThat().statusCode(200);
		Assert.assertEquals(200, response.getStatusCode());

	}


	//@Test
	public void bearerToken() {

		RestAssured.baseURI = "https://postman-echo.com";
		RequestSpecification request = RestAssured.given();
		request.header("Authorization", "Bearer " + token)
		.header("Content-Type", "application/json");
		Response response = request.get("/bearer-token");
		Assert.assertEquals(200, response.getStatusCode());

	}

}
