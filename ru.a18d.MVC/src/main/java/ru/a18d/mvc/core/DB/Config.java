package ru.a18d.mvc.core.DB;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Config {
    public static ConfigMSSQL getPropertiesMSSQL() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ConfigMSSQL.class);
        ConfigMSSQL bean = context.getBean("configMSSQL", ConfigMSSQL.class);
        return bean;
    }
}
