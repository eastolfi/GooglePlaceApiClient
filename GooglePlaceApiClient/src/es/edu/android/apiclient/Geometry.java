package es.edu.android.apiclient;

public class Geometry {
	private Location location;
	private Viewport viewport;
	
	public Location getLocation() {
		return location;
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}
	
	public Viewport getViewport() {
		return viewport;
	}

	public void setViewport(Viewport viewport) {
		this.viewport = viewport;
	}
	
	public class Viewport {
		private Location northeast;
		private Location southwest;
		
		public Location getNortheast() {
			return northeast;
		}
		public void setNortheast(Location northeast) {
			this.northeast = northeast;
		}
		public Location getSouthwest() {
			return southwest;
		}
		public void setSouthwest(Location southwest) {
			this.southwest = southwest;
		}
	}

}
