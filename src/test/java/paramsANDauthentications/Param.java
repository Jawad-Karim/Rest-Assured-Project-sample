package paramsANDauthentications;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Param {

	@Test(priority=1)
	public void queryParameter() {

		// complete URI - https://reqres.in/api/users?page=2
		// query parameter - page=2

		RestAssured.baseURI = "https://reqres.in/";
		RequestSpecification request = RestAssured.given();
		request.queryParam("page", "2");
		Response response = request.get("/api/users");
		System.out.println("response: "+ response.body().asPrettyString());

	}

	@Test(priority=2)
	public void pathParameter() {

		// complete URI - https://reqres.in/api/users?page=2
		// path parameter - api/, users  OR api/users

		RestAssured.baseURI = "https://reqres.in/";
		RequestSpecification request = RestAssured.given();
		request.pathParam("myPath", "api/users");
		request.queryParam("page", "2");
		Response response = request.get("{myPath}");
		System.out.println("response: "+ response.body().asPrettyString());

	}

	@Test(priority=3)
	public void parameters() {

		// complete URI - https://reqres.in/api/users?page=2

		RestAssured.given()
			.pathParam("myPath1", "api")
			.pathParam("myPath2", "users")
			.queryParam("page", 1)
			.queryParam("id", 4)

		.when()
			.get("https://reqres.in/{myPath1}/{myPath2}")

		.then()
			.statusCode(200)
			.log().all();

	}

}
