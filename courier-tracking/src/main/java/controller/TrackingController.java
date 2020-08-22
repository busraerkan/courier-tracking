package controller;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Courier;
import model.Store;
import service.CourierService;
import service.StoreService;
import service.TrackingService;

@RestController
@RequestMapping("/courierTracking")
public class TrackingController {
	
	@Autowired 
	CourierService courierService;
	
	@Autowired
	TrackingService trackingService;
	
	@Autowired
	StoreService storeService;
	
	Logger logger = LoggerFactory.getLogger(TrackingController.class);
	
	@RequestMapping("/allCouriers")
	public Set<Courier> getAllCouriers() {
		return courierService.getAll();
	}

	@RequestMapping("/courier/{id}")
	public Courier getCouirer(@PathVariable("id") Long id) {
		return courierService.getCourier(id);
	}
	
	@RequestMapping("/travel/{id}/{lat}/{lng}")
	public void travel(@PathVariable("id") Long id, @PathVariable("lat") Double lat, @PathVariable("lng") Double lng) {
		trackingService.travel(id, lat, lng);
	}
	
	@RequestMapping("courier/distance/{id}")
	public Double getTotalDistance(@PathVariable("id") Long id) {
		return courierService.getTotalDistance(id);
	}
	
	@RequestMapping("store/allStores")
	public Set<Store> getAllStores() {
		return storeService.getAllStores();
	}
}
