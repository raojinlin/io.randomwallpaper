package io.randomwallpaper.provider;

public class GnomeBuildInWallpaperProviderFactory implements WallpaperProviderFactory {
    public Provider instance() {
        return new GnomeBuildInWallpaperProvider();
    }
}
