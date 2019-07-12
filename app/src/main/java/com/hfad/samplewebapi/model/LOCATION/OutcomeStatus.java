package com.hfad.samplewebapi.model.LOCATION;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OutcomeStatus {

    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("date")
    @Expose
    private String date;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
