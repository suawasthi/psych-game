package com.psych.game.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContxtProvider implements ApplicationContextAware {

	private static ApplicationContext applicationContextt;

	public static ApplicationContext getApplicationContext() {
		return applicationContextt;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		applicationContextt = applicationContext;
	}

}
