package io.randomwallpaper.provider;

import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

import com.google.gson.*;
import io.randomwallpaper.UnknownWallpaperQualityException;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import io.randomwallpaper.model.UnSplashModel;
import io.randomwallpaper.model.WallpaperModel;



public class UnSplashWallpaperProvider implements Provider {
    private Random random = new Random();
    private int page = 0;
    private static final String[] qualitys = new String[]{"full", "raw", "regular", "small", "thumb"};
    private String quality = "raw";

    public UnSplashWallpaperProvider() {}

    void setNextPage() {
        page = random.nextInt(1000);
    }

    public void setQuantity(String quality) throws UnknownWallpaperQualityException {
        for (String q: qualitys) {
            if (quality.equals(q)) {
                this.quality = quality;
                return;
            }
        }

        throw new UnknownWallpaperQualityException("Unknown quality: '" + quality + "'");
    }

    public static String[] getQuality() {
        return qualitys;
    }

    String getUrl() {
        return "https://unsplash.com/napi/landing_pages/backgrounds/desktop?per_page=1&page=" + page;
    }

    WallpaperModel getWrapperModel(UnSplashModel unSplashModel) {
        String url = unSplashModel.photos.get(0).urls.raw;
        if (quality.equals("full")) {
            url = unSplashModel.photos.get(0).urls.full;
        } else if (quality.equals("regular")) {
            url = unSplashModel.photos.get(0).urls.regular;
        } else if (quality.equals("small")) {
            url = unSplashModel.photos.get(0).urls.small;
        }

        WallpaperModel model = new WallpaperModel(url, unSplashModel.photos.get(0).id);

        model.setHeight(unSplashModel.photos.get(0).height);
        model.setWidth(unSplashModel.photos.get(0).width);
        model.setRefer(getUrl());

        return model;
    }

    public WallpaperModel getWallpaper() {
        setNextPage();
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(getUrl());
        httpGet.setHeader("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.79 Safari/537.36");
        httpGet.setHeader("referer", "https://unsplash.com/backgrounds/desktop/4k");


        try {
            HttpResponse response = defaultHttpClient.execute(httpGet);
            Gson gson = new Gson();
            InputStreamReader inputStreamReader = new InputStreamReader(response.getEntity().getContent());
            UnSplashModel unSplashModel = gson.fromJson(inputStreamReader, UnSplashModel.class);
            return getWrapperModel(unSplashModel);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        return new WallpaperModel();
    }
}
