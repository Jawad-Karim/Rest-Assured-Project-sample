package restAssred_reqres_Tests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test_GetMethod {
	
	String baseUrl = "https://reqres.in/";
	
	@Test
	public void getMethodTest() {
		
		RestAssured.baseURI = baseUrl;
		
		RequestSpecification request = RestAssured.given();
		Response response = request.get("api/users?page=2");
		
		String status = response.getStatusLine();
		int statusCode = response.getStatusCode();
		long responseTime = response.getTime();
		String contentType = response.header("Content-Type");
		String serverType = response.header("server");
		String encoding = response.header("Content-Encoding");
		String contentLength = response.header("Content-Length");
		
		System.out.println("status : "+status);
		System.out.println("statusCode : "+statusCode);
		System.out.println("responseTime : "+responseTime);
		System.out.println("contentType : "+contentType);
		System.out.println("serverType : "+serverType);
		System.out.println("encoding : "+encoding);
		System.out.println("contentLength : "+contentLength);
		
		String bodyString = response.getBody().asPrettyString();
		
		System.out.println("body :  "+bodyString);
		
		JsonPath jo = response.body().jsonPath();
		
		String firstName = "data[4].first_name";
		System.out.println("fistName : "+jo.get(firstName));
	}

}
