package com.wsc;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wsc.config.MainConfigOfLifeCycle;

public class IOCTest_LifeCycle {

    @Test
    public void testLifeCycleSingleton(){
        //1、创建ioc容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
        System.out.println("容器创建完成...");

        //关闭容器
        applicationContext.close();
    }

}