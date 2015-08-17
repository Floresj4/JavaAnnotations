package com.flores.annotations;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestFactory {
	@Test
	public void testSimpleConstruction() throws Exception {
		ComponentImpl component = ComponentFactory.getComponent(ComponentType.RADIO);
		assertEquals(ComponentType.RADIO, component.type);
		
		component = ComponentFactory.getComponent(ComponentType.COMBO);
		assertEquals(ComponentType.COMBO, component.type);
	}
}
