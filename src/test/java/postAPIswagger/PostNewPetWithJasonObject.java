package postAPIswagger;

import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/*
{
 "id": 0,
 "category": {
   "id": 0,
   "name": "string"
 },
 "name": "doggie",
 "photoUrls": [
   "string"
 ],
 "tags": [
   {
     "id": 0,
     "name": "string"
   }
 ],
 "status": "available"
}
 */
public class PostNewPetWithJasonObject {
	
	@Test
	public void putValuesWithJsonObject() {
		
		RestAssured.baseURI = "https://petstore.swagger.io/v2/pet";
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "Appication/Json");
		request.contentType(ContentType.JSON);
	

	//******************** set values for category with Json Objec************************		
		JSONObject category1 = new JSONObject();
		category1.put("id", 121);
		category1.put("name", "Thomas");
		
	//****************** set values for photoUrls list **********************************
		List<String> url1 = new ArrayList<String>();
		url1.add("http://wwww.catphoto.com");
		url1.add("http://www.dogphoto.com");
		
		//********************* set values for tag Objects ********************************
		JSONObject ob1 = new JSONObject();
		ob1.put("id", 001);
		ob1.put("name", "mark");
		
		JSONObject ob2 = new JSONObject();
		ob2.put("id", 002);
		ob2.put("name", "clarkson");
		
		//******************* Set values for tags list *******************************
		List<Object> tag1 = new ArrayList<Object>();
		tag1.add(ob1);
		tag1.add(ob2);
		
		//************************** set values for main Post Body **********************
		JSONObject PayloadBody = new JSONObject();
		PayloadBody.put("id", 4001);
		PayloadBody.put("Category", category1);
		PayloadBody.put("name", "Sweet Pet");
		PayloadBody.put("photoUrls", url1);
		PayloadBody.put("tags", tag1);
		PayloadBody.put("status", "available: 10");
		
		Response response = request.body(PayloadBody).post();
		
		String ResonseStatus = response.getStatusLine();
		int status_code = response.getStatusCode();
		long responseTime = response.getTime();
		String headerContentType = response.header("Content-Type");
		//String bodyAsString = response.getBody().asPrettyString();
		String tagName = response.getBody().jsonPath().getString("tags[0].name");
		
		System.out.println("status: "+ResonseStatus+"\n"+"status code: "+status_code);
		System.out.println("response time: "+responseTime+"\n"+"content type: "+ headerContentType);
		System.out.println("tag: "+tagName);
		
		
		System.out.println();
	
	}
}
