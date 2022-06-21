package net.alexanderandrade.api.data;

import java.util.HashMap;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TestDataService {
  HashMap<String, String> testData = new HashMap<>();

  private static TestDataService instance;

  public static TestDataService getInstance() {
    if (instance == null) {
      instance = new TestDataService();
    }
    return instance;
  }

  public String getDataForKey(String key) {
    return instance.testData.get(key);
  }

  public boolean containsKey(Object key) {
    return instance.testData.containsKey(key);
  }

  public void setDataForKey(String key, String value) {
    instance.testData.put(key, value);
  }
}
