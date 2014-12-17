package com.tada.taiwantidal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;


public class TidalActivity extends ActionBarActivity {

    String tidalId;
    String cityName;
    String townName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tidal);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        WebView webView = (WebView)findViewById(R.id.webView);
        webView.clearCache(true);
        WebSettings websettings = webView.getSettings();
        websettings.setSupportZoom(false);
        websettings.setBuiltInZoomControls(false);
        websettings.setJavaScriptEnabled(true);
        websettings.setAllowFileAccess(true);

        tidalId = getIntent().getExtras().getString("tidalId");
        cityName = getIntent().getExtras().getString("cityName");
        townName = getIntent().getExtras().getString("townName");

        webView.loadUrl("http://www.cwb.gov.tw/V7e/forecast/fishery/Tidal30days/" +  tidalId + ".htm");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tidal, menu);
        if(((TidalUtil)getApplication()).searchFav(tidalId)){
            MenuItem fav =menu.findItem(R.id.action_fav);
            fav.setIcon(R.drawable.ic_favorite_grey);
        }
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
        }else if(id == R.id.action_fav){
            if(((TidalUtil)getApplication()).searchFav(tidalId)) {
                if(((TidalUtil)getApplication()).removeFav(tidalId)) {
                    item.setIcon(R.drawable.ic_favorite_outline_grey);
                }
            }else{
                if(((TidalUtil)getApplication()).addFav(tidalId, townName, cityName)) {
                   item.setIcon(R.drawable.ic_favorite_grey);
                }
            }
            return true;
        }else if(id == android.R.id.home){
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
