package com.example.android.quakereport;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class EarthquakeListFragment extends Fragment {

    List<Earthquake> mEarthquakeList = new ArrayList<>();

    public static EarthquakeListFragment newInstance() {

        Bundle args = new Bundle();

        EarthquakeListFragment fragment = new EarthquakeListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_earthquake_list, container, false);
//        mEarthquakeList.add(new Earthquake("Mumbai", "22 November 2017", 5));
//        mEarthquakeList.add(new Earthquake("Mumbai1", "22 November 2019", 6));
//        mEarthquakeList.add(new Earthquake("Mumbai2", "22 November 2018", 7));
//        mEarthquakeList.add(new Earthquake("Mumbai3", "22 November 2016", 8));
//        mEarthquakeList.add(new Earthquake("Mumbai4", "22 November 2014", 9));
//        mEarthquakeList.add(new Earthquake("Mumbai5", "22 November 2015", 2));
//        mEarthquakeList.add(new Earthquake("Mumbai6", "22 November 2016", 3));
        mEarthquakeList = QueryUtils.extractEarthquakes();
        EarthquakeAdapter earthquakeAdapter = new EarthquakeAdapter(mEarthquakeList);

        RecyclerView recyclerView = view.findViewById(R.id.recycler_earthquake);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(earthquakeAdapter);

        return view;
    }
}
