package es.edu.android.apiclient;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PlaceBuilder {

	
	public static Place buildFromJson(Place original, JSONObject source) {
		try {
			if (source.has("id"))
				original.setId(source.getString("id"));
			if (source.has("icon"))
				original.setIcon(source.getString("icon"));
			if (source.has("name"))
				original.setName(source.getString("name"));
			if (source.has("vicinity"))
				original.setVicinity(source.getString("vicinity"));
			if (source.has("reference"))
				original.setReference(source.getString("reference"));
			if (source.has("rating"))
				original.setRating(Double.parseDouble(source.getString("rating")));
			if (source.has("types")) {
				JSONArray types = (JSONArray)source.get("types");
				ArrayList<String> lst = new ArrayList<String>();
				for (int i=0; i<types.length(); i++) {
					lst.add(types.get(i).toString());
				}
				original.setTypes(lst);
			}
			if (source.has("geometry")) {
				
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return original;
	}
	
}
