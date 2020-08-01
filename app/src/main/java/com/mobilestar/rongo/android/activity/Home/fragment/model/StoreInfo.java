package com.mobilestar.rongo.android.activity.Home.fragment.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class StoreInfo {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("isFollow")
    @Expose
    private boolean isFollow;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("nTotalFollows")
    @Expose
    private Integer numFollows;
    @SerializedName("background")
    @Expose
    private String background;
    @SerializedName("icon")
    @Expose
    private String thumbnail;
    @SerializedName("explantion")
    @Expose
    private ArrayList<String> explantions;
    @SerializedName("evaluation")
    @Expose
    private ArrayList<StoreEvaluation> evaluations;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getNumFollows() {
        return numFollows;
    }

    public void setNumFollows(Integer numFollows) {
        this.numFollows = numFollows;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public Boolean getFollow() {
        return isFollow;
    }

    public void setFollow(Boolean follow) {
        isFollow = follow;
    }

    public ArrayList<StoreEvaluation> getEvaluations() {
        return evaluations;
    }

    public void setEvaluations(ArrayList<StoreEvaluation> evaluations) {
        this.evaluations = evaluations;
    }

    public ArrayList<String> getExplantions() {
        return explantions;
    }

    public void setExplantions(ArrayList<String> explantions) {
        this.explantions = explantions;
    }
}
