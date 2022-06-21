/*
 AlexanderAndrade.Net CONFIDENTIAL

 <p>Copyright (c) 2018 . All Rights Reserved.

 <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 part of this source code package.
*/
package net.alexanderandrade.api.features.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.AfterClass;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features = {"classpath:features"},
    //tags = "@only",
    tags = "not @ignore",
    glue = {
      "net.alexanderandrade.api.features.steps",
      "net.alexanderandrade.api.features.utils"
    })
class RunnerTest {
  private RunnerTest () {
    super();
  }

  @Test
  void test() throws Exception {
    assertTrue(true);
  }

  @AfterClass
  public static void afterAll() {

  }
}
