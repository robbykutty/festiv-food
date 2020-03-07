package org.hov.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

@Entity
@Table (name = "Items")
public class Item 
{
	@Id
	@GeneratedValue
	@Type(type = "uuid-char")
	private UUID itemId;
	
	@Column
	@NotNull
	private int teamId;
	
	@Column
	@NotBlank(message = "Item Name is Mandatory")
	@Length(min = 3, message = "Cannot be less than 3 characters")
	@Length(max = 16, message = "Cannot be more than 16 characters")
	private String itemName;
	
	@Column
	@NotBlank(message = "Cannot be Empty")
	@Length(min = 10, message = "Cannot be less than 10 characters")
	@Length(max = 70, message = "Cannot be more than 70 characters")
	private String itemDescription;
	
	@Column
	@URL(protocol = "https")
	private String itemPictureURL;

	@Column
	@NotNull
	@Min(value = 0L, message = "Amount cannot be less than 0")
	private Double itemPrice;
	
	@Column
	@NotNull
	@Min(value = 0L, message = "Quantity cannot be less than 0")
	private int itemQuantity;
	
	@Column
	@NotNull
	@Min(value = 0L, message = "Time cannot be less than 0")
	private int itemPreparationTime;

	@Column(nullable = false)
	@NotNull
	private boolean expired;

	@Column(nullable = false)
	@NotNull
	private boolean blocked;
	
	public UUID getItemId() 
	{
		return itemId;
	}

	public void setItemId(UUID itemId) 
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

	public Double getItemPrice() 
	{
		return itemPrice;
	}

	public void setItemPrice(Double itemPrice) 
	{
		this.itemPrice = itemPrice;
	}

	public int getItemQuantity() 
	{
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity) 
	{
		this.itemQuantity = itemQuantity;
	}	
	
	public String getItemPictureURL() 
	{
		return itemPictureURL;
	}

	public void setItemPictureURL(String itemPictureURL) 
	{
		this.itemPictureURL = itemPictureURL;
	}
}
