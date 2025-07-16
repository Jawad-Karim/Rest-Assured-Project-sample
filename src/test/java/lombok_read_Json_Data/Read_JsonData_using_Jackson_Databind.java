package lombok_read_Json_Data;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Read_JsonData_using_Jackson_Databind {
	
	@Test
	public void test() throws Exception{
		
		RestAssured.baseURI = "https://reqres.in/api/users?page=2";
		RequestSpecification request = RestAssured.given();
		request.header("x-api-key", " reqres-free-v1");
		Response response = request.get();
		
		// store response into POJO
		Reqres_userList_POJO userList = response.as(Reqres_userList_POJO.class);
		
		// read String/Integer data | Array Data | Object Data
		System.out.println("user per page : "+userList.getPer_page());
		
		// read Array Data 
		List<DataPOJO> dataList = userList.getData();
		String fName = dataList.get(0).getFirst_name();
		System.out.println("6th ID's first name: "+ fName);
		
		// read Object Data
		SupportPOJO support = userList.getSupport();
		String text = support.getText();
		System.out.println("message text: "+ text);	
		
		// print response body
		System.out.println(response.asPrettyString());
			
		/* read Json data from Json file
		
		File file = new File("file_path");
		ObjectMapper objectMapper = new ObjectMapper();
		Reqres_userList_POJO userList1 = objectMapper.readValue(file, Reqres_userList_POJO.class);
		 
		 */		
	}		
}
