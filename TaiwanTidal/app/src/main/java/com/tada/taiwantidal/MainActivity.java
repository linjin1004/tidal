package com.tada.taiwantidal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.internal.widget.AdapterViewCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Gravity;
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

    private DrawerLayout drawer;

    JSONArray allPlaces = new JSONArray();
    //ListView citiesListView ;
    //ListView townsListView ;
    String[] cities;
    String[] towns;
    String[] tidalIds;
    //String cityName;
    //String townName;
    TidalIdChart tidalIdChart;

    MyAdapter townAdapter;
    RecyclerView townsRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            toolbar.setNavigationIcon(R.drawable.ic_list_grey);
        }
        drawer = (DrawerLayout) findViewById(R.id.drawer);
        //drawer.setDrawerShadow(R.drawable.drawer_shadow, Gravity.START);

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

        RecyclerView citiesRecyclerView = (RecyclerView) findViewById(R.id.citiesList);
        citiesRecyclerView.setHasFixedSize(true);
        citiesRecyclerView.addItemDecoration(new DividerItemDecoration(MainActivity.this, DividerItemDecoration.VERTICAL_LIST));
        // use a linear layout manager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        citiesRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        MyAdapter citiesAdapter = new MyAdapter(cities);
        citiesRecyclerView.setAdapter(citiesAdapter);


        citiesRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(), new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        try {
                            JSONArray townsArray = tidalIdChart.getTowns(position);
                            towns = new String[townsArray.length()];
                            tidalIds = new String[townsArray.length()];
                            for(int i = 0; i < townsArray.length(); i ++) {
                                JSONObject place = townsArray.getJSONObject(i);
                                String townName = place.getString("townName");
                                tidalIds[i] = place.getString("id");
                                towns[i] = getString(getResources().getIdentifier(townName, "string", getPackageName()));
                                townAdapter.resetData(towns);
                                townAdapter.notifyDataSetChanged();
                            }
                        } catch (Exception e) {
                            Log.i("TaiwanTidal", "tidalIdChart.getTowns error:" + e.toString());
                        }
                    }
                })
        );


        towns = new String[0];
        // town recyclerView
        townsRecyclerView = (RecyclerView) findViewById(R.id.townsList);
        townsRecyclerView.setHasFixedSize(true);
        townsRecyclerView.addItemDecoration(new DividerItemDecoration(MainActivity.this, DividerItemDecoration.VERTICAL_LIST));
        LinearLayoutManager townsLayoutManager = new LinearLayoutManager(this);
        townsRecyclerView.setLayoutManager(townsLayoutManager);

        // specify an adapter (see also next example)
        townAdapter = new MyAdapter(towns);
        townsRecyclerView.setAdapter(townAdapter);
        townsRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(), new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        getTidalInfo(tidalIds[position]);
                    }
                })
        );

        /*
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
        */
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }else if(id == android.R.id.home){
            drawer.openDrawer(Gravity.START);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
        private String[] mDataset;

        // Provide a reference to the views for each data item
        // Complex data items may need more than one view per item, and
        // you provide access to all the views for a data item in a view holder
        public class ViewHolder extends RecyclerView.ViewHolder {
            // each data item is just a string in this case
            public TextView mTextView;
            public ViewHolder(View v) {
                super(v);
                mTextView = (TextView)v.findViewById(R.id.textView);
            }
        }

        // Provide a suitable constructor (depends on the kind of dataset)
        public MyAdapter(String[] myDataset) {
            mDataset = myDataset;
        }

        public void resetData(String[] myDataset){
            mDataset = myDataset;
        }

        // Create new views (invoked by the layout manager)
        @Override
        public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                       int viewType) {
            // create a new view
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.row_listview, parent, false);
            // set the view's size, margins, paddings and layout parameters
            ViewHolder vh = new MyAdapter.ViewHolder(v);
            return vh;
        }

        // Replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            // - get element from your dataset at this position
            // - replace the contents of the view with that element
            holder.mTextView.setText(mDataset[position]);

        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return mDataset.length;
        }
    }

    public static class RecyclerItemClickListener implements RecyclerView.OnItemTouchListener {
        private OnItemClickListener mListener;

        public interface OnItemClickListener {
            public void onItemClick(View view, int position);
        }

        GestureDetector mGestureDetector;

        public RecyclerItemClickListener(Context context, OnItemClickListener listener) {
            mListener = listener;
            mGestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }
            });
        }

        @Override public boolean onInterceptTouchEvent(RecyclerView view, MotionEvent e) {
            View childView = view.findChildViewUnder(e.getX(), e.getY());
            if (childView != null && mListener != null && mGestureDetector.onTouchEvent(e)) {
                mListener.onItemClick(childView, view.getChildPosition(childView));
            }
            return false;
        }

        @Override public void onTouchEvent(RecyclerView view, MotionEvent motionEvent) { }
    }
}
