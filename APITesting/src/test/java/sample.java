import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
//import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import static io.restassured.RestAssured.given;
//import static org.junit.Assert.*;

//import java.awt.List;

//import java.util.List;

//import io.restassured.specification.Argument;
import io.restassured.specification.RequestSpecification;


public class sample {
	//User login
	@Test
	public void authenticate() {
		RestAssured
			.given()
				.auth().basic("testuser@qa.com", "Parole123")
					.contentType(ContentType.JSON)
						.baseUri("https://swaper.com")
						.when()
						.get("/en/login")
						.then()
						.assertThat()
						.statusCode(200);
		
 		RestAssured.baseURI = "https://swaper.com";
	
		String requestBody = "";
 		Response response = given()
 				.contentType(ContentType.JSON)
 				.body(requestBody)
 				.when()				
 				.post("/en/investments/open-investments")
 				.then()
 				.extract()
 				.response();
 		RequestSpecification httprequest = given();
 		
 		Response response2 = httprequest.request(Method.POST, "/rest/public/profile/account-entries");
 		ResponseBody<?> body = response2.getBody();
 		System.out.println("Response2 Body is: " + body.asString());
 		if(body.asString().contains("0")) {
 			System.out.println("openingBalance is present on body");
 			} else {
 				System.out.println("openingBalance is not present on body");
 				}
 		

 		String jsonAsString = response.asString();
 		System.out.println(jsonAsString);

	}

}
