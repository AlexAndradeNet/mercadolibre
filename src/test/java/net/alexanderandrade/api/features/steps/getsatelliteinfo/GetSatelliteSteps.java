/**
 * AlexanderAndrade.Net CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package net.alexanderandrade.api.features.steps.getsatelliteinfo;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.thucydides.core.annotations.Steps;

public class GetSatelliteSteps {
  @Steps private static GetSatelliteRequests       requests;
  @Steps private static GetSatelliteInfoAssertions assertions;

  @Cuando("consulte el servicio información por satélite para {word}")
  public void sendValidRequest(String satellite) {
    requests.send(satellite);
  }

  @Entonces("obtiene una respuesta exitosa del servicio de información por satélite con los datos")
  public void verifySuccessFullResponse( DataTable data ) {
    assertions.verifySuccessFullResponse(data);
  }

  @Entonces("obtiene un error de satélite inexistente del servicio información por satélite")
  public void verifyResourceNotFound () {
    assertions.verifyResourceNotFound();
  }
}
