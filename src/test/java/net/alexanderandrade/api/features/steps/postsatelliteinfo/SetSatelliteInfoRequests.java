package net.alexanderandrade.api.features.steps.postsatelliteinfo;

import com.google.gson.Gson;
import io.cucumber.datatable.DataTable;
import net.alexanderandrade.api.features.utils.RequestUtils;
import net.alexanderandrade.api.model.SatelliteRequestModel;
import net.thucydides.core.annotations.Steps;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class SetSatelliteInfoRequests {

  @Steps private static RequestUtils requestUtils;

  private static final String SERVICE_PATH = "post.setsatellitedistanceandmessage.url";

  public void send( DataTable data) {
    List<String> dataList = data.asList();

    SatelliteRequestModel satelliteRequestModel = new SatelliteRequestModel();
    satelliteRequestModel.setDistance( Float.valueOf( dataList.get(1) ) );

    int numberOfItems = 5;
    String[] message = new String[numberOfItems];
    for (int i=0; i < numberOfItems; i++) {
      String messageToSet = dataList.get(i + 2);
      message[i] = ( StringUtils.isNotEmpty( messageToSet ) ) ? messageToSet : "";
    }
    satelliteRequestModel.setMessage( message );

    String request = new Gson().toJson(satelliteRequestModel);

    requestUtils.servicePost(
      SERVICE_PATH,
      dataList.get(0).toLowerCase(),
      request
    );
  }

  public void sendEmptyRequest(String satellite) {
    requestUtils.servicePost(SERVICE_PATH, satellite,"{}");
  }

}
