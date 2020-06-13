package com.ibucks.bucks;

import com.google.common.collect.Lists;
import com.ibucks.bucks.beans.IMongoCustomConversions;
import com.ibucks.bucks.converter.MoneyReadConverter;
import com.ibucks.bucks.listener.IApplicationStartListener;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

import javax.swing.*;

@SpringBootApplication
@MapperScan(basePackages = {"com.ibucks.bucks.model.mapper","mybatis.mapper"})
@ComponentScan(basePackages = {"com.ibucks.*"})
//@ImportResource({"classpath*:mybatis/mybatis-config.xml"})
@EnableAspectJAutoProxy
public class BucksApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(BucksApplication.class);
		application.addListeners(new IApplicationStartListener());
		application.setBannerMode(Banner.Mode.CONSOLE);
		application.run(args);
		//SpringApplication.run(BucksApplication.class, args);
		/*new SpringApplicationBuilder()
				.sources(BucksApplication.class)
				.run(args);*/
	}

	@Bean
	public MongoCustomConversions mongoCustomConversions(){
		return new IMongoCustomConversions(Lists.newArrayList(new MoneyReadConverter()));
	}
}
