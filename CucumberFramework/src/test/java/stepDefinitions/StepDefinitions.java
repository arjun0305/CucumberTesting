package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

import java.io.IOException;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

public class StepDefinitions extends Utils{

	RequestSpecification Res;
	ResponseSpecification resp;
	Response Response;
	TestDataBuild data =new TestDataBuild();
	static String place_id;
	
	@Given("Add place Payload {string} {string} {string}")
	public void add_place_Payload(String name, String language, String address) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		
		resp = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		Res = given().spec(requestSpecification())
		.body(data.AddPlacePayload(name, language, address));
		
	}
	
	@When("user calls {string} with {string} HTTP request")
	public void user_calls_with_HTTP_request(String resource, String method) {
	    // Write code here that turns the phrase above into concrete actions
		APIResources resourceAPI = APIResources.valueOf(resource);
		System.out.println(resourceAPI.getResource());
		
		if (method.equalsIgnoreCase("POST"))
			Response = Res.when().post(resourceAPI.getResource());
		else if(method.equalsIgnoreCase("GET"))
			Response = Res.when().get(resourceAPI.getResource());
		
	}

	@Then("API call should be success and place should be added successfully")
	public void api_call_should_be_success_and_place_should_be_added_successfully() {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(Response.getStatusCode(), 200);
	}

	@Then("{string} in response is {string}")
	public void in_response_body_is(String key, String value) {
	    // Write code here that turns the phrase above into concrete action
		
	    assertEquals(getJsonPath(Response, key).toString(),value);	    
	}
	
	@Then("verify place_id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using_getPlaceAPI(String string, String resource) {
	    // Write code here that turns the phrase above into concrete actions
		place_id = getJsonPath(Response, "place_id");
		System.out.println(place_id);
		Res = given().spec(req).queryParam("place_id", place_id);
		user_calls_with_HTTP_request(resource,"GET");
		
		System.out.println(string);
		assertEquals(getJsonPath(Response, "name"), string);
	}
	
	@Given("DeletePlace payload")
	public void deleteplace_payload() {
	    // Write code here that turns the phrase above into concrete actions
	    Res = given().spec(req).body(data.deletePayload(place_id));
	    System.out.println("run success");
	}
	
}
