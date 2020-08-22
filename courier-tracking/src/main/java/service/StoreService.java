package service;

import java.io.IOException;
import java.io.Serializable;
import java.util.Set;

import org.springframework.stereotype.Service;

import model.Store;
import util.StoreUtil;

@Service
public class StoreService implements IStoreService, Serializable{
	private static final long serialVersionUID = 7336612937314907353L;
	Set<Store> stores;
	
	private static volatile StoreService storeService;

    private StoreService() {
    	try {
			stores = StoreUtil.getStores();
		} catch (IOException e) {
			throw new IllegalArgumentException("Please check your stores.json file!");
		}
    }

    public static StoreService getStoreService() {
        if (storeService == null) {
            synchronized (StoreService.class) {
                if (storeService == null) {
                	storeService = new StoreService();
                }
            }
        }
        return storeService;
    }
	
	@Override
	public Store getStore(String name) {
		if(stores != null) {
			return stores.stream().filter(item -> item.getName().equals(name))
					.findFirst().orElse(null);
		}	
		return null;
	}
	
	@Override
	public Set<Store> getAllStores() {
		return stores;
	}
}
