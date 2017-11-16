package com.wxh.note.springboot.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * spring boot 启动监听类
 *
 * @author weixuhui
 *
 */
@Component
public class MyApplicationStartedEventListener implements ApplicationListener<ApplicationStartedEvent>{

	private Logger logger = LoggerFactory.getLogger(MyApplicationStartedEventListener.class);
	
	@Override
	public void onApplicationEvent(ApplicationStartedEvent event) {
		SpringApplication app = event.getSpringApplication();
		// 不显示banner信息
        app.setBannerMode(Banner.Mode.OFF);
        System.out.println("==MyApplicationStartedEventListener==");
        logger.info("==MyApplicationStartedEventListener==");
	}
}
