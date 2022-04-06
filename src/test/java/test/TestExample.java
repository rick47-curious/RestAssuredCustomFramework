package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.ObjectType;

//Static import
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import io.restassured.path.json.JsonPath;
//import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestExample {
	

public void test_1() {
	
	/*Rest assured class to trigger the requests
	get or any method is returning the response
	its stored in response variable here*/
	
	//Using static import we don't require the class Name to call methods
	Response response = get("https://reqres.in/api/users?page=2");
	
	//Without static import used as below
	//Response response = RestAssured.get("https://reqres.in/api/users?page=2");
	
	//Get the run specifications
	System.out.println("Response TIme:"+response.getStatusCode());
	
	System.out.println("Response Time:"+response.getTime());
	
	System.out.println("Response Body\n"+response.getBody().asString());
	
	System.out.println("Response StatusLine:"+response.getStatusLine());
	
	System.out.println("Response Content-Type:"+response.getHeader("content-type"));
	
	int statusCode = response.getStatusCode();
	//Test Assertions
	Assert.assertEquals(statusCode, 200);
}

public void test_2() {
	/*To check the status code and assert the response
	/Log the response with log() and all() to include everything in response
	 * including headers
	 */
	baseURI = "https://reqres.in";
	given().
		get("/api/users?page=2").
	then().
		statusCode(200).body("data.id[1]", equalTo(8))
				.log().all();
		
}
//@Test
//public void test_3() {
//	
//	Response response = get("https://reqres.in/api/users?page=2");
//	
//	JsonPath res = response.jsonPath();
//	
//	List <JsonPath> items = res.getList("data");
//	
//	Iterator <JsonPath> itr = items.iterator();
//	while (itr.hasNext()) {
//		List<Map<String,Object>> obj = itr.next().;
//		Iterator <Map<String,Object>> it = obj.iterator();
//		while (it.hasNext()) {
//			System.out.println(it.next().get("first_name"));;
//		}
//	}
//	
//}
}
