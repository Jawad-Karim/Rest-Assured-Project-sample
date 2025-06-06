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
                    .pathParam("id", 123)  
              .when()  
                    .get("/api/resource/{id}")   
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
        
