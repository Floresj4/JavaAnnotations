package com.flores.annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.flores.annotations.components.ComboComponent;

/**
 * Factory for loading components and
 * processing annotations
 * @author Jason
 */
public class ComponentFactory {
	
	public static final String RESOURCE = "com.flores.annotations.components.%sComponent";
	
	private static final Logger logger = LoggerFactory.getLogger(ComponentFactory.class);
	
	public static ComponentImpl getComponent(ComponentType type) throws Exception {
		try {
			Class<?>clazz = Class.forName(String.format(RESOURCE, getProperResourceName(type)));
			Constructor<?> constructor = clazz.getConstructor();
			
			ComponentImpl component = (ComponentImpl) constructor.newInstance();
			if(component instanceof ComboComponent) {
				processAnnotations(clazz, (ComboComponent)component);
			}
			
			return (ComponentImpl) constructor.newInstance();
		} catch (Exception e) {
			logger.error("Something went wrong...");
			throw e;
		}
	}

	private static void processAnnotations(Class<?> clazz, ComboComponent component) {
		//check for field level annotations
		for(Field field : clazz.getFields()) {
			Annotation annotation[] = field.getAnnotations();
		}
	}
	
	private static String getProperResourceName(ComponentType type) {
		char[] tmp = type.name().toLowerCase().toCharArray();
		tmp[0] = Character.toUpperCase(tmp[0]);
		return new String(tmp);
	}
}
