package validations;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Validation2 {
	/*
	get("/x").then().assertThat().statusCode(200). ..
	get("/x").then().assertThat().statusLine("something"). ..
	get("/x").then().assertThat().statusLine(containsString("some")). ..
	
	get("/x").then().assertThat().header("headerName", "headerValue"). ..
	get("/x").then().assertThat().headers("headerName1", "headerValue1", "headerName2", "headerValue2"). ..
	get("/x").then().assertThat().headers("headerName1", "headerValue1", "headerName2", containsString("Value2")). ..
	
	get("/x").then().assertThat().contentType(ContentType.JSON). ..
	get("/x").then().assertThat().body(equalTo("something")). ..
	
	get("/x").then().body("href", endsWithPath("userId"));
	get("/x").then().body("href", and(startsWith("http:/localhost:8080/"), endsWithPath("userId")));
	
	long timeInMs = get("/lotto").time();
	long timeInSeconds = get("/lotto").timeIn(SECONDS);
	
	when().
      get("/lotto").
	then().
      time(lessThan(2000L)); // Milliseconds
      
      get("/lotto").then().body("lotto.lottoId", equalTo(5));
      get("/lotto").then().body("lotto.winners.winnerId", hasItems(23, 54));
      
      	{
    	"price":12.12 
    	}
    	get("/price").then().body("price", is(12.12f));
    	
	 */	
	@Test
	public void validateResponse() {

		RestAssured.baseURI = "https://reqres.in/";
		RestAssured.given()
		.when()
		.get("api/users?page=2")
		.then().assertThat()
		.statusCode(200);


	}

}
