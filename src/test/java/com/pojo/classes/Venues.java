package com.pojo.classes;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
@JsonPropertyOrder({"venues"})
public class Venues {
	
	@JsonProperty("venues")
	private List<Venue> venues;
	
	@JsonProperty("venues")
	public List<Venue> getVenues() {
		return venues;
	}
	
	@JsonProperty("venues")
	public void setVenues(List<Venue> venues) {
		this.venues = venues;
	}

}
