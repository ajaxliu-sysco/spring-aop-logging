package com.example.springaop.bean;

import com.example.springaop.logging.LogContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@Configuration
public class LogContextConfig {
  @Bean
  public LogContext logContext() {
    return new LogContext();
  }
}
