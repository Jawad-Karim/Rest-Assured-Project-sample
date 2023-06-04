package postAPIswagger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRegular {
	
	@Test
	public void regularApproach() {
		
		RestAssured.baseURI = "https://petstore.swagger.io/v2/pet";
		
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		request.contentType(ContentType.JSON);
		
		//************* map for category ******************************
		Map <Object, Object> categoryMap = new HashMap<Object, Object>();
		categoryMap.put("id", 24);
		categoryMap.put("name", "jawad");
		
		//*************** List for urls ***************************
		List <String> urlList = new ArrayList<String>();
		urlList.add("www.aggak.com");
		urlList.add("www.glhhg.com");
		urlList.add("www.hglskghj.com");
		
		//******************** map for tags list ****************************
		Map <Object, Object> jo1 = new HashMap<Object, Object>();
		jo1.put("id", 66);
		jo1.put("name", "khushi");
		
		Map <Object, Object> jo2 = new HashMap<Object, Object>();
		jo2.put("id", 67);
		jo2.put("name", "thushi");
		
		List <Object> tagsList = new ArrayList<Object>();
		tagsList.add(jo1);
		tagsList.add(jo2);
		
		//*************** map for main json body **************************
		Map <Object, Object> MainMap = new HashMap<Object, Object>();
		MainMap.put("id", 21);
		MainMap.put("category", categoryMap);
		MainMap.put("name", "cattie");
		MainMap.put("photoUrls", urlList);
		MainMap.put("tags", tagsList);
		MainMap.put("status", "not available");
		
		Response response = request.body(MainMap).put();
		
		System.out.println("response body : "+ response.asPrettyString());	
		
	}
	

}
