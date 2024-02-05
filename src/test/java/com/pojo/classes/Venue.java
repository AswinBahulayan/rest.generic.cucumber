package com.pojo.classes;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"id",
	"lat",
	"lon",
	"category",
	"name",
	"promoted",
	"created_on",
	"geolocation_degrees"
	})
public class Venue{
	@JsonProperty("id")
	private Integer id;
	
	@JsonProperty("lat")
    private Double lat;
	
	@JsonProperty("lon")
    private Double lon;
	
	@JsonProperty("category")
    private String category;
	
	@JsonProperty("name")
    private String name;
	
	@JsonProperty("promoted")
	private Boolean promoted;
	
	@JsonProperty("created_on")
    private Integer createdOn;
	
	@JsonProperty("geolocation_degrees")
    private String geolocationDegrees;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getLat() {
		return lat;
	}
	public void setLat(Double lat) {
		this.lat = lat;
	}
	public Double getLon() {
		return lon;
	}
	public void setLon(Double lon) {
		this.lon = lon;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getPromoted() {
		return promoted;
	}
	public void setPromoted(Boolean promoted) {
		this.promoted = promoted;
	}
	public Integer getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Integer createdOn) {
		this.createdOn = createdOn;
	}
	public String getGeolocationDegrees() {
		return geolocationDegrees;
	}
	public void setGeolocationDegrees(String geolocationDegrees) {
		this.geolocationDegrees = geolocationDegrees;
	}
    
    
}
