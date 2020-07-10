package org.hov.dao;

import org.hov.model.Rating;

public interface RatingDAO 
{
	public boolean addOrUpdateRating(Rating rating);
	public int getAverageRatingForItem(int itemId);
	public Rating getRatingByItemAndUser(int itemId, int userId);
}
