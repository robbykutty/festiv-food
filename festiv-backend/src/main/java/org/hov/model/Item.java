package org.hov.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "Items")
public class Item 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int itemId;
	
	@Column
	private int teamId;
	private String itemName;
	private String itemDescription;
	private String item;
	private float itemPrice;
	private int itemPreparationTime;
	private boolean expired;
	private boolean blocked;
	
	public int getItemId() 
	{
		return itemId;
	}
	
	public void setItemId(int itemId) 
	{
		this.itemId = itemId;
	}
	
	public int getTeamId() 
	{
		return teamId;
	}
	
	public void setTeamId(int teamId) 
	{
		this.teamId = teamId;
	}
	
	public String getItemName() 
	{
		return itemName;
	}
	
	public void setItemName(String itemName) 
	{
		this.itemName = itemName;
	}
	
	public String getItemDescription() 
	{
		return itemDescription;
	}
	
	public void setItemDescription(String itemDescription) 
	{
		this.itemDescription = itemDescription;
	}
	
	public String getItem() 
	{
		return item;
	}
	
	public void setItem(String item) 
	{
		this.item = item;
	}
	
	public float getItemPrice() 
	{
		return itemPrice;
	}
	
	public void setItemPrice(float itemPrice) 
	{
		this.itemPrice = itemPrice;
	}
	
	public int getItemPreparationTime() 
	{
		return itemPreparationTime;
	}
	
	public void setItemPreparationTime(int itemPreparationTime) 
	{
		this.itemPreparationTime = itemPreparationTime;
	}
	
	public boolean isExpired() 
	{
		return expired;
	}
	
	public void setExpired(boolean expired) 
	{
		this.expired = expired;
	}
	
	public boolean isBlocked() 
	{
		return blocked;
	}
	
	public void setBlocked(boolean blocked) 
	{
		this.blocked = blocked;
	}
	
}
