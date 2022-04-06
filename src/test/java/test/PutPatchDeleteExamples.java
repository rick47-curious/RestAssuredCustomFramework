package test;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PutPatchDeleteExamples {
	
@Test
public void test_PUT() {
	
	//Request body
	JSONObject request = new JSONObject();
	request.put("name", "John");
	request.put("job", "Doc");
	//System.out.println(request.toJSONString());
	baseURI = "https://reqres.in/api";
	given().
		contentType(ContentType.JSON).
		accept(ContentType.JSON)
		.body(request.toJSONString()).
	when().
		put("/users/2").
	then().
		statusCode(200)		
		.log().all();
				
	
}

@Test
public void test_PATCH() {
	
	//Request payload
	JSONObject request = new JSONObject();
	request.put("name", "morpheus");
	request.put("job", "zion resident");
	
	baseURI = "https://reqres.in";
	given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(request.toJSONString())	
	.when()
		.patch("/api/users/2")
	.then()
		.statusCode(200)
		.log().all();
}	

@Test
public void test_DELETE() {
	
	
	baseURI = "https://reqres.in";
		
	when()
		.delete("/api/users/2")
	.then()
		.statusCode(204) //No response content
		.log().all();
}	

}
