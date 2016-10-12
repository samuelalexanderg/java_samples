package org.json.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Construct {
	public static void main(String[] args) throws Exception {
		// writeJSON();
		readJSON();
	}

	private static void readJSON() throws Exception {
        JSONParser parser = new JSONParser();
		JSONObject jsonObject = (JSONObject) parser.parse(new FileReader("/home/sam/tmp/place.json"));
        Iterator<String> keys = jsonObject.values().iterator();

        while( keys.hasNext() ) {
            String key = (String)keys.next();
            if ( jsonObject.get(key) instanceof JSONObject ) {
            	System.out.println("Key : " + key);
            	System.out.println("Value : " + jsonObject.get(key));
            }
        }

	}

	public static void writeJSON() {
		JSONObject beacon = new JSONObject();
		beacon.put("uuid", "xxxx-xxxx");
		beacon.put("majorId", 1234);
		beacon.put("minorId", 233);
		beacon.put("lat", 23.344);
		beacon.put("long", 23.344);
		beacon.put("type", "iBeacon");

		JSONObject event = new JSONObject();
		event.put("beacon", beacon);
		event.put("appId", "xxxx-xxxx");
		event.put("receiverId", "xxxx-xxxx");
		event.put("datetime", "09/22/2015 13:24");

		System.out.println(event);
	}
}
