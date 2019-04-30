package com.wsc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.wsc.bean.Car;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("com.wsc.bean")
public class MainConfigOfLifeCycle {

    @Scope("prototype")
    @Bean(initMethod="init",destroyMethod="detory")
    public Car car(){
        return new Car();
    }

}