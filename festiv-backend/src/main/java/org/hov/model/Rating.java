package org.hov.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

@Entity
@Table(name="ratings")
public class Rating 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ratingId;
	
	@Column
	@NotNull
	private int userId;
	
	@Column
	@NotNull
	private int itemId;
	
	@Column
	@Range(min=1, max=5)
	private int ratingValue;

	public int getRatingId() 
	{
		return ratingId;
	}

	public void setRatingId(int ratingId) 
	{
		this.ratingId = ratingId;
	}

	public int getUserId() 
	{
		return userId;
	}

	public void setUserId(int userId) 
	{
		this.userId = userId;
	}

	public int getItemId() 
	{
		return itemId;
	}

	public void setItemId(int itemId) 
	{
		this.itemId = itemId;
	}

	public int getRatingValue() 
	{
		return ratingValue;
	}

	public void setRatingValue(int ratingValue) 
	{
		this.ratingValue = ratingValue;
	}
}
