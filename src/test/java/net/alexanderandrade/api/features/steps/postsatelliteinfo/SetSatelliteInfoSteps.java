/**
 * AlexanderAndrade.Net CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package net.alexanderandrade.api.features.steps.postsatelliteinfo;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.thucydides.core.annotations.Steps;

public class SetSatelliteInfoSteps {
  @Steps private static SetSatelliteInfoRequests   requests;
  @Steps private static SetSatelliteInfoAssertions assertions;

  @Cuando("solicite guardar información del satélite con los datos")
  public void sendRequest( DataTable data) {
    requests.send(data);
  }

  @Entonces("obtiene una respuesta exitosa del servicio que dice {string}")
  public void verifySuccessFullResponse(String message) {
    assertions.verifySuccessFullResponse(message);
  }

  @Entonces("obtiene un error de satélite inexistente del servicio seteo de información por satélite")
  public void verifyWrongResponse() {
    assertions.verifyResourceNotFound();
  }

  @Cuando("solicite guardar información vacía del satélite {word}")
  public void sendEmptyRequest(String satellite) {
    requests.sendEmptyRequest(satellite);
  }

  @Entonces("obtiene un error de satélite consulta mal formada del servicio seteo de información por satélite")
  public void verifyBadRequestResponse() {
    assertions.verifyBadRequestResponse();
  }
}
