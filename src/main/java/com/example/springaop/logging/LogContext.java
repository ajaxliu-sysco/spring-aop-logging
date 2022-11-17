package com.example.springaop.logging;

public class LogContext {
  private static final ThreadLocal<ConsumerLogEntity> CONTEXT = new ThreadLocal<>();

  public ConsumerLogEntity get() {
    return CONTEXT.get() == null ? new ConsumerLogEntity() : CONTEXT.get();
  }

  public void set(ConsumerLogEntity entity) {
    CONTEXT.set(entity);
  }

  public void put(String key, Object value) {
    get().context.put(key, value);
  }

  public void cleanup() {
    CONTEXT.remove();
  }
}
