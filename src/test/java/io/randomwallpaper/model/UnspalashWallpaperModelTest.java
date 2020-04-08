package io.randomwallpaper.model;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class UnspalashWallpaperModelTest {
    @Test
    public void JSONToModel() throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("src/main/resources/unsplash.com.response.json");
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        Gson gson = new Gson();
        UnSplashModel unSplashModel = gson.fromJson(inputStreamReader, UnSplashModel.class);
        Assert.assertNotEquals(0, unSplashModel.photos.size());
        Assert.assertEquals(unSplashModel.subtitle, "Download free desktop background images");
        Assert.assertEquals(unSplashModel.title, "Desktop Backgrounds");
        Assert.assertEquals(1, unSplashModel.photos.size());
        Assert.assertEquals("https://images.unsplash.com/photo-1462331321792-cc44368b8894?ixlib=rb-1.2.1&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max", unSplashModel.photos.get(0).urls.regular);
        Assert.assertNotEquals("", unSplashModel.photos.get(0).urls.raw);
        Assert.assertNotEquals("", unSplashModel.photos.get(0).urls.full);
        Assert.assertNotEquals("", unSplashModel.photos.get(0).urls.small);
        Assert.assertNotEquals("", unSplashModel.photos.get(0).urls.thumb);
        Assert.assertEquals("2020-04-07T01:07:30-04:00", unSplashModel.photos.get(0).updatedAt);
        Assert.assertEquals(unSplashModel.photos.get(0).createdAt, "2016-05-03T23:09:23-04:00");
    }
}
