package com.wsc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wsc.bean.Car;

@Configuration
public class MainConfigOfLifeCycle {

    @Bean(initMethod="init",destroyMethod="detory")
    public Car car(){
        return new Car();
    }

}