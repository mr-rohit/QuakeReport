package com.example.android.quakereport;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class EarthquakeListFragment extends Fragment{

    List<Earthquake> mEarthquakeList;

    public static EarthquakeListFragment newInstance() {

        Bundle args = new Bundle();

        EarthquakeListFragment fragment = new EarthquakeListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_earthquake_list,container,false);

        EarthquakeAdapter earthquakeAdapter = new EarthquakeAdapter(mEarthquakeList);

        RecyclerView recyclerView =  view.findViewById(R.id.recycler_earthquake);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(earthquakeAdapter);

        return view;
    }
}
