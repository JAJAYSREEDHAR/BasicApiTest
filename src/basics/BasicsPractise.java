package basics;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static org.hamcrest.Matchers.equalTo;

import static io.restassured.RestAssured.given;

public class BasicsPractise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RestAssured.baseURI = "https://api.openweathermap.org";

		// Response will be in Raw format
		Response response = given().auth().basic("ajuu0415@gmail.com", "Wizdom@1")
				.params("lat", "35", "lon", "40", "appid", "9a52e1d536053faca92bdd7c57f14135").log().all().when()
				.get("/data/2.5/weather").then().assertThat().statusCode(200).and().contentType(ContentType.XML)
				.extract().response();

		System.out.println(response.prettyPrint());
		
		System.out.println("Result object" + "\t" + response);

		/*
		 * 
		 * 
		 * System.out.println(response.prettyPrint());
		 * 
		 * // Convert response to String format String responseString =
		 * response.asString();
		 * 
		 * System.out.println("Result Stringified" + "\t" + responseString);
		 * 
		 * // Convert string response to JSON response using JSONPath
		 * 
		 * JsonPath jsonResponse = new JsonPath(responseString);
		 * System.out.println("Result Json" + "\t" +
		 * jsonResponse.prettyPrint()); Object object = jsonResponse.get("cod");
		 * 
		 * System.out.println(object.toString());
		 * 
		 * 
		 * .then().log().body().assertThat().statusCode(200).and()
		 * .contentType(ContentType.JSON).and().body("cod",
		 * equalTo(200)).and().header("Server", "openresty")
		 * 
		 * .log() .headers()
		 */
	}

}
