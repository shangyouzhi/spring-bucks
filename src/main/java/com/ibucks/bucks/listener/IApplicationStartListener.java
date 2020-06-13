package com.ibucks.bucks.listener;

import org.apache.ibatis.ognl.enhance.ContextClassLoader;
import org.codehaus.plexus.util.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class IApplicationStartListener implements ApplicationListener<ApplicationStartedEvent> {

    private static Logger logger = LoggerFactory.getLogger(IApplicationStartListener.class);
    @Override
    public void onApplicationEvent(ApplicationStartedEvent applicationStartedEvent) {

        SpringApplication application = applicationStartedEvent.getSpringApplication();
        application.setBannerMode(Banner.Mode.OFF);
        String name = null;
        try {
           Properties properties =  PropertyUtils.loadProperties(ContextClassLoader.getSystemResourceAsStream("application.properties"));
           name = properties.getProperty("spring.application.name");
            logger.info("开始启动项目：{}",name);
        } catch (IOException e) {
           logger.error("项目：{}，启动失败，{}，{}",name,e.getMessage(),e);
        }


        ;
    }

}
