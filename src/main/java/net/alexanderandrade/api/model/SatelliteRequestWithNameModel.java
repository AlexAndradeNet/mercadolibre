package net.alexanderandrade.api.model;

public class SatelliteRequestWithNameModel extends SatelliteRequestModel {
	String name;

	public SatelliteRequestWithNameModel () {
		this.name = "";
	}

	public String getName () {
		return name;
	}

	public void setName ( String name ) {
		this.name = name;
	}
}
