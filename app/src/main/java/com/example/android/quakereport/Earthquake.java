package com.example.android.quakereport;

public class Earthquake {
   private String location;
   private String dateTimestamp;
   private int magnitude;
   private String timeTimestamp;
   private String speed;

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getTimeTimestamp() {
        return timeTimestamp;
    }

    public void setTimeTimestamp(String timeTimestamp) {
        this.timeTimestamp = timeTimestamp;
    }

    public Earthquake(String location, String dateTimestamp, int magnitude, String timeTimestamp , String speed) {
        this.location = location;
        this.dateTimestamp = dateTimestamp;
        this.magnitude = magnitude;
        this.timeTimestamp = timeTimestamp;
        this.speed = speed;
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
