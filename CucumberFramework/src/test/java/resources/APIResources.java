package resources;

//enum is special class in java which has collection of constants or method

public enum APIResources {
	
	addPlaceAPI("maps/api/place/add/json"),
	deletePlaceAPI("maps/api/place/delete/json"),
	getPlaceAPI("maps/api/place/get/json");
	private String resource;
	
	APIResources(String resource) {
		// TODO Auto-generated constructor stub
		this.resource=resource;
	}
	
	public String getResource() {
		return resource;
	}

}
