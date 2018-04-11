package com.mycompany.menuManager;

public interface Iterator {
	public Object getCurrentObject();
	public Object getPreviousObject();
	public Object getNextObject();

	public boolean hasPrevious();
	public boolean hasNext();
	
	public boolean previous();
	public boolean next();
	public boolean setPosition(String key);


}
