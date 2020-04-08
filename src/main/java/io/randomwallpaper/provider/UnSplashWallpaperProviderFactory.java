package io.randomwallpaper.provider;

public class UnSplashWallpaperProviderFactory implements WallpaperProviderFactory {
    public UnSplashWallpaperProvider instance() {
        return new UnSplashWallpaperProvider();
    }
}
