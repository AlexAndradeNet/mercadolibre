package net.alexanderandrade.api.features.steps.postallsatellitesinfo;

import net.alexanderandrade.api.features.utils.AssertionsUtil;
import net.thucydides.core.annotations.Steps;

public class SetAllSatellitesInfoAssertions {

  @Steps private static AssertionsUtil assertionsUtil;

  private static final String SERVICE_RESPONSE_FOLDER = "/";

  public void verifySuccessFullResponse(String message) {
    assertionsUtil.verifyFullSuccessResponseAndSchema(
        SERVICE_RESPONSE_FOLDER + "post_set_all_satellites_distances_and_messages.json");

    assertionsUtil.verifyInfoStringResponse( "message", message );
  }

  public void verifyResourceNotFound () {
    assertionsUtil.verifyFullNotFoundResourceResponse( null);
  }

  public void verifyBadRequestResponse () {
    assertionsUtil.verifyFullBadRequestResponse(null );
  }
}
