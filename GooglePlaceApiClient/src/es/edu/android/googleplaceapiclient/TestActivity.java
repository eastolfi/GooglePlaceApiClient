package es.edu.android.googleplaceapiclient;

import es.edu.android.apiclient.Location;
import es.edu.android.apiclient.PlaceSearch;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class TestActivity extends Activity {
	String API_KEY = "AIzaSyDxMJ-QyvCXFtRmhVx7BZyqxZboJ1EDxNU";
	Button bt;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test);
		
		bt = (Button) findViewById(R.id.button1);
		bt.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				new AsyncTask<String, Void, String>() {

					@Override
					protected String doInBackground(String... arg0) {
						PlaceSearch ps = new PlaceSearch(API_KEY, PlaceSearch.FORMAT_JSON);
						Location loc = new Location();
						loc.latitude = 40.463666;loc.longitude = -3.635402;
						ps.searchPlacesByLocation(loc, 500, false);
						return null;
					}
				}.execute();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.test, menu);
		return true;
	}

}
