package com.wsc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.wsc.bean.Person;

@Configuration
public class MainConfigIOC2 {
   // @Scope("prototype")
    @Scope
    @Lazy
    @Bean("person")
    public Person person(){
        System.out.println("把Person添加到容器....");
        return new Person("赤脚医生", 18);
    }
}