package restAssred_reqres_Tests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.ResponseBody;

public class Test_Get_userList extends RestBaseClass{

	@BeforeClass
	public void get_test() {

		RestAssured.baseURI = "https://reqres.in/api";

		request = RestAssured.given();
		response = request.get("/users?page=1");			
	}

	@Test
	public void getStatus() {

		String status_line = response.getStatusLine();
		System.out.println("status_line : "+status_line);
	}

	@Test
	public void getStatus_code() {

		int status_code = response.getStatusCode();
		System.out.println("status_code : "+status_code);
	}

	@Test
	public void getContentType() {

		String contentType = response.header("Content-Type");
		System.out.println("content type : "+contentType);
	}
	@Test
	public void getServer_type() {

		String server_type = response.header("server");
		System.out.println("server type : "+server_type);
	}
	@Test
	public void getEncoding_type() {

		String encondin_type = response.getHeader("Content-Encoding");
		System.out.println("encoding type : "+encondin_type);
	}

	@Test
	public void getResponstime() {

		long response_time = response.getTime();
		System.out.println("response time : "+response_time);
	}

	@Test
	public void getContent_length() {

		String content_length = response.header("Content-Length");
		System.out.println("contenth length : "+ content_length);
	}

	@Test
	public void getBody_string() {

		ResponseBody body = response.getBody();
		System.out.println("body : "+ body);

		String bodyString = body.asPrettyString();
		System.out.println("body as string  :  "+bodyString);

		System.out.println("page no : "+response.getBody().jsonPath().get("page"));
		System.out.println("length of array : "+response.getBody().jsonPath().get("data.size()"));
		System.out.println("firstName : "+response.getBody().jsonPath().get("data[3].first_name"));	
		System.out.println("firstName : "+response.getBody().jsonPath().get("data[1].first_name"));

		/* output:
		page no : 1
		length of array : 6
		firstName : Eve
		firstName : Janet
		 */
	}
}
