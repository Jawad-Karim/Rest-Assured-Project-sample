package paramsANDauthentications;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*; 
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Param {
	
	// @Test(priority=1)
	public void queryParameter() {

		// complete URI - https://reqres.in/api/users?page=2
		// query parameter - page=2

		RestAssured.baseURI = "https://reqres.in/";
		RequestSpecification request = RestAssured.given();
		
		request.queryParam("page", "2");
		
		Response response = request.get("/api/users");
		System.out.println("response: " + response.body().asPrettyString());

	}

	// @Test(priority=2)
	public void pathParameter() {

		// complete URI - https://reqres.in/api/users?page=2
		// path parameter - api/, users OR api/users

		RestAssured.baseURI = "https://reqres.in/";
		RequestSpecification request = RestAssured.given();
		
		request.pathParam("myPath", "api/users");
		request.queryParam("page", "2");
		
		Response response = request.get("{myPath}");
		System.out.println("response: " + response.body().asPrettyString());

	}

	/* Form Parameters are used to pass data into payload body.
	 
	 //Create a user
	  
	 { "name": "morpheus",
    	"job": "leader" }	   
	 */
	@Test
	public void form_aram() {

		//RestAssured.baseURI = "https://reqres.in/api/users";
		Response response = given().
				//contentType("application/json").
				header("x-api-key", "reqres-free-v1").
				header("Content-Type", "application/json").
				param("name", "morpheus").
				param("job", "leader").
	    when().
	       		post("https://reqres.in/api/users");
		
		System.out.println("response body: "+ response.asPrettyString());

	}
	
	
	@Test
	public void Generic_Param_as_QueryParam() {

		RestAssured.baseURI = "https://reqres.in/";
		RequestSpecification request = RestAssured.given();
		
		request.param("page", "2");
		
		Response response = request.get("/api/users");
		System.out.println("response: " + response.body().asPrettyString());
	}
	
	
	@Test
	public void Generic_Param_as_FormParam() {

		RestAssured.baseURI = "https://reqres.in/api/login";
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		
		request.param("username", "TomChoice1");
		request.param("email", "tomchoice1@yahoo.com");
		request.param("password", "tom1");
		
		Response response = request.post();
		System.out.println("response body: \n"+ response.asPrettyString());
		System.out.println("status code : "+ response.statusCode());
	}
	

	@Test(priority = 3)
	public void parameters() {

		// complete URI - https://reqres.in/api/users?page=2

		RestAssured.given()
		.pathParam("myPath1", "api")
		.pathParam("myPath2", "users")
		.queryParam("page", 1)

				.when().get("https://reqres.in/{myPath1}/{myPath2}")
				.then().statusCode(200).log().all();

	}

}
