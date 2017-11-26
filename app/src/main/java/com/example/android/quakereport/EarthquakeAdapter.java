package com.example.android.quakereport;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class EarthquakeAdapter extends RecyclerView.Adapter<EarthquakeAdapter.EarthquakeViewHolder>{

   private List<Earthquake> mEarthquakeList;

    public EarthquakeAdapter(List<Earthquake> mEarthquakeList) {
        this.mEarthquakeList = mEarthquakeList;
    }

    public void setEarthquakeAdapterData(List<Earthquake> earthquakeAdapterData){
        mEarthquakeList.clear();
        mEarthquakeList.addAll(earthquakeAdapterData);
        notifyDataSetChanged();
    }
    @Override
    public EarthquakeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_earthquake,parent,false);
        return new EarthquakeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EarthquakeViewHolder holder, int position) {
     holder.textViewMagnitude.setText(String.valueOf(getItem(position).getMagnitude()));
     holder.textViewDate.setText(getItem(position).getDateTimestamp());
     holder.textViewLocation.setText(getItem(position).getLocation());
     holder.textViewTime.setText(getItem(position).getTimeTimestamp());
     holder.textViewSpeed.setText(getItem(position).getSpeed());
    }

    @Override
    public int getItemCount() {
        return mEarthquakeList.size();
    }

     class EarthquakeViewHolder extends RecyclerView.ViewHolder {

         TextView textViewLocation;
         TextView textViewMagnitude;
         TextView textViewDate;
         TextView textViewTime;
         TextView textViewSpeed;

         EarthquakeViewHolder(View itemView) {
            super(itemView);
            textViewMagnitude = itemView.findViewById(R.id.text_view_magnitude);
            textViewLocation = itemView.findViewById(R.id.text_view_location);
            textViewDate = itemView.findViewById(R.id.text_view_date);
            textViewTime = itemView.findViewById(R.id.text_view_time);
            textViewSpeed = itemView.findViewById(R.id.text_view_speed);
        }
    }

    private Earthquake getItem(int position){
        return mEarthquakeList.get(position);
    }

}
