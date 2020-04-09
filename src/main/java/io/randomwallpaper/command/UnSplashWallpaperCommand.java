package io.randomwallpaper.command;

import io.randomwallpaper.UnknownWallpaperQuantityException;
import io.randomwallpaper.provider.UnSplashWallpaperProvider;
import io.randomwallpaper.provider.UnSplashWallpaperProviderFactory;
import org.apache.commons.cli.*;

import java.util.Arrays;

public class UnSplashWallpaperCommand extends Command {
    public UnSplashWallpaperCommand() {
        options.addOption("h", "help", false, "print help");
        options.addOption("q", "quantity", true, "the wallpaper quantity, one of " +
                Arrays.toString(UnSplashWallpaperProvider.getQuantitys()));
        command = "Unsplash wallpaper provider";
    }

    public int execute(String[] args) throws ParseException, UnknownWallpaperQuantityException {
        UnSplashWallpaperProviderFactory factory = new UnSplashWallpaperProviderFactory();
        UnSplashWallpaperProvider provider = factory.instance();


        argsChecker(args);

        CommandLineParser parser = new DefaultParser();
        CommandLine commandLine = parser.parse(options, args);

        tryPrintHelp(commandLine);

        if (commandLine.hasOption("quantity")) {
            provider.setQuantity(commandLine.getOptionValue("quantity"));
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
