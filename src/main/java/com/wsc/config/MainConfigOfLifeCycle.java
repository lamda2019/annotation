package com.wsc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wsc.bean.Car;
import org.springframework.context.annotation.Scope;

@Configuration

public class MainConfigOfLifeCycle {

    @Scope("prototype")
    @Bean(initMethod="init",destroyMethod="detory")
    public Car car(){
        return new Car();
    }

}