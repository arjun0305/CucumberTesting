package stepDefinitions;

import io.cucumber.java.Before;

public class Hooks {
	
	StepDefinitions m =new StepDefinitions();
	
	@Before("@DeletePlace")
	public void beforeScenario() throws Exception {
		
		if(StepDefinitions.place_id==null)
		{
			m.add_place_Payload("Arjun", "French" ,"India");
			m.user_calls_with_HTTP_request("addPlaceAPI", "Post");
			m.verify_place_id_created_maps_to_using_getPlaceAPI("Arjun","getPlaceAPI");
		}
	}

}
