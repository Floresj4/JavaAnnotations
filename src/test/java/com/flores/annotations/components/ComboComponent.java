package com.flores.annotations.components;

import com.flores.annotations.Component;
import com.flores.annotations.ComponentImpl;
import com.flores.annotations.ComponentType;

public class ComboComponent extends ComponentImpl {
	
	@Component(type = ComponentType.RADIO)
	public ComponentImpl subComponentA;

	@Component(type = ComponentType.TV)
	public ComponentImpl subComponentB;
	
	public ComboComponent() {
		super(ComboComponent.class, ComponentType.COMBO);
	}
}