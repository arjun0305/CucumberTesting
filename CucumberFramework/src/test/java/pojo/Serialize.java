package pojo;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;

public class Serialize {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AddPlace payload = new AddPlace();
		
		payload.setAccuracy(40);
		payload.setAddress("29, side layout, cohen 10");
		payload.setLanguage("English-EN");
		payload.setName("Raj");
		payload.setPhone_number("(+91) 983 893 3937");
		payload.setWebsite("http://google.com");
		
		List<String> myList =new ArrayList<String>();
		myList.add("Shoe Park");
		myList.add("Shop");
		payload.setTypes(myList);
		
		AddPlaceLocation al = new AddPlaceLocation();
		al.setLat(-38.383494);
		al.setLng(33.43284);
		payload.setLocation(al);
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		String Resp = given().log().all().queryParam("key", "qaclick123")
		.body(payload)
		.when().post("maps/api/place/add/json")
		.then().assertThat().statusCode(200).extract().response().asString();
		
		System.out.println(Resp);

	}

}
