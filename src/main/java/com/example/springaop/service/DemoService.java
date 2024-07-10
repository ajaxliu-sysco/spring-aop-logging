package com.example.springaop.service;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/* *
 * Author Ajax
 */
@Component
public class DemoService {
  public void demo () {
    ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    attrs.getRequest().getHeader("Accept-Language");
  }


}
