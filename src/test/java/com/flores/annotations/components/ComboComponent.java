package com.flores.annotations.components;

import com.flores.annotations.ComponentImpl;
import com.flores.annotations.ComponentType;

public class ComboComponent extends ComponentImpl {
	public ComboComponent() {
		super(ComboComponent.class, ComponentType.COMBO);
	}
}