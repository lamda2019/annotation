package com.wsc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wsc.bean.Person;

@Configuration
public class MainConfig {
    @Bean("person")
    public Person person01(){
        return new Person("赤脚医生", 18);
    }
}