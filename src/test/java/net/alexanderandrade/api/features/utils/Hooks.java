package net.alexanderandrade.api.features.utils;

import io.cucumber.java.Before;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Hooks {
  @Before
  public void beforeScenario() {
    String environment = "";
    environment = getEnvironment();
    // TODO: manejo por entorno
  }

  private String getEnvironment() {
    return EnvironmentProperties.getProperty("environment.name");
  }
}
