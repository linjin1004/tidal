package com.tada.taiwantidal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.internal.widget.AdapterViewCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    JSONArray allPlaces = new JSONArray();
    ListView citiesListView ;
    ListView townsListView ;
    String[] cities;
    String[] towns;
    String[] tidalIds;
    String cityName;
    String townName;
    TidalIdChart tidalIdChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }

        try {
            tidalIdChart = new TidalIdChart();
            allPlaces = tidalIdChart.getAllPalces();
            cities = new String[allPlaces.length()];
            for(int i = 0; i < allPlaces.length(); i ++) {
                JSONObject place = allPlaces.getJSONObject(i);
                String cityName = place.getString("cityName");
                cities[i] = getString(getResources().getIdentifier(cityName, "string", getPackageName()));
            }
        } catch (Exception e) {
            Log.i("TaiwanTidal", "tidalIdChart.getAllPalces error:" + e.toString());
        }

        citiesListView = (ListView)findViewById(R.id.citiesList);
        ArrayAdapter<String> citiesAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, cities);
        citiesListView.setAdapter(citiesAdapter);

        townsListView = (ListView)findViewById(R.id.townsList);

        citiesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                cityName = cities[position];

                try {
                    JSONArray townsArray = new JSONArray();
                    townsArray = tidalIdChart.getTowns(position);
                    towns = new String[townsArray.length()];
                    tidalIds = new String[townsArray.length()];
                    for(int i = 0; i < townsArray.length(); i ++) {
                        JSONObject place = townsArray.getJSONObject(i);
                        String townName = place.getString("townName");
                        tidalIds[i] = place.getString("id");
                        towns[i] = getString(getResources().getIdentifier(townName, "string", getPackageName()));
                    }
                } catch (Exception e) {
                    Log.i("TaiwanTidal", "tidalIdChart.getAllPalces error:" + e.toString());
                }
                townName = "";
                ArrayAdapter<String> townsAdapter = new ArrayAdapter<String>(MainActivity.this,
                        android.R.layout.simple_list_item_1, android.R.id.text1, towns);
                townsListView.setAdapter(townsAdapter);
                townsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view,
                                            int position, long id) {
                        townName = towns[position];
                        getTidalInfo(tidalIds[position]);
                    }
                });
            }
        });

    }

    public void getTidalInfo(String tidalId){
        //Toast.makeText(getApplicationContext(), cityName + " " + townName + " " + tidalId, Toast.LENGTH_LONG)
        //        .show();
        Intent mIntent = new Intent(this, TidalActivity.class);
        mIntent.putExtra("tidalId", tidalId);
        startActivity(mIntent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    /*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/

}
