package com.flores.annotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.apache.log4j.PropertyConfigurator;
import org.junit.BeforeClass;
import org.junit.Test;

import com.flores.annotations.components.ComboComponent;

public class TestFactory {
	@BeforeClass
	public static void init() {
		PropertyConfigurator.configure("./src/test/resources/log4j.properties");
	}

	@Test
	public void testSimpleConstruction() throws Exception {
		ComponentImpl component = ComponentFactory.getComponent(ComponentType.RADIO);
		assertEquals(ComponentType.RADIO, component.type);
		
		component = ComponentFactory.getComponent(ComponentType.COMBO);
		assertEquals(ComponentType.COMBO, component.type);
	}
	
	@Test
	public void testAnnotatedConstruction() throws Exception {
		ComponentImpl component = ComponentFactory.getComponent(ComponentType.COMBO);
		assertEquals(ComponentType.COMBO, component.type);
		
		ComboComponent combo = (ComboComponent)component;
		assertNotNull(combo.subComponentA);
		assertEquals(combo.subComponentA.type, ComponentType.RADIO);
		assertNotNull(combo.subComponentB);
		assertEquals(combo.subComponentB.type, ComponentType.TV);
	}
}