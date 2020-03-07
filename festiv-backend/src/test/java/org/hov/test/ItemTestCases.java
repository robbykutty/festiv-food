package org.hov.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.hov.config.AppConfig;
import org.hov.model.Item;
import org.hov.service.ItemService;
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
		Item item = itemService.getItemById(4);
		item.setItemName("Name Updated!");
		assertEquals(true, itemService.updateItem(item));
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
		List<Item> itemList = itemService.getItemByTeam(2);
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
		Item itm = itemService.getItemById(3);
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
		itemService.blockItemById(1);
	}
	
	@Test
	@Ignore
	public void unblockItemValid()
	{
		itemService.unblockItemById(1);
	}
	
	@Test
	@Ignore
	public void expireItemValid()
	{
		itemService.expireItemById(4);
	}	
}
