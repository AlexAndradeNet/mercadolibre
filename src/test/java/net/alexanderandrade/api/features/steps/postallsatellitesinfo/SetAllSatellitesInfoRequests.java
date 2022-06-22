package net.alexanderandrade.api.features.steps.postallsatellitesinfo;

import com.google.gson.Gson;
import io.cucumber.datatable.DataTable;
import net.alexanderandrade.api.features.utils.RequestUtils;
import net.alexanderandrade.api.features.utils.SatelliteUtil;
import net.alexanderandrade.api.model.SatelliteRequestWithNameModel;
import net.thucydides.core.annotations.Steps;

public class SetAllSatellitesInfoRequests {

  @Steps private static RequestUtils requestUtils;

  private static final String SERVICE_PATH = "post.setallsatellitespossitionandmessage.url";

  public void send( DataTable data) {
    final int rowNumber = data.height();

    final SatelliteRequestWithNameModel[] satelliteRequestWithNameModel = new SatelliteRequestWithNameModel[rowNumber];

    for (int i=0; i < rowNumber; i++) {
      satelliteRequestWithNameModel[i] = SatelliteUtil.getWithName( data.row( i ) );
    }

    requestUtils.servicePost(
      SERVICE_PATH,
      "{\"satellites\":" + new Gson().toJson(satelliteRequestWithNameModel) + "}"
    );
  }

  public void sendEmptyRequest() {
    requestUtils.servicePost(SERVICE_PATH, "{}");
  }

}
