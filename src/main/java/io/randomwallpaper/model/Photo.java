package io.randomwallpaper.model;

import com.google.gson.annotations.SerializedName;

public class Photo {
    public String id = "";
    @SerializedName("created_at")
    public String createdAt = "";
    @SerializedName("updated_at")
    public String updatedAt = "";
    public int width;
    public int height;
    public String color;
    public String description;
    public Urls urls;
}
