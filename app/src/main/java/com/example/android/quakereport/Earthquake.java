package com.example.android.quakereport;

public class Earthquake {
   private String location;
   private String dateTimestamp;
   private int magnitude;

    public Earthquake(String location, String dateTimestamp, int magnitude) {
        this.location = location;
        this.dateTimestamp = dateTimestamp;
        this.magnitude = magnitude;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDateTimestamp() {
        return dateTimestamp;
    }

    public void setDateTimestamp(String dateTimestamp) {
        this.dateTimestamp = dateTimestamp;
    }

    public int getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(int magnitude) {
        this.magnitude = magnitude;
    }
}
