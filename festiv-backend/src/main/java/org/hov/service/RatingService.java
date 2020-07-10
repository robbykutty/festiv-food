package org.hov.service;

import org.hov.model.Rating;

public interface RatingService 
{
	public boolean addOrUpdateRating(Rating rating);
	public int getAverageRatingForItem(int itemId);
	public Rating getRatingByItemAndUser(int itemId, int userId);
}
