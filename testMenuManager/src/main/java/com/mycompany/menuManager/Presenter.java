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
	
	public List<MenuModel> getMenuList() {
		return this.menuList.getMenuList();
	}

	public MenuModel currentMenu() {
     	Iterator iterator = menuList.iterator();
    	return (MenuModel) iterator.getCurrentObject();
	}

	public MenuModel beforeMenu() {
     	Iterator iterator = menuList.iterator();
    	return (MenuModel) iterator.getPreviousObject();
	}

	public MenuModel afterMenu() {
     	Iterator iterator = menuList.iterator();
    	return (MenuModel) iterator.getNextObject();
	}


    public boolean goToPreviousContent() {
    	Iterator iterator = menuList.iterator();
    	return iterator.previous();
	}

	public boolean goToNextContent() {
     	Iterator iterator = menuList.iterator();
    	return iterator.next();
	}
	
	public void select(String key) {
		Iterator iterator = menuList.iterator();
		iterator.setPosition(key);
	}

}
