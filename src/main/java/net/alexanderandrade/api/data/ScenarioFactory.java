/*
 AlexanderAndrade.Net CONFIDENTIAL
 <p>Copyright (c) 2018 . All Rights Reserved.
 <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 part of this source code package.
*/
package net.alexanderandrade.api.data;

import net.alexanderandrade.api.exceptions.UserNotFoundException;
import net.alexanderandrade.api.utils.FileUtil;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Optional;

public class ScenarioFactory {

  public JsonObject getData(String userRole) throws UserNotFoundException, IOException {

    String data;

    HashMap<String, String> userScenario = new HashMap<>();

    userScenario.put(
        "obtener la información de un satélite en particular", ""); // GET method, it isn't have a Body

    userScenario.put(
        "setear la información de un satélite en particular",
        getRequest("set_satellite_distance_and_message.json"));

    userScenario.put(
      "setear la información de varios satélites",
      getRequest("set_all_satellites_positions_and_messages.json"));

    data = userScenario.get(userRole);
    Optional<String> dataOptional = Optional.ofNullable(data);

    String dataVerified =
        dataOptional.orElseThrow(
            () -> new UserNotFoundException("Type of user does not exist in the system"));

    return new Gson().fromJson(dataVerified, JsonObject.class);
  }

  private String getRequest(String requestFilePath) throws IOException {
    return FileUtil.readPlainText("./src/test/resources/schemas/requests/" + requestFilePath);
  }
}
