package es.edu.android.googleplaceapiclient;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import es.edu.gplaceapiclient.Location;
import es.edu.gplaceapiclient.Place;
import es.edu.gplaceapiclient.PlaceSearch;

public class TestActivity extends Activity {
	String API_KEY = "AIzaSyDxMJ-QyvCXFtRmhVx7BZyqxZboJ1EDxNU";
	Button btSend;
	EditText txtSearch;
	Context ctx;
	ListView lst;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test);
		
		ctx = this;
		
		txtSearch = (EditText) findViewById(R.id.txtSearch);
		
		lst = (ListView) findViewById(R.id.lstResults);
		
		btSend = (Button) findViewById(R.id.btSend);
		btSend.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				if (txtSearch.getText().toString().isEmpty()) {
					txtSearch.setError("Introduzca algo para buscar");
				}
				else {
					new AsyncTask<String, Void, ArrayList<String>>() { 
					ProgressDialog dialog;
						@Override
						protected void onPreExecute() {
							dialog = new ProgressDialog(ctx);
							String msg = "Obteniendo la lista de sitios cercanos a '" +
										txtSearch.getText().toString() + "' ...";
							dialog.setMessage(msg);
							dialog.setIndeterminate(true);
							dialog.show();
						}
						
						@Override
						protected ArrayList<String> doInBackground(String... arg0) {
							PlaceSearch search = new PlaceSearch(API_KEY, PlaceSearch.FORMAT_JSON);
							
							String query = txtSearch.getText().toString();
							query = query.replace(" ", "+");
							
							ArrayList<Place> places = search.searchPlacesByName(query, false);
							
							ArrayList<String> placeNames = new ArrayList<String>();
							for (Place place : places) {
								placeNames.add(place.getName());
							}
							
							return placeNames;
						}
						
						@Override
						protected void onPostExecute(ArrayList<String> result) {
							ArrayAdapter<String> adapter = new ArrayAdapter<String>(ctx, android.R.layout.simple_list_item_1, result);
							lst.setAdapter(adapter);
							dialog.dismiss();
						}
					}.execute();
				}
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
