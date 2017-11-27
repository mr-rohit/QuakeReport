package com.example.android.quakereport;


import android.content.Context;
import android.net.ConnectivityManager;
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
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class EarthquakeListFragment extends Fragment implements LoaderManager.LoaderCallbacks<List<Earthquake>> {
    private TextView mTextViewNoData;
    private ProgressBar mProgressBar;
    List<Earthquake> mEarthquakeList = new ArrayList<>();
    RecyclerView mRecyclerView;
    EarthquakeAdapter mEarthquakeAdapter;

    public static EarthquakeListFragment newInstance() {
        return new EarthquakeListFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_earthquake_list, container, false);
        mTextViewNoData = view.findViewById(R.id.text_view_no_data);
        mProgressBar = view.findViewById(R.id.progress_bar);
        mRecyclerView = view.findViewById(R.id.recycler_earthquake);

        mEarthquakeAdapter = new EarthquakeAdapter(mEarthquakeList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mEarthquakeAdapter);
        Log.d("Loader", "initLoader");
        if(isNetworkConnected()){
            getActivity().getSupportLoaderManager().initLoader(0, null, this);
        }else
        {
            mProgressBar.setVisibility(View.GONE);
            mTextViewNoData.setVisibility(View.VISIBLE);
            mTextViewNoData.setText("No Internet available");
        }

        return view;
    }


    @Override
    public Loader<List<Earthquake>> onCreateLoader(int id, Bundle args) {
        Log.d("Loader", "onCreateLoader");
        return new EarthquakeLoader(getContext());
    }

    @Override
    public void onLoadFinished(Loader<List<Earthquake>> loader, List<Earthquake> data) {
        Log.d("Loader", "onLoadFinished");
        if (data != null && data.size() <= 0){
            mTextViewNoData.setVisibility(View.VISIBLE);
        }
        mProgressBar.setVisibility(View.GONE);
        mEarthquakeAdapter.setEarthquakeAdapterData(data);
    }

    @Override
    public void onLoaderReset(Loader<List<Earthquake>> loader) {
        Log.d("Loader", "onLoaderReset");
        mEarthquakeAdapter.setEarthquakeAdapterData(new ArrayList<Earthquake>());
    }
    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);

        return (cm != null ? cm.getActiveNetworkInfo() : null) != null;
    }
}



