package com.wsc.config;

import com.wsc.bean.Boss;
import com.wsc.bean.Car;
import com.wsc.bean.Color;
import com.wsc.dao.PersonDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


@Configuration
@ComponentScan({"com.wsc.servicer","com.wsc.dao",
        "com.wsc.controller","com.wsc.bean"})
public class MainConifgOfAutowired {

    @Primary
    @Bean("personDao2")
    public PersonDao personDao(){
        PersonDao personDao = new PersonDao();
        personDao.setLable("2");
        return personDao;
    }

    /**
     * @Bean标注的方法创建对象的时候，方法参数的值从容器中获取
     * @param car
     * @return
     */
    @Bean
    public Color color(Car car){
        Color color = new Color();
        color.setCar(car);
        return color;
    }


}