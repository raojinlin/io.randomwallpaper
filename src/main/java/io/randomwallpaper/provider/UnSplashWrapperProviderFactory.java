package io.randomwallpaper.provider;

public class UnSplashWrapperProviderFactory implements WrapperProviderFactory {
    public UnSplashWrapperProvider instance() {
        return new UnSplashWrapperProvider();
    }
}
