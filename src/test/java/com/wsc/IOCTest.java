package com.wsc;


import com.wsc.bean.Blue;
import com.wsc.bean.Person;
import com.wsc.config.MainConfigIOC;
import com.wsc.config.MainConfigIOC2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

public class IOCTest {


    /*配置文件方式
     *
     * 查看容器中有多少已经注册的bean
     */
    @Test
    public void testRegisterBeanByFile(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : definitionNames) {
            System.out.println("xml方式扫描组件："+name);

        }
    }

    /*注解方式
     *
     * 查看容器中有多少已经注册的bean
     */
    @Test
    public void testRegisterBeanByConfiger(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigIOC.class);
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : definitionNames) {
            System.out.println("注解方式扫描组件："+name);
        }
    }

    /*注解方式测试@Scope
     *
     * 查看容器中有多少已经注册的bean
     */
    @Test
    public void testScope(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigIOC2.class);
        System.out.println("ioc容器创建完成....");
        Object bean = applicationContext.getBean("person");
        Object bean2 = applicationContext.getBean("person");
        System.out.println(bean == bean2);
    }

    /*@Lazy
     *
     * 未使用懒加载
     */
    @Test
    public void testNoLazy(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigIOC2.class);
        System.out.println("ioc容器创建完成....");
    }

    /*@Lazy
     *
     * 使用懒加载，但未使用bean
     */
    @Test
    public void testLazyNoUse(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigIOC2.class);
        System.out.println("ioc容器创建完成....但是在未使用时该bean不会创建");
    }

    /*@Lazy
     *
     * 使用懒加载，同时使用bean
     */
    @Test
    public void testLazyUse(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigIOC2.class);
        System.out.println("ioc容器创建完成....");
        Object bean = applicationContext.getBean("person");
        Object bean2 = applicationContext.getBean("person");
        System.out.println(bean == bean2);
    }


    /*@Condition
     *
     * 按条件加载bean
     */
    @Test
    public void testCondition(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigIOC2.class);
        String[] namesForType = applicationContext.getBeanNamesForType(Person.class);
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        //动态获取环境变量的值；Windows 7
        String property = environment.getProperty("os.name");
        System.out.println(property);
        for (String name : namesForType) {
            System.out.println(name);
        }

        Map<String, Person> persons = applicationContext.getBeansOfType(Person.class);
        System.out.println(persons);

    }


    /*@Import
     *
     * 导进组件
     */
    @Test
    public void testImport(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigIOC2.class);
        printBeans(applicationContext);
        Blue bean = applicationContext.getBean(Blue.class);
        System.out.println(bean);


    }

    private void printBeans(AnnotationConfigApplicationContext applicationContext){
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : definitionNames) {
            System.out.println(name);
        }
    }
}