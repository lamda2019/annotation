package com.wsc;

import com.wsc.bean.Boss;
import com.wsc.bean.Car;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.wsc.config.MainConifgOfAutowired;
import com.wsc.dao.PersonDao;
import com.wsc.servicer.PersonServicer;

public class IOCTest_Autowired {

    @Test
    public void testAutowired(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConifgOfAutowired.class);

        PersonServicer personService = applicationContext.getBean(PersonServicer.class);
        System.out.println(personService);

        PersonDao bean = (PersonDao) applicationContext.getBean("personDao");
        System.out.println(bean);

        applicationContext.close();
    }

    @Test
    public void testMetheod(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConifgOfAutowired.class);

        Boss boss = applicationContext.getBean(Boss.class);
        Car car = applicationContext.getBean(Car.class);
        System.out.println("装配到Boss的bean:"+boss+" 和容器中的bean:"+car);
        applicationContext.close();
    }

}