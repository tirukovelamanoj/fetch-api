package com.fetch.api.points.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fetch.api.points.entity.AddPoints;
import com.fetch.api.points.entity.Points;
import com.fetch.api.points.entity.PointsService;
import com.google.gson.Gson;

/**
 * Author: Manoj Tirukovela
 */

@SpringBootApplication
@RestController
@RequestMapping("/")
public class FetchController {

	@Autowired
	private PointsService pointsService;

	@PostMapping(path = "add")
	public ResponseEntity<String> addPoints(@RequestBody AddPoints addPoints) {
		if (addPoints != null) {
			pointsService.addPoints(addPoints);
			return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		}
		return new ResponseEntity<String>("FAILURE", HttpStatus.BAD_REQUEST);
	}

	@PostMapping(path = "spend", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> spendPoints(@RequestBody Map<String, Integer> spend) {
		if (spend != null && spend.get("points") != null) {
			int amount = spend.get("points");
			List<Points> pointsList = pointsService.getAllPoints();
			if (pointsList != null) {
				Collections.sort(pointsList);
				HashMap<String, Integer> pointsMap = new HashMap<String, Integer>();
				HashMap<Integer, Integer> updatePoints = new HashMap<Integer, Integer>();
				for (int i = 0; i < pointsList.size() && amount != 0; i++) {
					Points p = pointsList.get(i);
					if (amount > p.getPoints()) {
						amount = amount - p.getPoints();
						updatePoints.put(p.getPointsId(), 0);
						if (pointsMap.containsKey(p.getPayer())) {
							pointsMap.put(p.getPayer(), pointsMap.get(p.getPayer()) - p.getPoints());
						} else {
							pointsMap.put(p.getPayer(), 0 - p.getPoints());
						}
					} else {
						updatePoints.put(p.getPointsId(), p.getPoints() - amount);
						if (pointsMap.containsKey(p.getPayer())) {
							pointsMap.put(p.getPayer(), pointsMap.get(p.getPayer()) - amount);
						} else {
							pointsMap.put(p.getPayer(), 0 - amount);
						}
						amount = 0;
					}
				}
				if (amount == 0) {
					updatePoints.forEach((key, value) -> pointsService.updatePoints(key, value));
					return new ResponseEntity<String>(new Gson().toJson(pointsMap), HttpStatus.OK);
				}
			}
		}
		return new ResponseEntity<String>("The user doesn’t have enough points!", HttpStatus.BAD_REQUEST);
	}

	@GetMapping(path = "balance", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getPoints() {
		String json;
		List<Points> pointsList = pointsService.getAllPoints();
		if (pointsList != null) {
			HashMap<String, Integer> pointsMap = new HashMap<String, Integer>();
			for (Points points : pointsList) {
				String key = points.getPayer();
				if (pointsMap.containsKey(key)) {
					pointsMap.put(key, pointsMap.get(key) + points.getPoints());
				} else {
					pointsMap.put(key, points.getPoints());
				}
			}
			json = new Gson().toJson(pointsMap);
		} else {
			pointsList = new ArrayList<Points>();
			json = new Gson().toJson(pointsList);
		}
		return new ResponseEntity<String>(json, HttpStatus.OK);
	}

}