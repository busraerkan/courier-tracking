package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.Store;

public class StoreUtil {
	public static Set<Store> getStores() throws JsonParseException, JsonMappingException, IOException {
		// read stores
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<Set<Store>> typeReference = new TypeReference<Set<Store>>(){};
		InputStream inputStream = TypeReference.class.getResourceAsStream("/json/stores.json");
		Set<Store> stores = mapper.readValue(inputStream,typeReference);
		return stores;
		
	}
}
