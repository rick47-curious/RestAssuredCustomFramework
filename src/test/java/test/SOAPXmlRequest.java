package test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.http.ContentType;
import utilities.ExcelUtil;
import utilities.XMLReaderUtil;

import static io.restassured.RestAssured.*;

public class SOAPXmlRequest {

	@DataProvider
	public Object[][] getTestData(){
		Object[][] data = ExcelUtil.getData();
		return data;
	}
	@Test(dataProvider="getTestData")
	public void validateSOAPXml(String dataA,String dataB,String result) {
		
		baseURI = "http://www.dneonline.com";
		//Get request payload
		String requestBody = XMLReaderUtil.replaceWithTestdata(XMLReaderUtil.getRequestBody("AddPayload"), dataA, dataB);
		System.out.println(requestBody);
		given()
			.contentType("text/xml")
			.accept(ContentType.XML)
			.body(requestBody)
		.when()
			.post("/calculator.asmx")
		.then()
			.statusCode(200)
			.log().all()
			.and().body("//*:AddResult.text()", equalTo(result));
		
	}
}
