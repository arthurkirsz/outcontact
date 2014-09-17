package fr.esiea.outcontact.dao;

import java.util.HashMap;

import com.google.appengine.labs.repackaged.org.json.JSONObject;

public class JsonManager {
	
	public static JSONObject hashMapToJson(HashMap<String, String> map) {
		return new JSONObject(map);
	}

}
