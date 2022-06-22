package net.alexanderandrade.api.features.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.alexanderandrade.api.model.SatelliteRequestModel;
import net.alexanderandrade.api.model.SatelliteRequestWithNameModel;

import java.util.List;

public class SatelliteUtil {
	public static SatelliteRequestWithNameModel getWithName ( List<String> dataList) {
		int firstListItem = 2;
		final SatelliteRequestWithNameModel satelliteRequestWithNameModel = new SatelliteRequestWithNameModel();

		satelliteRequestWithNameModel.setName( dataList.get(0) );
		satelliteRequestWithNameModel.setDistance( Float.valueOf( dataList.get(1) ) );

		String[] message = dataList.subList( firstListItem, dataList.size() )
			.toArray(new String[0]);
		for (int i=0; i < message.length; i++) {
			if ( message[i] == null ) {
				message[i] = "";
			}
		}
		satelliteRequestWithNameModel.setMessage( message );
		return satelliteRequestWithNameModel;
	}

	public static SatelliteRequestModel get( List<String> dataList) {
		return new ObjectMapper().convertValue( SatelliteUtil.getWithName(dataList), SatelliteRequestModel.class);
	}

}
