package com.example.android.quakereport;



import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class EarthquakeListFragment extends Fragment implements LoaderManager.LoaderCallbacks<List<Earthquake>> {

    List<Earthquake> mEarthquakeList = new ArrayList<>();
    RecyclerView mRecyclerView;
    EarthquakeAdapter mEarthquakeAdapter;

    private static final String USGS_REQUEST_URL =
            "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&orderby=time&minmag=6&limit=10";

    public static EarthquakeListFragment newInstance() {
        return new EarthquakeListFragment();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_earthquake_list, container, false);


        mRecyclerView = view.findViewById(R.id.recycler_earthquake);

        mEarthquakeAdapter = new EarthquakeAdapter(mEarthquakeList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mEarthquakeAdapter);
        Log.d("Loader","initLoader");
        getActivity().getSupportLoaderManager().initLoader(0,null,this);
        return view;
    }


    @Override
    public Loader<List<Earthquake>> onCreateLoader(int id, Bundle args) {
        Log.d("Loader","onCreateLoader");
        return new EarthquakeLoader(getContext());
    }

    @Override
    public void onLoadFinished(Loader<List<Earthquake>> loader, List<Earthquake> data) {
        Log.d("Loader","onLoadFinished");
        mEarthquakeAdapter.setEarthquakeAdapterData(data);
    }

    @Override
    public void onLoaderReset(Loader<List<Earthquake>> loader) {
        Log.d("Loader","onLoaderReset");
        mEarthquakeAdapter.setEarthquakeAdapterData(new ArrayList<Earthquake>());
    }
}



