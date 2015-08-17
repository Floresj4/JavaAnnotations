package com.flores.annotations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Component class to do something...
 * @author Jason
 */
public abstract class ComponentImpl {
	protected String author;
	
	protected Logger logger = null;
	
	/** 
	 * for assertions (junit)
	**/
	protected ComponentType type = null;
	
	protected ComponentImpl(Class<?> clazz, ComponentType type) {
		LoggerFactory.getLogger(clazz);
		this.type = type;
	}
}
