package postAPIswagger;

import java.util.ArrayList;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostNewPetTEST {
	
	@Test
	public void postNewPet() {
		
		RestAssured.baseURI = "https://petstore.swagger.io/v2/pet";
		
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		request.contentType(ContentType.JSON);
		
		//************* set value data for category *********************
		CategoryPOJO category = new CategoryPOJO();
		category.setId(26);
		category.setName("jojo");
		
		//************* initialize data for url lis **********************
		ArrayList<Object> url_list = new ArrayList<Object>();
		url_list.add("https://shlksgjlakjjlkahligl.com");
		url_list.add("https://hlghhgiiojlhighjirhih.com");
		
		//*************** set value data for Tags ***********************
		TagsPOJO tag1 = new TagsPOJO();
		tag1.setId(41);
		tag1.setName("suku");
		
		TagsPOJO tag2 = new TagsPOJO();
		tag2.setId(42);
		tag2.setName("susu");
		
		ArrayList<TagsPOJO> tagList = new ArrayList<TagsPOJO>();
		tagList.add(tag1);
		tagList.add(tag2);
		
		//*************** set value for post body ******************************
		PetPOJO pet = new PetPOJO();
		pet.setId(44);
		pet.setCategory(category);
		pet.setName("Tomas");
		pet.setPhotoUrls(url_list);
		pet.setTags(tagList);
		pet.setStatus("will be available");
		
		Response response = request.body(pet).put();
		String body = response.getBody().asPrettyString();
		
		System.out.println("body :  "+ body);
		System.out.println("status line : "+ response.getStatusLine());
		System.out.println("status : "+ response.body().path("tags[0].name"));
		System.out.println("status 2: "+response.jsonPath().get("tags[1].name"));
	}

}
