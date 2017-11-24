package com.example.android.quakereport;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class EarthquakeListFragment extends Fragment{

    List<Earthquake> mEarthquakeList = new ArrayList<>();

   // public TaskComplete taskComplete;


  /*  @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            taskComplete = (TaskComplete) context;
            Log.d("24Nov","TaskComplete" );
        }catch(ClassCastException e){
            Log.d("24Nov","Error: " + e.toString());
        }

    }*/


    /* public void setOnTaskComplete(TaskComplete onTaskComplete ){
        onTaskComplete = taskComplete;
    }*/


    private static final String USGS_REQUEST_URL =
            "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&orderby=time&minmag=6&limit=10";

    public static EarthquakeListFragment newInstance() {

        return new EarthquakeListFragment();
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_earthquake_list, container, false);



        new EarthquakeAsyncTask(getActivity(), new QuakeInterface() {
            @Override
            public void data(List<Earthquake> earthquakes) {

                if(earthquakes.size()>0){
                    mEarthquakeList = earthquakes;
                    EarthquakeAdapter earthquakeAdapter = new EarthquakeAdapter(mEarthquakeList);
                    RecyclerView recyclerView = view.findViewById(R.id.recycler_earthquake);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                    recyclerView.setAdapter(earthquakeAdapter);
                }

                for(Earthquake earthquake:earthquakes){
                    Log.d("24Nov","EarthQuake Details: " + earthquake.getLocation());
                }

            }
        }).execute(USGS_REQUEST_URL);


        return view;
    }


}



