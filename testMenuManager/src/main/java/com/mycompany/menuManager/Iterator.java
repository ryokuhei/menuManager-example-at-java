package com.mycompany.menuManager;

public interface Iterator {
	public Object current();

	public boolean hasPrev();
	public Object prev();

	public boolean hasNext();
	public Object next();
}
