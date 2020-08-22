package model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Courier {
	
	private long courierId;
	private double latitude;
	private double longitude;
	private LocalDateTime locationUpdateTime;
	private double travelDistance;
	private Set<Store> nearStores;
	
	public Courier() {
		nearStores = new HashSet<>();
	}

	public long getCourierId() {
		return courierId;
	}

	public void setCourierId(long courierId) {
		this.courierId = courierId;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public LocalDateTime getLocationUpdateTime() {
		return locationUpdateTime;
	}

	public void setLocationUpdateTime(LocalDateTime locationUpdateTime) {
		this.locationUpdateTime = locationUpdateTime;
	}

	public double getTravelDistance() {
		return travelDistance;
	}

	public void setTravelDistance(double travelDistance) {
		this.travelDistance = travelDistance;
	}

	public Set<Store> getNearStores() {
		return nearStores;
	}

	public void setNearStores(Set<Store> nearStores) {
		this.nearStores = nearStores;
	}
	
	
}
