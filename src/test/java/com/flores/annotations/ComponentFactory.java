package com.flores.annotations;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
			return processAnnotationChain(clazz, (ComponentImpl) constructor.newInstance());
		} catch (Exception e) {
			logger.error("Something went wrong...");
			throw e;
		}
	}

	private static ComponentImpl processAnnotationChain(Class<?> clazz, ComponentImpl component) {
		for(Field field : clazz.getFields()) {
			if(field.getAnnotations().length != 0) {

				Component annotatedComponent;
				if((annotatedComponent = field.getAnnotation(Component.class)) != null) {

					//get the component and set
					try { field.set(component, getComponent(annotatedComponent.type())); }
					catch(Exception e) {
						logger.error("An error occurred creating a component. This value will be unset.", e.getMessage());
					}
				}
			}
		}

		return component;
	}

	private static String getProperResourceName(ComponentType type) {
		char[] tmp = type.name().toLowerCase().toCharArray();
		tmp[0] = Character.toUpperCase(tmp[0]);
		return new String(tmp);
	}
}
