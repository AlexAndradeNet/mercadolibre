/**
 * AlexanderAndrade.Net CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package net.alexanderandrade.api.features.steps.postallsatellitesinfo;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.thucydides.core.annotations.Steps;

public class SetAllSatellitesInfoSteps {
  @Steps private static SetAllSatellitesInfoRequests   requests;
  @Steps private static SetAllSatellitesInfoAssertions assertions;

  @Cuando("solicita cambiar información en varios satélites con los datos")
  public void sendRequest( DataTable data) {
    requests.send(data);
  }

  @Entonces("obtiene una respuesta exitosa de todos los satelites que dice {string}")
  public void verifySuccessFullResponse(String message) {
    assertions.verifySuccessFullResponse(message);
  }

  @Entonces("obtiene un error de satélites inexistentes del servicio seteo de información para varios satélites")
  public void verifyWrongResponse() {
    assertions.verifyResourceNotFound();
  }

  @Cuando("solicite guardar información vacía para varios satélites")
  public void sendEmptyRequest() {
    requests.sendEmptyRequest();
  }

  @Entonces("obtiene un error de satélite consulta mal formada del servicio seteo de información para varios satélites")
  public void verifyBadRequestResponse() {
    assertions.verifyBadRequestResponse();
  }
}
