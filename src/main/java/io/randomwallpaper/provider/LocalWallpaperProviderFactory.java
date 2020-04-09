package io.randomwallpaper.provider;

public class LocalWallpaperProviderFactory implements WallpaperProviderFactory {
    public LocalWallpaperProvider instance() {
        return new LocalWallpaperProvider();
    }
}
