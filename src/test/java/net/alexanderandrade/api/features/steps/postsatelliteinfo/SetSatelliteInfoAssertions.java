package net.alexanderandrade.api.features.steps.postsatelliteinfo;

import com.google.gson.Gson;
import net.alexanderandrade.api.features.utils.AssertionsUtil;
import net.thucydides.core.annotations.Steps;

public class SetSatelliteInfoAssertions {

  @Steps private static AssertionsUtil assertionsUtil;

  private static final String SERVICE_RESPONSE_FOLDER = "/";

  public void verifySuccessFullResponse(String message) {
    assertionsUtil.verifyFullSuccessResponseAndSchema(
        SERVICE_RESPONSE_FOLDER + "post_set_satellite_distance_and_message.json");
    String[] response = {message};

    assertionsUtil.verifyInfoObjectResponse( new Gson().toJson(response) );
  }

  public void verifyResourceNotFound () {
    assertionsUtil.verifyFullNotFoundResourceResponse( null);
  }

  public void verifyBadRequestResponse () {
    assertionsUtil.verifyFullBadRequestResponse(null );
  }
}
