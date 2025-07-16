Types of Parameters in Rest Assrued    
------------------------------------     
1. Query Parameter    
: Query Parameters are appended to URI after Question Mark (?)  they are used to filter or sort the response.    
: Example-  
                     
                        given()  
                            .queryParam("key", "value")  
                            .queryParam("filter", "active")  
                        .when()  
                            .get("/api/resource")  
                        .then()  
                            .statusCode(200);  
     
    
2. Path Parameter  
: Path Parameters are part of URI itself used to specify a specific resource.   
: Exmple-

                        given()
                            .pathParam("id", 123)
                        .when()
                            .get("/api/resource/{id}")
                        .then()
                            .statusCode(200);


3. Form Parameter    
: Form Parameters are used send data into POST request body   
: Example-  

                        given()  
                            .formParam("username", "john_doe")  
                            .formParam("password", "123456")  
                        .when()  
                            .post("/login")  
                        .then()  
                            .statusCode(200);  
      
  
4. Generic Parameters   
: Generic Parameters are used as Query and Form Parameter both. Rest Assured will determine how it will be used.  
: Example-  

                        // Using param for query parameters  
                        given()  
                            .param("search", "test")  
                            .param("page", 2)  
                        .when()  
                            .get("/api/resource")  
                        .then()  
                            .statusCode(200);  
              
                        // Using param for form parameters  
                        given()  
                            .param("username", "john_doe")  
                            .param("password", "123456")  
                        .when()  
                            .post("/login")  
                        .then()  
                            .statusCode(200);  


: Lombok for payload POJO  
---------------------------  
Use Lombok instead of using boiler plate code Getter/Setter method.  
How to generate POJO ?  
: Google - POJO generator - copy/pase Json body - it will generate POJO class...   

Usage   
--------   
step 1. download lombok jar and then install into Eclipse   
: maven repo - click on lombok jar - download.   
: click on downloaded lombok jar - Eclipse - finish installing into Eclipse.   
: add lomobok dependency to POM  - Restart Eclipse IDE   

step 2. Create POJO for payload.   
: regular approach   
------------------   
public class A {   

	private String name;   
	private int id;    
	private String school;	 
	
	// NO arguments constructor   
	public A() { }   
	
	// All argumnts constructor	  
	public A(String name, int id, String school) {   
		this.name = name;  
		this.id = id;  
		this.school = school;  
	}  
	//setter|getter   
	public String getName() {  
		return name;   
	}   
	public void setName(String name) {   
		this.name = name;   
	}   
	public int getId() {   
		return id;   
	}   
	public void setId(int id) {   
		this.id = id;   
	}   
	public String getSchool() {   
		return school;   
	}   
	public void setSchool(String school) {   
		this.school = school;   
	}   
	// to String method   
	@Override   
	public String toString() {   
		return "A [name=" + name + ", id=" + id + ", school=" + school + "]";   
	}	   
}    
: Lombok approach   
--------------   
@NoArgsConstructor   
@AllArgsConstructor   
@ToString   
@Setter   
@Getter   
@Data   
public class A {    
	private String name;     
	private int id;     
	private String school;  
   
}  

OR   
---    
// @Data works for (@NoArgsConstructor, @ToString, @Setter and @Getter | but it does not support @AllArgsConstructor)    
@Data   
public class A {     
	private String name;     
	private int id;     
	private String school;	     
   
  }   
: test method  
---
@Test   
	public void test() {   
		   
		A a1 = new A();   
		a1.setId(344);   
		a1.setName("jawad");   
		a1.setSchool("Harvard");   
		
		System.out.println(a1.getId());   
		System.out.println(a1.getName());   
		System.out.println(a1.getSchool());   

      		A a2 = new A("Jawad",101, "Harvard");   [for this instance we need to use annotation @AllArgsConstructor]   
		System.out.println(a2.getName());   
		System.out.println(a2.getId());		
		System.out.println(a2.getSchool());   
    
	}   

 Builder Design Pattern   
 --------------------   
 there is a another Lombok annotation called @Builder.    
 that's help us to design our POJO at class level, constructor level, and method level.   
 
 : Class level approach   
 ---------   
@Getter   
@Builder   
public class A {  
	private String name;  
	private int id;  
	private boolean isActive;  		
}   

@Test   
	public void test() {   

		A a1 = A.builder().name("Jawad").id(201).isActive(true).build();   
		System.out.println(a1.getName()); 	//Jawad   
		System.out.println(a1.getId()); 	  //201  
		System.out.println(a1.isActive());	//true  

		A a2 = A.builder().name("Jawad").id(201).build();  // will return only default values  
		System.out.println(a2.isActive()); 	               // false  
		
		A a3 = A.builder().build(); 		    // will return only default values  
		System.out.println(a3.getId()); 	  // 0  
	}  

 : Method level Approach  
 -----------------  
 @Getter  
public class A {   

	private String name;   
	private int id;   
	private boolean isActive;  
	
	public A(String name, int id, boolean isActive) {  
		this.name = name;  
		this.id = id;  
		this.isActive = isActive;  
	}	  
	
	@Builder  
	public static A createInstance(String name, int id) {  
		return new A(name, id, true);  		
	}	  
}  
____________  
@Test  
	public void test() {  

		A a1 = A.builder().name("Jawad").id(201).build();  
		System.out.println(a1.getName()); 	//Jawad    
		System.out.println(a1.getId()); 	//201  
		System.out.println(a1.isActive());	//true    
	}  


 Read Json data using Jackson databind library
----------------------------------------------
step 1. add jackson-databind dependency to POM.
Example of Json response :   
{  
    "page": 1,  
    "per_page": 6,  
    "total": 12,  
    "total_pages": 2,  
    "data": [  
        {  
            "id": 1,  
            "email": "george.bluth@reqres.in",  
            "first_name": "George",  
            "last_name": "Bluth",  
            "avatar": "https://reqres.in/img/faces/1-image.jpg"  
        }           
    ],  
    "support": {  
        "url": "https://contentcaddy.io?utm_source=reqres&utm_medium=json&utm_campaign=referral",  
        "text": "Tired of writing endless social media content? Let Content Caddy generate it for you."  
    }  
}  

step 2. create POJO for every json data attribute  
@Data
public class Reqres_userList_POJO {
	
	// we can store Integer data into String variable
	int page;
	int per_page;
	int total;
	String total_pages;
	List<DataPOJO> data;
	SupportPOJO support;
}
-----------
@Data
public class DataPOJO {
	
	int id;
	String email;
	String first_name;
	String last_name;
	String avatar;
}
----------
@Data
public class SupportPOJO {
	
	String url;
	String text;
}

step 3. verify response data
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
			
		// read Json data from Json file.....   
		File file = new File("file_path");
		ObjectMapper objectMapper = new ObjectMapper();
		Reqres_userList_POJO userList1 = objectMapper.readValue(file, Reqres_userList_POJO.class);		 				
	}
}



