package com.flores.annotations;

import java.lang.reflect.Constructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ComponentFactory {
	
	public static final String RESOURCE = "com.flores.annotations.components.%sComponent";
	
	private static final Logger logger = LoggerFactory.getLogger(ComponentFactory.class);
	
	public static ComponentImpl getComponent(ComponentType type) throws Exception {
		try {
			Class<?>clazz = Class.forName(String.format(RESOURCE, getProperResourceName(type)));
			Constructor<?> constructor = clazz.getConstructor();
			return (ComponentImpl) constructor.newInstance();

			//Annotation annotation = clazz.getAnnotations();
		} catch (Exception e) {
			logger.error("Something went wrong...");
			throw e;
		}
	}
	
	private static String getProperResourceName(ComponentType type) {
		char[] tmp = type.name().toLowerCase().toCharArray();
		tmp[0] = Character.toUpperCase(tmp[0]);
		return new String(tmp);
	}
}
