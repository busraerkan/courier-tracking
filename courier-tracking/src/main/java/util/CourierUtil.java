package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.Courier;

public class CourierUtil {
	public static Set<Courier> getCouriers() throws JsonParseException, JsonMappingException, IOException {
		// read couriers
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<Set<Courier>> typeReferenceCourier = new TypeReference<Set<Courier>>(){};
		InputStream inputStreamCourier = TypeReference.class.getResourceAsStream("/json/couriers.json");
		Set<Courier> couriers = mapper.readValue(inputStreamCourier,typeReferenceCourier);
		return couriers;
		
	}
}
