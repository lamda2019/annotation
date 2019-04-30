package com.wsc.config;

import com.wsc.bean.Blue;
import com.wsc.bean.Color;
import com.wsc.condition.LinuxCondition;
import com.wsc.condition.MyImportSelector;
import com.wsc.condition.WindowsCondition;
import org.springframework.context.annotation.*;

import com.wsc.bean.Person;

@Configuration
@Import(value = { Color.class ,Blue.class, MyImportSelector.class})
public class MainConfigIOC2 {
   // @Scope("prototype")
    @Scope
    @Lazy
    @Bean("person")
    public Person person(){
        System.out.println("把Person添加到容器....");
        return new Person("赤脚医生", 18);
    }


    /**
     * @Conditional({Condition}) ：
     * 按照一定的条件进行判断，满足条件给容器中注册bean
     *
     * 如果系统是windows，给容器中注册("bill")
     * 如果是linux系统，给容器中注册("linus")
     */
    @Conditional(WindowsCondition.class)
    @Bean("bill")
    public Person person01(){
        return new Person("Bill Gates",65);
    }

    @Conditional(LinuxCondition.class)
    @Bean("linus")
    public Person person02(){
        return new Person("linus", 58);
    }

}