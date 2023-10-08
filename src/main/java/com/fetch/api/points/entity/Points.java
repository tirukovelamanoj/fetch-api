package com.fetch.api.points.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "points")
public class Points implements Comparable<Points>{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pointsId;

	private String payer;
	private int points;
	private long timestamp;

	public String getPayer() {
		return payer;
	}

	public void setPayer(String payer) {
		this.payer = payer;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	
	public int getPointsId() {
		return pointsId;
	}
	
    @Override
    public int compareTo(Points p) {
    	Long ct = this.timestamp;
        Long pt = p.getTimestamp();
        return ct.compareTo(pt);
    }

}