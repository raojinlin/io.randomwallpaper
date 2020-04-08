package io.randomwallpaper.provider;

public class GnomeBuildInWrapperProviderFactory implements WrapperProviderFactory {
    public Provider instance() {
        return new GnomeBuildInWrapperProvider();
    }
}
