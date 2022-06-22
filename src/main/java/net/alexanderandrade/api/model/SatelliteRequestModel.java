package net.alexanderandrade.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SatelliteRequestModel {
	Float distance;
	String[] message;

	public Float getDistance () {
		return distance;
	}

	public void setDistance ( Float distance ) {
		this.distance = distance;
	}

	public String[] getMessage () {
		return message;
	}

	public void setMessage ( String[] message ) {
		this.message = message;
	}
}
