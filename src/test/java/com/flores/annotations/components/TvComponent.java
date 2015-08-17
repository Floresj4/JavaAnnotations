package com.flores.annotations.components;

import com.flores.annotations.ComponentImpl;
import com.flores.annotations.ComponentType;

public class TvComponent extends ComponentImpl {

	public TvComponent() {
		super(TvComponent.class, ComponentType.TV);
	}
}