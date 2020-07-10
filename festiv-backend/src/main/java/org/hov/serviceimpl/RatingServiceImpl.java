package org.hov.serviceimpl;

import org.hov.dao.RatingDAO;
import org.hov.model.Rating;
import org.hov.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingServiceImpl implements RatingService
{
	@Autowired
	RatingDAO ratingDAO;	//RatingDAOImpl Wired
	
	@Override
	public boolean addOrUpdateRating(Rating rating) 
	{
		return ratingDAO.addOrUpdateRating(rating);
	}

	@Override
	public int getAverageRatingForItem(int itemId) 
	{
		return ratingDAO.getAverageRatingForItem(itemId);
	}

	@Override
	public Rating getRatingByItemAndUser(int itemId, int userId) 
	{
		return ratingDAO.getRatingByItemAndUser(itemId, userId);
	}
}
