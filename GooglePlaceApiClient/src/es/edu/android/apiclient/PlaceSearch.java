package es.edu.android.apiclient;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class PlaceSearch {
	public final static String FORMAT_JSON = "json";
	public final static String FORMAT_XML = "xml";
	private final static String uriBase = "https://maps.googleapis.com/maps/api/place/";
	private final static String searchPlace = "search";
	private final static String searchPlaceByName = "textsearch";
	private final static String searchPlaceDetail = "details";
	String API_KEY, format;
	
	public PlaceSearch(String userKey, String format) {
		this.API_KEY = userKey;
		this.format = format;
	}
	
	public ArrayList<Place> searchPlacesByLocation(Location location, int radius, boolean sensor) {
		String uri = uriBase + searchPlace + "/" + format + "?";
		uri += "location=" + location.latitude + "," + location.longitude + "&";
		uri += "radius=" + radius + "&";
		uri += "sensor=" + sensor + "&";
		uri += "key=" + API_KEY;
		
		ArrayList<Place> places = performSearch(uri);
		
		return places;
	}
	
	public void searchPlacesByName() {
		String uri = uriBase + searchPlaceByName + "/" + format + "?";
		
		performSearch(uri);	//TODO
	}
	
	public void searchPlaceDetail(String reference, boolean sensor) {
		String uri = uriBase + searchPlaceDetail + "/" + format + "?";
		uri += "reference=" + reference + "&";
		uri += "sensor=" + sensor + "&";
		uri += "key=" + API_KEY;
		
		performSearch(uri);	//TODO
	}
	
	private ArrayList<Place> performSearch(String uri) {
		try {
			HttpClient client = new DefaultHttpClient();
			HttpGet get = new HttpGet(uri);
			HttpResponse response = client.execute(get);
			String entity = EntityUtils.toString(response.getEntity());
			ArrayList<Place> places = toJson(entity);
			
			return places;
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private ArrayList<Place> toJson(String entity) {
		ArrayList<Place> places = new ArrayList<Place>();
		try {
			Log.d("toJson", entity);
			JSONObject jObject = new JSONObject(entity);
			JSONArray jArray = jObject.getJSONArray("results");
	
			for (int i=0; i<jArray.length(); i++) {
				JSONObject json = (JSONObject) jArray.get(i);
				Place place = PlaceBuilder.buildFromJson(new Place(), json);
				places.add(place);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return places;
	}
	
}
