package service;

import java.util.Set;

import model.Store;

public interface IStoreService{
	public Store getStore(String name);
	
	public Set<Store> getAllStores();
}
