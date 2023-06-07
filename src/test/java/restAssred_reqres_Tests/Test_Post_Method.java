package restAssred_reqres_Tests;
import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
/*
{
   "name": "morpheus",
   "job": "leader"
}
*/
public class Test_Post_Method extends RestBaseClass{
	
	@BeforeClass
	public void postNewUser() throws Exception {
		
		RestAssured.baseURI = "https://reqres.in/api";
		
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		
		Map <String, String> map = new HashMap<String, String>();
		map.put("name", "jawad");
		map.put("job", "tester");
		
		request.body(map);
		response = request.post("/user");		
		Thread.sleep(2000);		
	}
	
	@Test(priority=1)
	public void getStatus() {
		
		String status_line = response.getStatusLine();
		System.out.println("status_line : "+status_line);
	}
	
	@Test(priority=2)
	public void getStatus_code() {
		
		int status_code = response.getStatusCode();
		System.out.println("status_code : "+status_code);
	}
	
	@Test(priority=3)
	public void getContentType() {
		
		String contentType = response.header("Content-Type");
		System.out.println("content type : "+contentType);
	}
	
	@Test(priority=4)
	public void getServer_type() {
		
		String server_type = response.header("server");
		System.out.println("server type : "+server_type);
	}
	
	@Test(priority=5)
	public void getEncoding_type() {
		
		String encondin_type = response.getHeader("Content-Encoding");
		System.out.println("encoding type : "+encondin_type);
	}
	
	@Test(priority=6)
	public void getResponstime() {
		
		long response_time = response.getTime();
		System.out.println("response time : "+response_time);
	}
	
	@Test(priority=7)
	public void getContent_length() {
		
		String content_length = response.header("Content-Length");
		System.out.println("contenth length : "+ content_length);
	}
	
	@Test(priority=8)
	public void getBody_string() {
		
		ResponseBody body = response.getBody();
		System.out.println("body : "+ body);
		
		String bodyString = body.asPrettyString();
		System.out.println("body as string  :  "+bodyString);		
	}
}
