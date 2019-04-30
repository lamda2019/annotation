package com.wsc;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.wsc.aop.MathCalculator;
import com.wsc.config.MainConfigOfAOP;



public class IOCTest_AOP {

    @Test
    public void testAOP(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAOP.class);

        //1、不要自己创建对象
//		MathCalculator mathCalculator = new MathCalculator();
//		mathCalculator.div(1, 1);
        MathCalculator mathCalculator = applicationContext.getBean(MathCalculator.class);

        mathCalculator.div(1, 2);

        applicationContext.close();
    }

}
