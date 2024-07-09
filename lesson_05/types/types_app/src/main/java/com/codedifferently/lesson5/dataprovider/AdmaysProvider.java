package com.codedifferently.lesson5.dataprovider;

import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class AdmaysProvider extends DataProvider {
  public String getProviderName() {
    return "admays";
  }

  public Map<String, Class> getColumnTypeByName() {
    return Map.of(
        "column1", Double.class,
        "column2", String.class,
        "column3", Boolean.class,
        "column4", Short.class,
        "column5", Float.class,
        "column6", Long.class,
        "column7", Integer.class);
  }
}
