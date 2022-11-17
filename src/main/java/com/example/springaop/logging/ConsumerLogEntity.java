package com.example.springaop.logging;

import java.util.HashMap;
import java.util.Map;


public class ConsumerLogEntity {
  public String logId;
  public String topic;
  public int partition;
  public String messageKey;
  public String offset;
  public String data;
  public String errorCode;
  public final Map<String, Object> context = new HashMap<>();
  public long startDate;
  public long endDate;
  public long elapsed;

  public void setElapsed(long endDate) {
    this.endDate = endDate;
    elapsed = this.endDate - startDate;
  }
}
