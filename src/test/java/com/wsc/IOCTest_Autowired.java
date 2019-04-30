package com.wsc;

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

}