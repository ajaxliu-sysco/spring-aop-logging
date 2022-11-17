package com.example.springaop.bean;

import com.example.springaop.logging.LogContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogContextConfig {
  @Bean
  public LogContext logContext() {
    return new LogContext();
  }
}
