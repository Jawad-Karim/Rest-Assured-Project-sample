package validations;

public class Validations_in_restAssured_postman {
	
	/*
	 *********** RestAssured validation and assertion for Swagger Pet API *************************
	 
	RestAssured.baseURI = "https://reqres.in";
	RequestSpecification request = RestAssured.given();
	request.param("page", "1");
	Response response = request.get("/api/users");
	JsonPath jsonData = response.getBody().jsonPath();

	System.out.println("Response body : "+ response.body().asPrettyString());
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
	
	
	********** postman variables and validations ******************************
	
**** variables
: variable is a key-value paires. When need to use same value again and again then we need to use variable.
: variable can be created at .... 
global level(accessible from any collecttion)- eye/view button > global add > name > value > save.
collection level(accessible from collection)- select collection (…) > Edit > varible > name > value > save.
Environment level- eye/view button > Environment add > name > value > save.
Local/request level- Pre-request Script > pm.variables.set(“key”, “value”); > save. 

: creating variable using Pre-request Script…
// local/request variables
pm.variables.set(“key”, “value”); > save.
var name = "jawad1";
console.info("name is: "+name);

pm.variables.set("name", "jawad2");
console.log("Name: ", pm.variables.get("name"));


//collection variables
pm.collectionVariables.set(“key”, “value”); 


//global variables
pm.globals.set(“key”, “value”); > save.

//Environment variables
pm.environment.set(“key”, “value”); > select an Environment > save.


: data level variables- comes from external files.

*** remove variable after execution ***

local variable will be removed automatically after run.
pm.Variables.unset(“key”);
pm.globals.unset(“key”);
pm.environment.unset(“key”) // select an Environment > save.
pm.collectionVariables.unset(“key”);

*** how to print the variable values in console ?

console.log(pm.variables.get(“key”));
console.log(pm.collectionVariables. get (“key”));
console.log(pm.globals. get (“key”));
console.log(pm.environment. get (“key”));	
	
	pm.test("verify data type", function () {
    pm.expect(pm.response.json()).to.be.an('object');
    pm.expect(pm.response.json().page).to.be.a('number');
    pm.expect(pm.response.json().per_page).to.be.a('number');
    pm.expect(pm.response.json().total).to.be.a('number');
    pm.expect(pm.response.json().total_pages).to.be.a('number');
    
    pm.response.json().data.forEach((user) => {
        pm.expect(user.id).to.be.a('number');
        pm.expect(user.email).to.be.a('string');
        pm.expect(user.first_name).to.be.a('string');
        pm.expect(user.last_name).to.be.a('string');
        pm.expect(user.avatar).to.be.a('string');
    });
    pm.expect(pm.response.json().support).to.be.an('object');
    pm.expect(pm.response.json().support.url).to.be.a('string');
    pm.expect(pm.response.json().support.text).to.be.a('string');
});

const jsonData = pm.response.json();
pm.test("status code is 200", function () {
    pm.expect(pm.response.code).to.equal(200);
});
pm.test("response status is OK", function () {
    pm.expect(pm.response.status).to.equal("OK");
});
pm.test("Response time should be less than 500ms", function () {
    pm.expect(pm.response.responseTime).to.be.below(500);
});
pm.test("response has cookies", function () {
    pm.expect(pm.response.cookies).to.exist;
});
pm.test("response has header", function () {
     pm.response.to.have.header('Content-Type');
});
pm.test("content type is application/json", function () {
    pm.expect(pm.response.headers.get("Content-Type")).to.include("application/json");
});
pm.test("page : 1", function () {
    pm.expect(jsonData.page).to.equal(1);
});
pm.test("first employee's first name is George", function () {
     pm.expect(jsonData.data[0].first_name).to.equal('George');
});
pm.test("total employee 6", function () {
    pm.expect(jsonData.data.length).eql(6);
});
pm.test("url is https://reqres.in/#support-heading", function () {
    pm.expect(jsonData.support.url).to.equal("https://reqres.in/#support-heading");
});	
		
	*/

}
