package io.randomwallpaper.provider;

import io.randomwallpaper.model.WallpaperModel;
import org.junit.Assert;
import org.junit.Test;

public class UnSpalashWallpaperProviderTest {
    @Test
    public void getWrapperTest() {
        UnSplashWallpaperProviderFactory factory = new UnSplashWallpaperProviderFactory();
        WallpaperModel model = factory.instance().getWallpaper();

        Assert.assertNotEquals("", model.getUrl());
        Assert.assertNotEquals("", model.getId());
    }
}
