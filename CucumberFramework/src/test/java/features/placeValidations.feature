Feature: Validate Place API's 

@AddPlace
Scenario Outline: Verify if place is being succesffully added
	Given Add place Payload "<name>" "<language>" "<address>"
	When user calls "addPlaceAPI" with "POST" HTTP request
	Then API call should be success and place should be added successfully
	And "status" in response is "OK"
	And "scope" in response is "APP"
	And  verify place_id created maps to "<name>" using "getPlaceAPI"
	
	
Examples:
	|name   | language   | address|
	|Arjun  | UK English | WTC    |
#	|Raghav | US English | Kharadi|


@DeletePlace
Scenario: Verify if delete Place API is working
	Given DeletePlace payload
	When user calls "deletePlaceAPI" with "post" HTTP request
	Then API call should be success and place should be added successfully
	And "status" in response is "OK"