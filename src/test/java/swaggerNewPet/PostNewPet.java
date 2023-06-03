package swaggerNewPet;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostNewPet {
	
	@Test(priority=1)
	public void testNewPet() {
		
		CategoryPOJO categorypojo = new CategoryPOJO();
		categorypojo.setId(43);
		categorypojo.setName("jaswal");
		
		List<String> photourls = new ArrayList<String>();
		photourls.add("http://shsgllhl.com");
		photourls.add("http;//shgjhllh.com");
		photourls.add("http;//dsghlkgjhi.com");
		
		TagsPOJO tagpojo1 = new TagsPOJO();
		tagpojo1.setId(54);
		tagpojo1.setName("karim");
		
		TagsPOJO tagpojo2 = new TagsPOJO();
		tagpojo2.setId(55);
		tagpojo2.setName("Johans");
		
		List<TagsPOJO> tagList = new ArrayList<TagsPOJO>();
		tagList.add(tagpojo1);
		tagList.add(tagpojo2);
		
		PostSwaggerNewPetPOJO psp = new PostSwaggerNewPetPOJO();
		psp.setId(67);
		psp.setCategory(categorypojo);
		psp.setName("Jack");
		psp.setPhotoUrls(photourls);
		psp.setTags(tagList);
		psp.setStatus("available");
		
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
		RequestSpecification request = RestAssured.given();
		
		request.contentType(ContentType.JSON);
		request.body(psp);
		Response response = request.put("/pet");
		
		String body = response.asPrettyString();
		System.out.println("body : "+body);
	}
	
	
	@Test(priority=2)
	public void getDeserialization() {
		
		PostSwaggerNewPetPOJO psnp = RestAssured.get("https://petstore.swagger.io/v2/pet").as(PostSwaggerNewPetPOJO.class);
		
		System.out.println("id : "+psnp.getId());
		System.out.println("tags Name : "+ psnp.getName());
		System.out.println("status : "+psnp.getStatus());
		
		}
}
