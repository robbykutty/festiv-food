package org.hov.test;

import java.util.List;

import org.hov.daoimpl.ItemDAOImpl;
import org.hov.model.Item;

public class ItemTest 
{	
	public static void addItem()
	{
		ItemDAOImpl udi = new ItemDAOImpl();
		Item item = new Item();
		
		item.setTeamId(2);
		item.setItemName("Item3");
		item.setItemDescription("Item 3 Description");
		item.setItemPrice(100.0);
		item.setItemPreparationTime(5*60);  //10 SECS
		item.setBlocked(false);
		item.setExpired(false);
		
		System.out.println("============Added ==>" + udi.addItem(item));
	}

	public static void updateItem()
	{
		ItemDAOImpl udi = new ItemDAOImpl();
		Item item = udi.getItemById(1);
		
		item.setItemName("Changed the Name!");
		System.out.println("============Updated ==>" + udi.updateItem(item));
	}

	public static void displayItems()
	{
		ItemDAOImpl udi = new ItemDAOImpl();
		List<Item> itemList = udi.getAllItems();
		for(Item itm:itemList)
		{
			System.out.println("------------------------------------");
			System.out.println("Item Id: " + itm.getItemId());
			System.out.println("Item Team Id: " + itm.getTeamId());
			System.out.println("Item Name: " + itm.getItemName());
			System.out.println("Item Description: " + itm.getItemDescription());
			System.out.println("Item Price: " + itm.getItemPrice());
			System.out.println("Item Preparation Time: " + itm.getItemPreparationTime());
			System.out.println("Item Blocked: " + itm.isBlocked());
			System.out.println("Item Expired: " + itm.isExpired());
		}
	}
	
	public static void displayItemByTeam()
	{

		ItemDAOImpl udi = new ItemDAOImpl();
		List<Item> itemList = udi.getItemByTeam(2);
		for(Item itm:itemList)
		{
			System.out.println("------------------------------------");
			System.out.println("Item Id: " + itm.getItemId());
			System.out.println("Item Team Id: " + itm.getTeamId());
			System.out.println("Item Name: " + itm.getItemName());
			System.out.println("Item Description: " + itm.getItemDescription());
			System.out.println("Item Price: " + itm.getItemPrice());
			System.out.println("Item Preparation Time: " + itm.getItemPreparationTime());
			System.out.println("Item Blocked: " + itm.isBlocked());
			System.out.println("Item Expired: " + itm.isExpired());
		}
	}	
	
	public static void displayItemById()
	{
		ItemDAOImpl udi = new ItemDAOImpl();
		Item itm = udi.getItemById(1);
		if(itm != null)
		{
			System.out.println("------------------------------------");
			System.out.println("Item Id: " + itm.getItemId());
			System.out.println("Item Team Id: " + itm.getTeamId());
			System.out.println("Item Name: " + itm.getItemName());
			System.out.println("Item Description: " + itm.getItemDescription());
			System.out.println("Item Price: " + itm.getItemPrice());
			System.out.println("Item Preparation Time: " + itm.getItemPreparationTime());
			System.out.println("Item Blocked: " + itm.isBlocked());
			System.out.println("Item Expired: " + itm.isExpired());
		}
		else
		{
			System.out.println("Null-------------------------------");
		}
	}	
	
	public static void blockItem()
	{
		ItemDAOImpl udi = new ItemDAOImpl();
		//udi.blockItemById(1);
		//udi.expireItemById(1);
		udi.unblockItemById(1);
	}
	
	public static void main(String[] args)
	{
		//addItem();
		//updateItem();
		//displayItems();
		//blockItem();
		//displayItemById();
		//displayItemByTeam();
		//displayItems();
	}
}
