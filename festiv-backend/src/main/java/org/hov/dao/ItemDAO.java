package org.hov.dao;

import java.util.List;

import org.hov.model.Item;

public interface ItemDAO 
{
	public int addItem(Item item);
	public List<Item> getAllItems();
	public List<Item> getActiveItems();
	public List<Item> getItemByTeam(int teamId);
	public Item getItemById(int itemId);
	public boolean updateItem(Item item);
	public boolean blockItemById(int itemId);
	public boolean unblockItemById(int itemId);
	public boolean expireItemById(int itemId);
}
