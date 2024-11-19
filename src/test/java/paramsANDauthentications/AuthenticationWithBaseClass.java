package paramsANDauthentications;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class AuthenticationWithBaseClass extends BaseClass4authentication {
	
	@Test
	public void test1() {
		
		 int statusCode = RestAssured.given()
		.get()
		.statusCode();
		
		System.out.println("statusCode : "+ statusCode);  //200
	}

}
