package io.randomwallpaper.provider;

import io.randomwallpaper.model.WallpaperModel;
import org.junit.Assert;
import org.junit.Test;

public class GnomeBuildInWallpaperProviderTest {
    @Test
    public void getWrapperTest() {
        GnomeBuildInWallpaperProviderFactory factory = new GnomeBuildInWallpaperProviderFactory();
        WallpaperModel model = factory.instance().getWrapper();

        Assert.assertNotEquals("", model.getUrl());
        Assert.assertNotEquals(false, model.getUrl().startsWith("file://"));
    }
}
