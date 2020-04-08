package io.randomwallpaper.model;


import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class UnSplashModel {
    public String title = "";
    public String subtitle = "";
    public String description = "";
    @SerializedName("meta_title")
    public String metaTitle = "";
    @SerializedName("meta_description")
    public String metaDescription = "";
    public List<Photo> photos = new ArrayList<Photo>();
}
