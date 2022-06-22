package net.alexanderandrade.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @Getter @Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class SatelliteRequestModel {
	private Float distance;
	private String[] message;
}
