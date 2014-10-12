package com.projectstew.item;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
	
	private List<Item> itemList;
	
	public Inventory() {
		itemList = new ArrayList<Item>();
	}
	
	public void add(Item item) {
		itemList.add(item);
	}
	
	public void remove(Item item) {
		itemList.remove(item);
	}
	
	public boolean contains(Item item) {
		return itemList.contains(item);
	}
}
