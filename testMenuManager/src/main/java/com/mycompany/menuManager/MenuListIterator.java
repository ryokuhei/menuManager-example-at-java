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
	public Object current() {
		return this.menuList.getMenuAt(index);
	}

	@Override
	public boolean hasPrev() {
		return this.index - 1 >= 0 ? true : false;
	}

	@Override
	public Object prev() {
		if(this.isInfinite && !this.hasPrev()) {
			index = this.menuList.getCount() - 1;
		} else {
			index = index - 1;
		}
		
		return this.menuList.getMenuAt(index);
	}

	@Override
	public boolean hasNext() {
		return this.index + 1 <= this.menuList.getCount() - 1 ? true : false;
	}

	@Override
	public Object next() {

		if(this.isInfinite && !this.hasNext()) {
			index = 0;
		} else {
			index = index + 1;
		}

		return this.menuList.getMenuAt(index);
	}


}
