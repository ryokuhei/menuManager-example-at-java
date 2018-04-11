package com.mycompany.menuManager;

import java.io.Serializable;
import java.util.List;

public class MenuList implements Aggregate, Serializable  {
	
	private static final long serialVersionUID = 14565688L;

	private List<MenuModel> menuList;
    private MenuListIterator iterator;
	
	public MenuList(List<MenuModel> menuList) {
		this.menuList = menuList;
		this.iterator = new MenuListIterator(this, 0 ,true);
	}

	@Override
	public Iterator iterator() {
		return this.iterator;
	}

	public List<MenuModel> getMenuList() {
		return this.menuList;
	}


	public MenuModel getMenuAt(int index) {
		return this.menuList.get(index);
	}
	
	public int getCount() {
		return this.menuList.size();
	}

}
