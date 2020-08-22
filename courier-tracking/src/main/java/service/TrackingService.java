package service;

import java.time.Duration;
import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Coordinate;
import model.Courier;
import model.Store;
import util.TrackingUtil;

@Service
public class TrackingService implements ITrackingService{
	
	@Autowired
	CourierService courierService;
	
	@Autowired
	StoreService storeService;
	
	Logger logger = LoggerFactory.getLogger(TrackingService.class);
	
	private static final double DISTANCE_LIMIT = 100.00;
	private static final int TIME_LIMIT = 1;
	
	@Override
	public void travel(Long id, double lat, double lng) {
		Courier courier = courierService.travel(id, lat, lng);
		storeService.getAllStores().stream()
		.filter(item -> Double.compare(TrackingUtil.getDistance(
				new Coordinate(item.getLat(), item.getLng()), 
				new Coordinate(lat, lng)), DISTANCE_LIMIT) <= 1)
		.forEach(item -> {
			if(courier.getLocationUpdateTime() == null) {
				logCourierAndStore(item, courier);
				courier.getNearStores().add(item);
			} else {
				Duration duration = Duration.between(courier.getLocationUpdateTime(), LocalDateTime.now());
				if(duration.toMinutes() > TIME_LIMIT) {
					logCourierAndStore(item, courier);
					courier.getNearStores().add(item);
				}
			}
			courier.setLocationUpdateTime(LocalDateTime.now());	
		});
		
	}
	
	private void logCourierAndStore(Store store, Courier courier) {
		logger.info(courier.getCourierId() + " closer than " + 
				DISTANCE_LIMIT + "meters to " + store.getName() + "!");
	}
	
}
