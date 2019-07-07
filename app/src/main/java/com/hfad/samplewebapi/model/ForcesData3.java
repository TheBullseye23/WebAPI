package com.hfad.samplewebapi.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ForcesData3 {

    @SerializedName("description")
    @Expose
    private Object description;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("engagement_methods")
    @Expose
    private List<ForcesData2> engagementMethods = null;
    @SerializedName("telephone")
    @Expose
    private String telephone;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<ForcesData2> getEngagementMethods() {
        return engagementMethods;
    }

    public void setEngagementMethods(List<ForcesData2> engagementMethods) {
        this.engagementMethods = engagementMethods;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
