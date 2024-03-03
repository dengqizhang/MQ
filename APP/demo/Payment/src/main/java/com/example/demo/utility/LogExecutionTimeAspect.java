package com.example.demo.utility;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * 切面实现类
 */
@Aspect
@Component
@Slf4j
public class LogExecutionTimeAspect {
    @Around("@annotation(logExecutionTime)")
   public Object around(ProceedingJoinPoint point, LogExecutionTime logExecutionTime) throws Throwable {
       long begin = System.currentTimeMillis();
       Object proceed = point.proceed();
       long end = System.currentTimeMillis();
       log.info("方法耗时：" + (end - begin));
       return proceed;
   }

}
