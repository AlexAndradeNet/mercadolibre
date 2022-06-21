package net.alexanderandrade.api.features.steps.postallsatellitesinfo;

import com.google.gson.Gson;
import io.cucumber.datatable.DataTable;
import net.alexanderandrade.api.features.utils.RequestUtils;
import net.alexanderandrade.api.model.SatelliteRequestWithNameModel;
import net.thucydides.core.annotations.Steps;
import org.apache.commons.lang3.StringUtils;

public class SetAllSatellitesInfoRequests {

  @Steps private static RequestUtils requestUtils;

  private static final String SERVICE_PATH = "post.setallsatellitespossitionandmessage.url";

  public void send( DataTable data) {
    SatelliteRequestWithNameModel[] satelliteRequestWithNameModel = new SatelliteRequestWithNameModel[3];

    for (int i=0; i < 3; i++) {
      satelliteRequestWithNameModel[i] = new SatelliteRequestWithNameModel();
      satelliteRequestWithNameModel[i].setMessage( new String[5] );

      satelliteRequestWithNameModel[i].setName( data.row(i+1).get(0) );
      satelliteRequestWithNameModel[i].setDistance( Float.valueOf( data.row(i+1).get(1) ) );

      int numberOfItems = 5;
      String[] message = new String[numberOfItems];
      for ( int j = 0; j < numberOfItems; j++ ) {
        String messageToSet = data.row(i+1).get( j + 2 );
        message[j] = ( StringUtils.isNotEmpty( messageToSet ) ) ? messageToSet : "";
      }
      satelliteRequestWithNameModel[i].setMessage( message );
    }

    String request = new Gson().toJson(satelliteRequestWithNameModel);
    request = "{\"satellites\":" + request + "}";

    requestUtils.servicePost(
      SERVICE_PATH,
      request
    );
  }

  public void sendEmptyRequest() {
    requestUtils.servicePost(SERVICE_PATH, "{}");
  }

}
