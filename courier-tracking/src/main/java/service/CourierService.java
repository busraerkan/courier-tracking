package service;

import java.io.IOException;
import java.util.Set;

import org.springframework.stereotype.Service;

import model.Coordinate;
import model.Courier;
import util.CourierUtil;
import util.TrackingUtil;

@Service
public class CourierService implements ICourierService{
	
	Set<Courier> couriers;
	
	public CourierService() {
		try {
			couriers = CourierUtil.getCouriers();
		} catch (IOException e) {
			throw new IllegalArgumentException("Please check your couriers.json file!");
		}
	}
	
	@Override
	public Courier getCourier(Long id) {
		if(couriers != null) {
			return couriers.stream().filter(item -> item.getCourierId() == id)
					.findFirst().orElse(null);
		}
		return null;
	}
	
	@Override
	public Set<Courier> getAll() {
		return couriers;
	}

	@Override
	public double getTotalDistance(Long id) {
		return getCourier(id).getTravelDistance();
	}
	
	@Override
	public Courier travel(Long id, double lat, double lng) {
		Courier courier = getCourier(id);
		double distance = TrackingUtil.getDistance(new Coordinate(courier.getLatitude(), courier.getLongitude() )
				, new Coordinate(lat, lng));
		courier.setTravelDistance(distance);
		return courier;
	}
	
}
