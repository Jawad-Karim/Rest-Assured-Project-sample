package validations;

/*
 *********** validation and assertion for Swagger Pet API *************************

System.out.println("id : "+ response.body().path("id"));
System.out.println("category-id : "+ response.body().path("category.id"));
System.out.println("category-name : "+ response.body().path("category.name"));
System.out.println("name : "+ response.body().path("name"));
System.out.println("photoUrls : "+ response.body().path("photoUrls[0]"));
System.out.println("photoUrls : "+ response.body().path("photoUrls[1]"));
System.out.println("tags id1 : "+ response.jsonPath().get("tags[0].id"));
System.out.println("tags name1 : "+ response.jsonPath().get("tags[0].name"));
System.out.println("tags id1 : "+ response.jsonPath().getInt("tags[1].id"));
System.out.println("tags name1 : "+ response.jsonPath().getString("tags[1].name"));
System.out.println("status : "+ response.jsonPath().get("status"));
		
int respID = response.body().path("id");
int categoryID = response.body().path("category.id");
String categoryName = response.body().path("category.name");
String respName =  response.body().path("name");
String catUrl = response.body().path("photoUrls[0]");
String dogUrl = response.body().path("photoUrls[1]");
Int total_url = response.body().path("photoUrls.size()");
		
Assert.assertEquals(respID, 789);
Assert.assertEquals(categoryID, 456);
Assert.assertEquals(categoryName, "create a dog record");
Assert.assertEquals(respName, "new pet");
Assert.assertEquals(catUrl, "http://photoUrl");
Assert.assertEquals(dogUrl, "http://adghhdlj.com");
Assert.assertEquals(response.jsonPath().get("tags.size()"), 6);
Assert.assertEquals(response.jsonPath().get("tags[0].id"), 3031);
Assert.assertEquals(response.jsonPath().get("tags[0].name"), "american dog");
Assert.assertEquals(response.jsonPath().get("tags[1].id"), 3032);
Assert.assertEquals(response.jsonPath().get("tags[1].name"), "Persian dog");
Assert.assertEquals(response.jsonPath().get("status"), "added new pet");
*/

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class Validation1 {
	
	@Test
	public void reqresUsers() {
		
		RestAssured.baseURI = "https://reqres.in";
		RequestSpecification request = RestAssured.given();
		request.param("page", "1");
		Response response = request.get("/api/users");
		JsonPath jsonData = response.getBody().jsonPath();
		
		//System.out.println(response.asPrettyString());
		
		//******* validate response Status ************
		Assert.assertEquals(response.statusCode(), 200);
		Assert.assertEquals(response.statusLine(), "HTTP/1.1 200 OK");
		Assert.assertEquals(response.statusLine().contains("OK"), true);
		Assert.assertTrue(response.time() < 2500);
		
		//****** validate response header *************
		Assert.assertEquals(response.contentType(), "application/json; charset=utf-8");
		Assert.assertEquals(response.header("Content-Encoding"), "gzip");
		Assert.assertEquals(response.header("Server"), "cloudflare");
		
		String contentLength = response.header("Content-Length");
		//Assert.assertTrue(Integer.parseInt(contentLength)>100);
		String cooki = response.getCookie("");
		System.out.println("Response body : "+ response.body().asPrettyString());
		
	}

}
