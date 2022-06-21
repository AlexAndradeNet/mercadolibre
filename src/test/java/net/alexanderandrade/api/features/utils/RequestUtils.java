package net.alexanderandrade.api.features.utils;

import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestUtils {
  private static final Logger LOGGER = LoggerFactory.getLogger(RequestUtils.class.getName());

  @Steps AssertionsUtil assertionsUtil;

  @Step("Consultando el servicio POST")
  public ValidatableResponse servicePost(String servicePathVariable, String endpoint, String data) {
    String servicePath = getUrlService(servicePathVariable) + endpoint;

    LOGGER.info("Request post data: " + data);

    return SerenityRest.rest()
        .given()
        .spec(ReusableSpecifications.getGenericRequestSpec())
        .when()
        .body(data)
        .post(servicePath)
        .then();
  }

  @Step("Consultando el servicio POST")
  public ValidatableResponse servicePost(String servicePathVariable, String data) {
    return servicePost( servicePathVariable, "", data);
  }

  @Step("Consultando el servicio GET")
  public ValidatableResponse serviceGet(String servicePathVariable, String parameters) {
    String servicePath = getUrlService(servicePathVariable) + parameters;

    LOGGER.info("Request get url: " + servicePath);

    return SerenityRest.rest()
        .given()
        .spec(ReusableSpecifications.getGenericRequestSpec())
        .when()
        .get(servicePath)
        .then();
  }

  private String getUrlService(String servicePathVariable) {
    return EnvironmentProperties.getProperty(servicePathVariable);
  }
}
