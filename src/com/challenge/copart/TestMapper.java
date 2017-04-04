package com.challenge.copart;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestMapper {
	
	
	public static AuctionBean mapObject(String input) throws JsonParseException, JsonMappingException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
	    AuctionBean obj = mapper.readValue(input, new AuctionBean().getClass());
	    
	    return obj;
	}
	
}
