package org.hov.serviceimpl;

import java.util.List;

import org.hov.dao.ItemDAO;
import org.hov.model.Item;
import org.hov.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService
{
	@Autowired
	ItemDAO itemDAO;	//ItemDAOImpl Wired
	
	@Override
	public int addItem(Item item) 
	{
		return itemDAO.addItem(item);
	}

	@Override
	public List<Item> getAllItems() 
	{
		return itemDAO.getAllItems();
	}

	@Override
	public List<Item> getItemByTeam(int teamId) 
	{
		return itemDAO.getItemByTeam(teamId);
	}

	@Override
	public Item getItemById(int itemId) 
	{
		return itemDAO.getItemById(itemId);
	}

	@Override
	public boolean updateItem(Item item) 
	{
		return itemDAO.updateItem(item);
	}

	@Override
	public boolean blockItemById(int itemId) 
	{
		return itemDAO.blockItemById(itemId);
	}

	@Override
	public boolean unblockItemById(int itemId) 
	{
		return itemDAO.unblockItemById(itemId);
	}

	@Override
	public boolean expireItemById(int itemId) 
	{
		return itemDAO.expireItemById(itemId);
	}

	@Override
	public List<Item> getActiveItems() 
	{
		return itemDAO.getActiveItems();
	}
}
