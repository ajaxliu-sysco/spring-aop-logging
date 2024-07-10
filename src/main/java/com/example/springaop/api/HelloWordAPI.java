package com.example.springaop.api;

import com.example.springaop.logging.LogContext;
import com.example.springaop.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springaop.logging.LogRequired;

import java.util.Random;

@RestController
@RequestMapping("/v1")
public class HelloWordAPI {
  @Autowired
  LogContext logContext;
  @Autowired
  DemoService demoService;

  @LogRequired
  @GetMapping("/hello")
  public ResponseEntity<String> getHello() {
    logContext.put("userId", "ajax-" + new Random().nextInt(9));
    demoService.demo();
    return ResponseEntity.ok("Welcome to AOP logging");
  }
}
