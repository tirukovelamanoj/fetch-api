package com.fetch.api.points.entity;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author: Manoj Tirukovela
 */

@Service
public class PointsService {

	@Autowired
	private PointsRepository repo;

	public List<Points> getAllPoints() {
		List<Points> pointsList = new ArrayList<Points>();
		repo.findAll().forEach(pointsList::add);
		return pointsList;
	}

	public void addPoints(AddPoints addPoints) {
		Instant instant = Instant.parse(addPoints.getTimestamp());
		Points points = new Points();
		points.setPayer(addPoints.getPayer());
		points.setPoints(addPoints.getPoints());
		points.setTimestamp(instant.getEpochSecond());
		repo.save(points);
	}
	
	public void updatePoints(int pointsId, int points) {
		Points pointsObj = null;
		Optional<Points> p = repo.findById(pointsId);
		if (p.isPresent()) {
			pointsObj = p.get();
		}
		if(pointsObj != null) {
			pointsObj.setPoints(points);
			repo.save(pointsObj);
		}
	}

}