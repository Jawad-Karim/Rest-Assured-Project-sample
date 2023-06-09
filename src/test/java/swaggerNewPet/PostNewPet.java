package swaggerNewPet;
import java.util.ArrayList;
import java.util.List;
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

public class PostNewPet {

	@Test(priority=1)
	public void testNewPet() {

		//************* set value data for category *********************
		CategoryPOJO categorypojo = new CategoryPOJO();
		categorypojo.setId(43);
		categorypojo.setName("jaswal");

		//************* initialize data for url lis **********************
		List<String> photourls = new ArrayList<String>();
		photourls.add("http://shsgllhl.com");
		photourls.add("http;//shgjhllh.com");
		photourls.add("http;//dsghlkgjhi.com");

		//*************** set value data for Tags ***********************
		TagsPOJO tagpojo1 = new TagsPOJO();
		tagpojo1.setId(54);
		tagpojo1.setName("karim");

		TagsPOJO tagpojo2 = new TagsPOJO();
		tagpojo2.setId(55);
		tagpojo2.setName("Johans");

		List<TagsPOJO> tagList = new ArrayList<TagsPOJO>();
		tagList.add(tagpojo1);
		tagList.add(tagpojo2);

		//*************** set value for post body ******************************
		NewPetPOJO psp = new NewPetPOJO();
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

		NewPetPOJO psnp = RestAssured.get("https://petstore.swagger.io/v2/pet").as(NewPetPOJO.class);

		System.out.println("id : "+psnp.getId());
		System.out.println("tags Name : "+ psnp.getName());
		System.out.println("status : "+psnp.getStatus());
	}
}
