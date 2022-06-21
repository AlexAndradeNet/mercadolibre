package net.alexanderandrade.api.model;

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
