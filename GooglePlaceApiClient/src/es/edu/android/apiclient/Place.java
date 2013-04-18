package es.edu.android.apiclient;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class Place {
	private String id;
	private String icon;
	private String name;
	private String vicinity;
	private String reference;
	private ArrayList<String> types;
	private double rating;
	private JSONObject geometry;
	private JSONArray photos;
	private String html_attributions;
	private int price_level;
	private boolean open_now;
	
	
	/************ GETTERS & SETTERS *************/
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the icon
	 */
	public String getIcon() {
		return icon;
	}
	/**
	 * @param icon the icon to set
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the vicinity
	 */
	public String getVicinity() {
		return vicinity;
	}
	/**
	 * @param vicinity the vicinity to set
	 */
	public void setVicinity(String vicinity) {
		this.vicinity = vicinity;
	}
	/**
	 * @return the reference
	 */
	public String getReference() {
		return reference;
	}
	/**
	 * @param reference the reference to set
	 */
	public void setReference(String reference) {
		this.reference = reference;
	}
	/**
	 * @return the types
	 */
	public ArrayList<String> getTypes() {
		return types;
	}
	/**
	 * @param types the types to set
	 */
	public void setTypes(ArrayList<String> types) {
		this.types = types;
	}
	/**
	 * @return the rating
	 */
	public double getRating() {
		return rating;
	}
	/**
	 * @param rating the rating to set
	 */
	public void setRating(double rating) {
		this.rating = rating;
	}
	/**
	 * @return the geometry
	 */
	public JSONObject getGeometry() {
		return geometry;
	}
	/**
	 * @param geometry the geometry to set
	 */
	public void setGeometry(JSONObject geometry) {
		this.geometry = geometry;
	}
	/**
	 * @return the photos
	 */
	public JSONArray getPhotos() {
		return photos;
	}
	/**
	 * @param photos the photos to set
	 */
	public void setPhotos(JSONArray photos) {
		this.photos = photos;
	}
	public String getHtml_attributions() {
		return html_attributions;
	}
	public void setHtml_attributions(String html_attributions) {
		this.html_attributions = html_attributions;
	}
	public int getPrice_level() {
		return price_level;
	}
	public void setPrice_level(int price_level) {
		this.price_level = price_level;
	}
	public boolean isOpen_now() {
		return open_now;
	}
	public void setOpen_now(boolean open_now) {
		this.open_now = open_now;
	}
}
