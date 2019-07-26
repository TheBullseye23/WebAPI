package com.hfad.samplewebapi.model;

public class FavData {

    private String category;
    private String locationtype;
    private String month;
    private int favid;

    public FavData(String month, String locationtype, String category, Integer favid) {
        this.month=month;
        this.locationtype=locationtype;
        this.category=category;
        this.favid=favid;
    }


    public int getFavid() {
        return favid;
    }

    public void setFavid(int favid) {
        this.favid = favid;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLocationtype() {
        return locationtype;
    }

    public void setLocationtype(String locationtype) {
        this.locationtype = locationtype;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }
}
