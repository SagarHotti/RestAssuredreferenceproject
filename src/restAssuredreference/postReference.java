package restAssuredreference;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import static io.restassured.RestAssured.given;

import java.time.LocalDate;
public class postReference {

	public static void main(String[] args) {
	
		//Step 1 : Declare Base Url
		
	RestAssured.baseURI="https://reqres.in";
	
	int statusCode=given().header("Content-Type","application/json").body("{\r\n"
			+ "    \"name\": \"morpheus\",\r\n"
			+ "    \"job\": \"leader\"\r\n"
			+ "}").when().post("/api/users").then().extract().statusCode();
	
	// step 2 : configure request body
	String responseBody=given().header("Content-Type","application/json").body("{\r\n"
			+ "    \"name\": \"morpheus\",\r\n"
			+ "    \"job\": \"leader\"\r\n"
			+ "}\r\n"
			+ "").when().post("api/users").then().extract().response().asString();
		System.out.println(responseBody);
		System.out.println(statusCode);
		
		// step 3 parse the response body
	JsonPath jsp = new JsonPath(responseBody);
	
	String res_name = jsp.get("name");
	String res_job = jsp.get("job");
	String res_id = jsp.get("id");
	String res_createdAt = jsp.get("createdAt");
	   
	 // step 4 : validate responsebody parameters
	Assert.assertEquals(res_name, "morpheus");
	Assert.assertEquals(res_job, "leader");
	Assert.assertNotNull(res_id);
	
	 
    //extract data from createdAt parameter
    String actual_date = res_createdAt.substring(0,10);
    String current_date = LocalDate.now().toString(); 
    Assert.assertEquals(actual_date,current_date);
	}
}
