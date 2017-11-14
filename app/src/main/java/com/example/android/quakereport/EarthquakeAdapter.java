package com.example.android.quakereport;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class EarthquakeAdapter extends RecyclerView.Adapter<EarthquakeAdapter.EarthquakeViewHolder>{

    List<Earthquake> mEarthquakeList;

    public EarthquakeAdapter(List<Earthquake> mEarthquakeList) {
        this.mEarthquakeList = mEarthquakeList;
    }

    @Override
    public EarthquakeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_earthquake,parent,false);
        return new EarthquakeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EarthquakeViewHolder holder, int position) {
     holder.textViewMagnitude.setText(getItem(position).getMagnitude());
     holder.textViewDate.setText(getItem(position).getDateTimestamp()+"");
     holder.textViewLocation.setText(getItem(position).getLocation());
    }

    @Override
    public int getItemCount() {
        return mEarthquakeList.size();
    }

    public class EarthquakeViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewLocation;
        public TextView textViewMagnitude;
        public TextView textViewDate;

        public EarthquakeViewHolder(View itemView) {
            super(itemView);
            textViewMagnitude = itemView.findViewById(R.id.text_view_magnitude);
            textViewLocation = itemView.findViewById(R.id.text_view_location);
            textViewDate = itemView.findViewById(R.id.text_view_date);
        }
    }

    private Earthquake getItem(int position){
        return mEarthquakeList.get(position);
    }
}
