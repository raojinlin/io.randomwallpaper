package io.randomwallpaper.provider;

import io.randomwallpaper.model.WrapperModel;
import org.junit.Assert;
import org.junit.Test;

public class GnomeBuildInWrapperProviderTest {
    @Test
    public void getWrapperTest() {
        GnomeBuildInWrapperProviderFactory factory = new GnomeBuildInWrapperProviderFactory();
        WrapperModel model = factory.instance().getWrapper();

        Assert.assertNotEquals("", model.getUrl());
        Assert.assertNotEquals(false, model.getUrl().startsWith("file://"));
    }
}
