package com.woniu.util.cache;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextHolder implements ApplicationContextAware {

	private static ApplicationContext atx;
	@Override
	//spring容器会自动调用该方法，传入ApplicationContext对象
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		atx=applicationContext;
	}
	public static ApplicationContext getApplicationContext() {
		return atx;
	}
	public static<T> T getBean(Class<T> cls) {
		return atx.getBean(cls);
	}
	public static Object getBean(String classname) {
		return atx.getBean(classname);
	}

}
