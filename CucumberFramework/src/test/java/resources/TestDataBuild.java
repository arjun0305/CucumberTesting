package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.AddPlaceLocation;

public class TestDataBuild {
	
	public AddPlace AddPlacePayload(String name, String language, String address)
	{
		AddPlace payload = new AddPlace();
		payload.setAccuracy(40);
		payload.setAddress(address);
		payload.setLanguage(language);
		payload.setName(name);
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
		return payload;
	}
	
	public String deletePayload(String place_id) {
		return "{\r\n"
				+ "    \"place_id\":\""+place_id+"\"\r\n"
				+ "}";
	}

}
