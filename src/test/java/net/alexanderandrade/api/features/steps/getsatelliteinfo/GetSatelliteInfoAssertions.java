package net.alexanderandrade.api.features.steps.getsatelliteinfo;

import io.cucumber.datatable.DataTable;
import net.alexanderandrade.api.features.utils.AssertionsUtil;
import net.thucydides.core.annotations.Steps;

import java.util.List;

public class GetSatelliteInfoAssertions {

  @Steps private static AssertionsUtil assertionsUtil;

  private static final String SERVICE_RESPONSE_FOLDER = "/";

  public void verifySuccessFullResponse( DataTable data ) {
    assertionsUtil.verifyFullSuccessResponseAndSchema(
        SERVICE_RESPONSE_FOLDER + "get_satellite_position_and_message.json");

    List<String> dataList = data.asList();
    assertionsUtil.verifyInfoStringResponse("message", dataList.get(2) );
  }

  public void verifyResourceNotFound () {
    assertionsUtil.verifyFullNotFoundResourceResponse( null);
  }
}
