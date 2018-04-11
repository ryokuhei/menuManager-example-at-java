package com.mycompany.menuManager;

import java.io.Serializable;

public class MenuListIterator implements Iterator, Serializable {
	
	private static final long serialVersionUID = 125777L;

	private MenuList menuList;
	private int index;
	private boolean isInfinite;
	
	public MenuListIterator(MenuList menuList, int startIndex, boolean isInfinite) {
		this.menuList = menuList;
		this.index = startIndex;
		this.isInfinite = isInfinite;
	}

	@Override
	public Object getCurrentObject() {
		return this.menuList.getMenuAt(index);
	}

	@Override
	public Object getPreviousObject() {
		Object previous = null;
		if(this.hasPrevious()) {
			previous = this.menuList.getMenuAt(index - 1);
	    } else if(this.isInfinite && this.menuList.getCount() > 1) {
			previous = this.menuList.getMenuAt(this.menuList.getCount() - 1);
	    }

		return previous;
	}

	@Override
	public Object getNextObject() {
		Object next = null;
		if(this.hasNext()) {
			next = this.menuList.getMenuAt(this.index + 1);
	    } else if(this.isInfinite && this.menuList.getCount() > 1) {
			next = this.menuList.getMenuAt(0);
	    }

		return next;
	}


	@Override
	public boolean hasPrevious() {
		boolean hasPrev = this.index - 1 >= 0 ? true : false;
		System.out.println("has Previous: " + hasPrev);
		return hasPrev;
	}

	@Override
	public boolean previous() {

		boolean isPrev = false;
		
		if(this.hasPrevious()) {
			index = index - 1;
			isPrev = true;
		} else if(this.isInfinite) {
			index = this.menuList.getCount() - 1;
			isPrev = true;
		}

		return isPrev;
	}

	@Override
	public boolean hasNext() {
		boolean hasNext = this.index + 1 <= this.menuList.getCount() - 1 ? true : false;
		System.out.println("has Next: " + hasNext);
		return hasNext;
	}

	@Override
	public boolean next() {
		
		boolean isNext = false;
		
		if(this.hasNext()) {
			index = index + 1;
			isNext = true;
		} else if(this.isInfinite) {
			index = 0;
			isNext = true;
		}

		return isNext;
	}
	
	@Override
	public boolean setPosition(String key) {

		boolean isSet = false;
		try {
    		this.index =  Integer.parseInt(key);
    		isSet = true;
		} catch(NumberFormatException e) {

			
		}
    	isSet = true;

		return isSet;
	}
	
	


}
