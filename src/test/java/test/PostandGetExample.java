package test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostandGetExample {


public void test_GET() {
		
		baseURI = "https://reqres.in";
		
	    given()
			.get("/api/users?page=2")
		.then().
			statusCode(200)	
		.body("data.first_name[0]", equalTo("Michael"))
		.body("data.first_name",hasItems("George","Rachel"));
		
		
	}
@Test
public void test_POST() {
	
	//JSON request payload
	JSONObject request = new JSONObject();
	request.put("name", "John");
	request.put("job", "Dev");
	
	
	baseURI = "https://reqres.in";
	
	given().
		contentType(ContentType.JSON). //send request content-type
		accept(ContentType.JSON) //validate content-type of response
		.body(request.toJSONString())
	.when()
		.post("/api/users")
	.then()
		.statusCode(201)
	.log().all();
	
	
	
}
}
