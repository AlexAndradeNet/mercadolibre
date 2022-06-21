/**
 * AlexanderAndrade.Net CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package net.alexanderandrade.api.features.utils;

import static org.hamcrest.Matchers.lessThan;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpHeaders;

public class ReusableSpecifications {

  private ReusableSpecifications() {}

  public static RequestSpecification getGenericRequestSpec() {
    RequestSpecBuilder rspec;
    RequestSpecification requestSpecification;

    rspec = new RequestSpecBuilder();
    rspec.setContentType(ContentType.JSON);
    requestSpecification = rspec.build();
    return requestSpecification;
  }

  public static ResponseSpecification getGenericResponseSpec() {
    ResponseSpecBuilder respec;
    ResponseSpecification responseSpecification;

    respec = new ResponseSpecBuilder();
    respec.expectHeader(HttpHeaders.CONTENT_TYPE, "application/json;charset=UTF-8");
    respec.expectHeader(HttpHeaders.TRANSFER_ENCODING, "chunked");
    respec.expectResponseTime(lessThan(10L), TimeUnit.SECONDS);
    responseSpecification = respec.build();
    return responseSpecification;
  }
}
