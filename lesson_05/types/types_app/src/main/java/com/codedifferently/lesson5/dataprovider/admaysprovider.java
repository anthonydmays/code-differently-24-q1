package com.codedifferently.lesson5.dataprovider;

import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class admaysprovider extends DataProvider {
  public String getProviderName() {
    return "admays";
  }

  public Map<String, Class> getColumnTypeByName() {
    return Map.of(
        "column1", Short.class,
        "column2", Double.class,
        "column3", Float.class,
        "column4", Long.class,
        "column5", String.class,
        "column6", Integer.class,
        "column7", Boolean.class);
  }
}
