package com.mycompany.menuManager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Presenter implements Serializable {
	
	private static final long serialVersionUID = 2545755222L;

	private MenuList menuList;
	
	public Presenter() {
		this.loadMenuList();
	}
	
	
	private void loadMenuList() {
		List<MenuModel> menuList = new ArrayList<MenuModel>();
		menuList.add(new MenuModel("0", "a"));
		menuList.add(new MenuModel("1", "b"));
		menuList.add(new MenuModel("2", "c"));
		menuList.add(new MenuModel("3", "d"));
		menuList.add(new MenuModel("4", "e"));
		this.menuList = new MenuList(menuList);
		
	}

	public MenuModel currentMenu() {
     	Iterator iterator = menuList.iterator();
    	return (MenuModel) iterator.current();
	
	}

    public MenuModel prevMenu() {
    	Iterator iterator = menuList.iterator();
    	return (MenuModel) iterator.prev();
	}

	public MenuModel nextMenu() {
     	Iterator iterator = menuList.iterator();
    	return (MenuModel) iterator.next();
	}
	

}
