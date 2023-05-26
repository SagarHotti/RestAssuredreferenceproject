package restAssuredreference;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

public class deleteReference {

	public static void main(String[] args) {
		
	// Step 1 :Declare BaseURL	
	RestAssured.baseURI="https://reqres.in/";
	
	//Configure Request Body
	
	int statuscode = given().header("content-Type","application/java").log().all().when().delete("/api/users/2").then().extract().statusCode();
	String responsebody = given().header("content-Type", "application/json").log().all().when().delete("/api/users/2").then().log().all().extract().response().asString();
	
	System.out.println(statuscode);
	System.out.println(responsebody);
   
	}

}
