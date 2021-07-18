package ru.a18d.mvc.core.DB;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Config {
    public static ConfigMSSQL getPropertiesMSSQL() {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContextAnnotation.xml");
        ConfigMSSQL bean = context.getBean("configMSSQL", ConfigMSSQL.class);
        return bean;
    }
}
