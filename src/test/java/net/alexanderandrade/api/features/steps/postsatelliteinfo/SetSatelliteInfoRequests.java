package net.alexanderandrade.api.features.steps.postsatelliteinfo;

import com.google.gson.Gson;
import io.cucumber.datatable.DataTable;
import net.alexanderandrade.api.features.utils.RequestUtils;
import net.alexanderandrade.api.features.utils.SatelliteUtil;
import net.alexanderandrade.api.model.SatelliteRequestModel;
import net.thucydides.core.annotations.Steps;

import java.util.List;

public class SetSatelliteInfoRequests {

  @Steps private static RequestUtils requestUtils;

  private static final String SERVICE_PATH = "post.setsatellitedistanceandmessage.url";

  public void send( DataTable data) {
    final List<String> dataList = data.asList();
    final SatelliteRequestModel satelliteRequestModel = SatelliteUtil.get( dataList );

    requestUtils.servicePost(
      SERVICE_PATH,
      dataList.get(0).toLowerCase(),
      new Gson().toJson(satelliteRequestModel)
    );
  }

  public void sendEmptyRequest(String satellite) {
    requestUtils.servicePost(SERVICE_PATH, satellite,"{}");
  }

}
