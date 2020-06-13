package com.ibucks.bucks.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.ognl.enhance.ContextClassLoader;
import org.codehaus.plexus.util.PropertyUtils;
import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.context.ApplicationListener;

import java.util.Properties;

@Slf4j
public class IApplicationFailedListener implements ApplicationListener<ApplicationFailedEvent> {

    @Override
    public void onApplicationEvent(ApplicationFailedEvent applicationFailedEvent) {
        Throwable throwable = applicationFailedEvent.getException();
        String name = null;
        try {
            Properties properties = PropertyUtils.loadProperties(ContextClassLoader.getSystemResourceAsStream("application.properties"));
            name = properties.getProperty("spring.application.name");
            log.error("项目：{}，启动失败，失败原因：{}",name,throwable.getCause());
        }catch (Exception se){

        }
    }
}
