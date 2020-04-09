package io.randomwallpaper.provider;

import io.randomwallpaper.model.WallpaperModel;
import org.junit.Assert;
import org.junit.Test;

public class LocalWallpaperProviderTest {
    @Test
    public void getWrapperTest() {
        LocalWallpaperProviderFactory factory = new LocalWallpaperProviderFactory();
        WallpaperModel model = factory.instance().getWallpaper();

        Assert.assertNotEquals("", model.getUrl());
        Assert.assertNotEquals(false, model.getUrl().startsWith("file://"));
    }
}
