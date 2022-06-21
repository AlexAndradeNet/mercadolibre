/**
 * AlexanderAndrade.Net CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package net.alexanderandrade.api.features.steps;

import net.alexanderandrade.api.data.ScenarioFactory;
import net.alexanderandrade.api.exceptions.UserNotFoundException;
import net.alexanderandrade.api.features.utils.AssertionsUtil;
import net.alexanderandrade.api.features.utils.DataUserInstance;
import com.google.gson.JsonObject;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import java.io.IOException;
import java.util.Collection;
import java.util.Optional;

import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Steps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SharedSteps {

  private static final Logger LOGGER = LoggerFactory.getLogger(SharedSteps.class.getName());
  Optional<String> testCaseIDOptional = Optional.empty();
  @Steps private static AssertionsUtil assertionsUtil;

  @Before(order = 1)
  public void setTheStage(Scenario sc) {
    OnStage.setTheStage(new OnlineCast());
    Collection<String> tags = sc.getSourceTagNames();
    this.testCaseIDOptional = tags.stream().findFirst();
  }

  @Given("que Han Solo quiere (.*)$")
  public void userRole(String userRole) {
    ScenarioFactory scenarioFactory = new ScenarioFactory();
    JsonObject data = null;
    try {
      data = scenarioFactory.getData(userRole);
      DataUserInstance.getInstance().setData(data);
    } catch (UserNotFoundException | IOException e) {
      LOGGER.error(e.toString(), e);
    }
  }

  @After
  public void afterScenario(Scenario sc) {}
}
