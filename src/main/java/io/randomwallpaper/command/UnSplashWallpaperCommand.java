package io.randomwallpaper.command;

import io.randomwallpaper.UnknownWallpaperQuantityException;
import io.randomwallpaper.provider.UnSplashWallpaperProvider;
import io.randomwallpaper.provider.UnSplashWallpaperProviderFactory;
import org.apache.commons.cli.*;

import java.util.Arrays;

public class UnSplashWallpaperCommand extends Command {
    public UnSplashWallpaperCommand() {
        options.addOption("h", "help", false, "print help");
        options.addOption("q", "quality", true, "the wallpaper quality, one of " +
                Arrays.toString(UnSplashWallpaperProvider.getQuality()));
        command = "Unsplash wallpaper provider";
    }

    public int execute(String[] args) throws ParseException, UnknownWallpaperQuantityException {
        UnSplashWallpaperProviderFactory factory = new UnSplashWallpaperProviderFactory();
        UnSplashWallpaperProvider provider = factory.instance();


        argsChecker(args);

        CommandLineParser parser = new DefaultParser();
        CommandLine commandLine = parser.parse(options, args);

        tryPrintHelp(commandLine);

        if (commandLine.hasOption("quality")) {
            provider.setQuantity(commandLine.getOptionValue("quality"));
        }

        try {
            System.out.println(provider.getWallpaper().getUrl());
            return 0;

        } catch (Exception e) {
            System.err.println(e.getMessage());

            return 1;
        }
    }
}
