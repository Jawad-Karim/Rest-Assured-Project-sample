package paramsANDauthentications;

import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;

public class BaseClass4authentication {
	
	@BeforeClass
	public void setupAuthentication() {
		
		RestAssured.authentication = RestAssured.preemptive().basic("userName", "TestPassword");
		RestAssured.baseURI = "https://restapi.demoqa.com/authentication/CheckForAuthentication/";
	}
	
}
