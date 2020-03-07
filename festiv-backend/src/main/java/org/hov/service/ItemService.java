package org.hov.service;

import java.util.List;
import java.util.UUID;

import org.hov.model.Item;

public interface ItemService 
{
	public UUID addItem(Item item);
	public List<Item> getAllItems();
	public List<Item> getActiveItems();
	public List<Item> getItemByTeam(UUID teamId);
	public Item getItemById(UUID itemId);
	public boolean updateItem(Item item);
	public boolean blockItemById(UUID itemId);
	public boolean unblockItemById(UUID itemId);
	public boolean expireItemById(UUID itemId);
}
