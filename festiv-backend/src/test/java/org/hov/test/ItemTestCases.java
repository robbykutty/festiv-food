package org.hov.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.List;
import java.util.UUID;

import org.hov.config.AppConfig;
import org.hov.model.Item;
import org.hov.service.ItemService;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringJUnitConfig(classes = AppConfig.class)
public class ItemTestCases 
{
	@Autowired
	ItemService itemService;
	
	Item targetItem;

	@Before
	public void getTargetItems()
	{
		targetItem = itemService.getItemById(UUID.fromString("e0fa4374-f9a3-4eaf-95de-c19cfa0219e3"));
	}
	
	/*  CREATION TEST CASES  */
	@Test
	@Ignore
	public void addItemValid()
	{
		Item item = new Item();
		
		item.setTeamId(2);
		item.setItemName("Item45");
		item.setItemDescription("Item 45 Description");
		item.setItemPrice(100.0);
		item.setItemPreparationTime(5*60);  //10 SECS
		item.setBlocked(false);
		item.setExpired(false);
		
		assertNotEquals(0, itemService.addItem(item));
	}


	/*  UPDATION TEST CASES  */
	
	@Test
	@Ignore
	public void updateItemValid()
	{
		targetItem.setItemName("Name Updated!");
		assertEquals(true, itemService.updateItem(targetItem));
	}

	/*  RETRIEVE TEST CASES  */
	
	@Test
	@Ignore
	public void displayItemsValid()
	{
		List<Item> itemList = itemService.getAllItems();
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
		assertNotEquals(null, itemList);
	}	

	@Test
	@Ignore
	public void displayItemByTeamValid()
	{
		List<Item> itemList = itemService.getItemByTeam(UUID.fromString(""));
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
		assertNotEquals(null, itemList);
	}	
	
	@Test
	@Ignore
	public void displayItemByIdValid()
	{
		Item itm = itemService.getItemById(targetItem.getItemId());
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
		assertNotEquals(null, itm);
	}	


	/*  SUB-UPDATION TEST CASES  */
	
	@Test
	@Ignore
	public void blockItemValid()
	{
		itemService.blockItemById(targetItem.getItemId());
	}
	
	@Test
	@Ignore
	public void unblockItemValid()
	{
		itemService.unblockItemById(targetItem.getItemId());
	}
	
	@Test
	@Ignore
	public void expireItemValid()
	{
		itemService.expireItemById(targetItem.getItemId());
	}	
}
