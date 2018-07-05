package com.example.infomap;

public class CourseModel {
    String title;
    double distance,fee,lat,lon;
    String address;


    public CourseModel() {
    }

    public CourseModel(String title, double distance, double fee, double lat, double lon, String address) {
        this.title = title;
        this.distance = distance;
        this.fee = fee;
        this.lat = lat;
        this.lon = lon;
        this.address = address;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
