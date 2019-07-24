package com.test;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextException;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.io.IOException;

public class SpringTest {

    public static void main(String[] args){
        ApplicationContext context=new FileSystemXmlApplicationContext(
                "src/main/resources/spring.xml"
        );
    }


}


