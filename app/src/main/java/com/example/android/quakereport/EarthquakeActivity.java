
package com.example.android.quakereport;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.net.InetAddress;
import java.util.ArrayList;

public class EarthquakeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);

            EarthquakeListFragment earthquakeListFragment = EarthquakeListFragment.newInstance();
            getSupportFragmentManager().beginTransaction().replace(R.id.container, earthquakeListFragment).addToBackStack(null).commit();

    }
}
