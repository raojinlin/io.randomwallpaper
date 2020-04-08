package io.randomwallpaper.model;

public class WrapperModel {
    private String url = "";
    private String id = "";
    private int width = 0;
    private int height = 0;
    private String refer = "";

    public WrapperModel() {}

    public WrapperModel(String url, String id) {
        this.url = url;
        this.id = id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getRefer() {
        return refer;
    }

    public void setRefer(String refer) {
        this.refer = refer;
    }
}
