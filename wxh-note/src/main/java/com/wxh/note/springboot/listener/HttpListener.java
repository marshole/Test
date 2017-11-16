package com.wxh.note.springboot.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.ServletRequestHandledEvent;

/**
 * ServletRequestHandledEvent的监听器类
 * 
 * @author guangbing.dong
 * 
 */
@Component
public class HttpListener implements ApplicationListener<ServletRequestHandledEvent> {

	private static final Logger logger = LoggerFactory.getLogger(HttpListener.class);

	/**
	 * @see org.springframework.context.ApplicationListener#onApplicationEvent(org.springframework.context.ApplicationEvent)
	 */
	@Override
	public void onApplicationEvent(ServletRequestHandledEvent event) {
		logger.info("==HttpListener==");
	}
}
