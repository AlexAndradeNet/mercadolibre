/**
 * AlexanderAndrade.Net CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package net.alexanderandrade.api.features.utils;

import com.google.gson.JsonObject;

public final class DataUserInstance {

  private static DataUserInstance instance;
  private JsonObject data;

  private DataUserInstance() {}

  public static DataUserInstance getInstance() {
    if (instance == null) {
      instance = new DataUserInstance();
    }
    return instance;
  }

  public JsonObject getData() {
    return data;
  }

  public void setData(JsonObject data) {
    this.data = data;
  }
}
