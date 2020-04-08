package io.randomwallpaper.provider;

import io.randomwallpaper.model.WrapperModel;
import org.junit.Assert;
import org.junit.Test;

public class UnSpalashWrapperProviderTest {
    @Test
    public void getWrapperTest() {
        UnSplashWrapperProviderFactory factory = new UnSplashWrapperProviderFactory();
        WrapperModel model = factory.instance().getWrapper();

        Assert.assertNotEquals("", model.getUrl());
        Assert.assertNotEquals("", model.getId());
    }
}
