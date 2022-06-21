package net.alexanderandrade.api.features.steps.getsatelliteinfo;

import net.alexanderandrade.api.features.utils.RequestUtils;
import net.thucydides.core.annotations.Steps;

public class GetSatelliteRequests {

  @Steps private static RequestUtils requestUtils;

  public void send(String satellite) {
    requestUtils.serviceGet("get.satellitepossitionandmessage.url", satellite.toLowerCase());
  }
}
