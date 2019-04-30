package com.wsc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScans(
        value = {
                @ComponentScan(value="com.wsc",includeFilters = {
                        @ComponentScan.Filter(type=FilterType.ANNOTATION,classes={Controller.class}),
                },useDefaultFilters = false)
        }
)

public class MainConfigIOC {

}