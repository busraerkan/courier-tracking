package service;

import java.util.Set;

import model.Courier;

public interface ICourierService {
	
	public Courier getCourier(Long id);
	
	public Set<Courier> getAll();

	public double getTotalDistance(Long id);
	
	public Courier travel(Long id, double lat, double lng);
}
