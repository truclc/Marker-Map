package com.example.infomap;

public class TeacherModel {
    double distance,fee,lat,lon,rating;
    String address,name,subject;

    public TeacherModel() {
    }

    public TeacherModel(double distance, double fee, double lat, double lon,
                        double rating, String address, String name, String subject) {
        this.distance = distance;
        this.fee = fee;
        this.lat = lat;
        this.lon = lon;
        this.rating = rating;
        this.address = address;
        this.name = name;
        this.subject = subject;
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

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
