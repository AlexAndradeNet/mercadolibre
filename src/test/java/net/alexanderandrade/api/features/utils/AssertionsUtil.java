/*
 AlexanderAndrade.Net CONFIDENTIAL

 <p>Copyright (c) 2018 . All Rights Reserved.

 <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 part of this source code package.
*/
package net.alexanderandrade.api.features.utils;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;

import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.apache.http.HttpStatus;
import ro.skyah.comparator.JSONCompare;

public class AssertionsUtil {

  @Step("Verificación del código de respuesta 200")
  public void shouldSeeSuccessFullStatusCode() {
    assertThat(SerenityRest.then().extract().statusCode(), equalTo(HttpStatus.SC_OK));
  }

  @Step("Verificación del código de respuesta 204")
  public void shouldSeeNotContentStatusCode() {
    assertThat(SerenityRest.then().extract().statusCode(), equalTo(HttpStatus.SC_NO_CONTENT));
  }

  @Step("Verificación del código de respuesta 206")
  public void shouldSeePartialStatusCode() {
    assertThat(SerenityRest.then().extract().statusCode(), equalTo(HttpStatus.SC_PARTIAL_CONTENT));
  }

  @Step("Verificación del código de respuesta 404")
  public void shouldSeeNotFoundStatusCode() {
    assertThat(SerenityRest.then().extract().statusCode(), equalTo(HttpStatus.SC_NOT_FOUND));
  }

  @Step("Verificación del código de respuesta 406")
  public void shouldSeeNotAcceptableStatusCode() {
    assertThat(SerenityRest.then().extract().statusCode(), equalTo(HttpStatus.SC_NOT_ACCEPTABLE));
  }

  @Step("Verificación del código de respuesta 500")
  public void shouldSeeServerErrorStatusCode() {
    assertThat(
        SerenityRest.then().extract().statusCode(), equalTo(HttpStatus.SC_INTERNAL_SERVER_ERROR));
  }

  @Step("Verificación de conexión no autorizada 401")
  public void shouldSeeUnauthorizedStatusCode() {
    assertThat(SerenityRest.then().extract().statusCode(), equalTo(HttpStatus.SC_UNAUTHORIZED));
  }

  @Step("Verificación del código de respuesta 400")
  public void shouldSeeBadRequestCode() {
    assertThat(SerenityRest.then().extract().statusCode(), equalTo(HttpStatus.SC_BAD_REQUEST));
  }

  @Step("Verificación del código de respuesta 403")
  public void shouldSeeForbidden() {
    assertThat(SerenityRest.then().extract().statusCode(), equalTo(HttpStatus.SC_FORBIDDEN));
  }

  @Step("Verificación del código de respuesta 500")
  public void shouldSeeInternalErrorStatusCode() {
    assertThat(
        SerenityRest.then().extract().statusCode(), equalTo(HttpStatus.SC_INTERNAL_SERVER_ERROR));
  }

  @Step("Validación Schema JSON")
  public void validateJSONSchema(String pathToSchema) {
    if (pathToSchema == null) {
      assertEquals("", SerenityRest.then().extract().body().asString() );
    } else {
      JsonSchemaValidator validator = JsonSchemaValidator.matchesJsonSchemaInClasspath( "schemas/responses" + pathToSchema );
      SerenityRest.then().assertThat().body( validator );
    }
  }

  @Step("Verificar respuesta exitosa y Schema")
  public void verifyFullSuccessResponseAndSchema (String schemaToVerify) {
    validateJSONSchema(schemaToVerify);
    shouldSeeSuccessFullStatusCode();
  }

  @Step("Verificar respuesta Bad Request y Schema")
  public void verifyFullBadRequestResponse(String schemaToVerify) {
    validateJSONSchema(schemaToVerify);
    shouldSeeBadRequestCode();
  }

  @Step("Verificar respuesta flujo existente y Schema")
  public void verifyFullServiceErrorResponse(String schemaToVerify) {
    validateJSONSchema(schemaToVerify);
    shouldSeeServerErrorStatusCode();
  }

  @Step("Verificar respuesta No autorizado y Schema")
  public void verifyFullUnauthorizedResponse(String strSchema) {
    validateJSONSchema(strSchema);
    shouldSeeUnauthorizedStatusCode();
  }

  @Step("Verificar respuesta No permitido y Schema")
  public void verifyFullForbiddenResponse(String strSchema) {
    validateJSONSchema(strSchema);
    shouldSeeForbidden();
  }

  @Step("Verificar respuesta incompleta o no encontrada y Schema")
  public void verifyFullPartialResponse(String strSchema) {
    validateJSONSchema(strSchema);
    shouldSeePartialStatusCode();
  }

  @Step("Verificar respuesta recurso no encontrado y Schema")
  public void verifyFullNotFoundResourceResponse(String strSchema) {
    validateJSONSchema(strSchema);
    shouldSeeNotFoundStatusCode();
  }

  @Step("Verificar respuesta no aceptable y Schema")
  public void verifyFullNotAceptableResponse(String strSchema) {
    validateJSONSchema(strSchema);
    shouldSeeNotAcceptableStatusCode();
  }

  @Step("Verificar información de la respuesta")
  public void verifyInfoStringResponse(String jsonProperty, String value) {
    assertThat(SerenityRest.then().extract().body().jsonPath().getString(jsonProperty),
      is(value));
  }

  @Step("Verificar información de la respuesta")
  public void verifyInfoFloatResponse(String jsonProperty, String value) {
    assertThat(SerenityRest.then().extract().body().jsonPath().getFloat(jsonProperty),
      is( Float.valueOf(value) ) );
  }

  @Step("Verificar información de la respuesta")
  public void verifyInfoObjectResponse(String value) {
    JSONCompare.assertEquals(
      SerenityRest.then().extract().body().asString(),
      value
    );
  }

}
