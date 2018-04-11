package com.mycompany.menuManager;

public interface Iterator {
	public Object getCurrentObject();
	public Object getPreviousObject();
	public Object getNextObject();

	public boolean hasPrevious();
	public Object previous();

	public boolean hasNext();
	public Object next();


}
