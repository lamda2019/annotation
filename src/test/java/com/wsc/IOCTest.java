package com.wsc;


import com.wsc.config.MainConfigIOC;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCTest {


    /*配置文件方式
     *
     * 查看容器中有多少已经注册的bean
     */
    @Test
    public void testRegisterBeanByFile(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : definitionNames) {
            System.out.println("xml方式扫描组件："+name);

        }
    }

    /*注解方式
     *
     * 查看容器中有多少已经注册的bean
     */
    @Test
    public void testRegisterBeanByConfiger(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigIOC.class);
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : definitionNames) {
            System.out.println("注解方式扫描组件："+name);
        }
    }



}