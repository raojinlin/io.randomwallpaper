package io.randomwallpaper;

import junit.framework.AssertionFailedError;
import org.apache.commons.cli.ParseException;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class CommandTest {
    @Test
    public void sliceTest() {
        String[] s1 = Command.slice(new String[]{"-p", "local", "-h"}, 1, 2);
        String[] s2 = Command.slice(new String[]{"-p", "local", "-h"}, 1, 2);
        String[] s3 = Command.slice(new String[]{"-p", "local", "-h"}, 0, 1);
        String[] s4 = Command.slice(new String[]{"-p", "local", "-h"}, 0, 3);
        String[] s5 = Command.slice(new String[]{"-p", "unsplash", "-q", "raw"}, 0, 3);
        Assert.assertEquals(2, s1.length);
        Assert.assertEquals(2, s2.length);
        Assert.assertEquals(2, s3.length);
        Assert.assertEquals(3, s4.length);

        System.out.println(Arrays.toString(s1));
        System.out.println(Arrays.toString(s2));
        System.out.println(Arrays.toString(s3));
        System.out.println(Arrays.toString(s4));
    }

    @Test
    public void commandTest() throws ParseException, UnknownWallpaperQualityException, UnknownWallpaperProviderException {
        Assert.assertEquals(0, Command.execute(new String[]{"-h"}));
        try {
            Command.execute(new String[]{"-p", "xxx"});
            throw new AssertionFailedError("should throw exception 'UnknownWallpaper'");
        } catch (UnknownWallpaperProviderException e) {
            System.out.println("got exception");
            System.out.println(e.getMessage());
        }

        try {
            Command.execute(new String[]{"-p", "unsplash", "--quality", "xxx"});
            throw new AssertionFailedError("should throw exception 'UnknownWallpaperQualityException'");
        } catch (UnknownWallpaperQualityException e) {
            System.out.println(e.getMessage());
        }


        Assert.assertEquals(Command.execute(new String[]{"-p", "unsplash", "--quality", "raw"}), 0);
        Assert.assertEquals(Command.execute(new String[]{"-p", "local", "-d", "/home/raojinlin/.local/share/backgrounds"}), 0);
    }
}
