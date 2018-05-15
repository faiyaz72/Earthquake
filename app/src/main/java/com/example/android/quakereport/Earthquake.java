package com.example.android.quakereport;

class Earthquake {

    private Double magnitude;

    private String name;

    private String date;

    private long date1;

    public Earthquake(double magnitude, String name, String date) {

        this.magnitude = magnitude;
        this.name = name;
        this.date = date;
    }

    public Earthquake(double magnitude, String name, long date1) {

        this.magnitude = magnitude;
        this.name = name;
        this.date1 = date1;
    }

    public String getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public Double getMagnitude() {
        return magnitude;
    }

    public long getDate1() {
        return date1;
    }
}
