package com.wsc;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wsc.tx.TxConfig;
import com.wsc.tx.UserService;

public class IOCTest_Tx {
    @Test
    public void testTX(){
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(TxConfig.class);

        UserService userService = applicationContext.getBean(UserService.class);

        userService.insertUser();
        applicationContext.close();
    }

}