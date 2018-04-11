package com.mycompany.menuManager;

import java.io.Serializable;

public class MenuModel implements Serializable {
	
	private static final long serialVersionUID = 155787513L;

	private String key;
	private String display;
	private boolean isActive;
	
	public MenuModel(String key, String display) {
		this.key = key;
		this.display = display;
		this.isActive = false;
	}
	
	public String getKey() {
		return this.key;
	}
	
	public String getDisplay() {
	    return this.display;
	}
	
	public boolean isActive() {
		return isActive;
	}
	public void setActive(Boolean state) {
		this.isActive = state;
	}
}
