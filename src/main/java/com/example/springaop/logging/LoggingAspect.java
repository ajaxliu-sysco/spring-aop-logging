package com.example.springaop.logging;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.UUID;

@Aspect
@Component
public class LoggingAspect {
  public static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
  @Autowired
  public LogContext logContext;

  /**
   * This method uses Around advice which ensures that an advice can run before
   * and after the method execution, to and log the execution time of the method
   * This advice will be be applied to all the method which are annotate with the
   * annotation @LogExecutionTime @see com.example.springaop.logging.LogExecutionTime
   * <p>
   * Any mehtod where execution times need to be measue and log, anotate the method with @LogExecutionTime
   * example
   *
   * @param proceedingJoinPoint
   * @return
   * @throws Throwable
   * @LogExecutionTime public void m1();
   */
  @Around("@annotation(com.example.springaop.logging.LogRequired)")
  public Object methodTimeLogger(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    initLogEntity();
    Object result = null;
    try {
      result = proceedingJoinPoint.proceed();
      logContext.get().setElapsed(System.currentTimeMillis());
    } finally {
      if (logContext.get().errorCode != null) {
        logger.warn(JSON.toJSONString(logContext.get()));
      } else {
        logger.info(JSON.toJSONString(logContext.get()));
      }
    }
    logContext.cleanup();
    return result;
  }

  private void initLogEntity() {
    ConsumerLogEntity entity = logContext.get();
    entity.logId = UUID.randomUUID().toString();
    entity.topic = "Test-Topic";
    entity.startDate = System.currentTimeMillis();
    logContext.set(entity);
  }
}