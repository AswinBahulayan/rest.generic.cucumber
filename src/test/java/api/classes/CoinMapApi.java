package api.classes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cucumber.testng.BaseClass;
import com.pojo.classes.Venue;
import com.pojo.classes.Venues;

import io.cucumber.java.Scenario;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class CoinMapApi extends BaseClass{
	
	private Response response=null;
	
	public void prerequisites() {
		RestAssured.baseURI="https://coinmap.org/api/v1/venues/";
		RestAssured.requestSpecification=RestAssured.given().contentType("application/json");
	}
	
	public void getCoinMap(Scenario scenario) {
		response=RestAssured.given().when().get();
		response.then().statusCode(200);
		System.out.println(response.asPrettyString());
		scenario.attach(response.asPrettyString(), "text/json", "response");
	}
	
	private List<Venue> venue=null;
	public void deserializeClass() {
		ResponseBody body = response.getBody();
		Venues venues = body.as(Venues.class);
		venue = venues.getVenues();
		Map<String,Integer> category=new HashMap<>();
		for(Venue e:venue) {
			category.put(e.getCategory(), category.getOrDefault(e.getCategory(), 0)+1);
		}
		//print the category and count
		for(Map.Entry<String, Integer> e:category.entrySet()) {
			logger(e.getKey()+" : "+e.getValue());
		}
	}
	
	//get name and location of food category
	public void getFoodCategoryAndLocation() {
		for(Venue e:venue) {
			if(e.getCategory().equals("food")) {
				logger("Name of place: "+e.getName()+" ------location of the place : "+e.getGeolocationDegrees());
			}
		}
	} 
	

}
