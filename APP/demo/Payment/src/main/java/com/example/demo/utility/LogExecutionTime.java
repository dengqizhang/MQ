package com.example.demo.utility;

import java.lang.annotation.*;

@Target(ElementType.METHOD)  //该注解可以应用到方法上
@Retention(RetentionPolicy.RUNTIME)  //该注解运行时可见
public @interface LogExecutionTime {

}
