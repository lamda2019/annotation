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

    @Test
    public void testLifeCyclePrototype(){
        //1、创建ioc容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
        System.out.println("容器创建完成...");

        applicationContext.getBean("car");//调用该bean
        System.out.println("多实例声明周期中容器不会调用销毁方法");
        //关闭容器
        applicationContext.close();
    }


    @Test
    public void testInitializingBeanDisposableBean(){
        //1、创建ioc容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
        System.out.println("容器创建完成...");

        //关闭容器
        applicationContext.close();
    }

    @Test
    public void testPostConstructPreDestroy(){
        //1、创建ioc容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
        System.out.println("容器创建完成...");
        //关闭容器
        applicationContext.close();
    }


    @Test
    public void testBeanPostProcessor(){
        //1、创建ioc容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
        System.out.println("容器创建完成...");
        //关闭容器
        applicationContext.close();
    }

}