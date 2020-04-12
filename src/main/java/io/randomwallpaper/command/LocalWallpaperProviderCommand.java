package io.randomwallpaper.command;

import io.randomwallpaper.provider.LocalWallpaperProvider;
import io.randomwallpaper.provider.LocalWallpaperProviderFactory;
import org.apache.commons.cli.*;

import java.io.File;


public class LocalWallpaperProviderCommand extends Command {

    public LocalWallpaperProviderCommand() {
        options.addOption("d", "dir", true, "wallpaper directory");
        options.addOption("h", "help", false, "print help");
        command = "Local wallpaper provider";
    }

    public int execute(String[] args) throws ParseException {
        LocalWallpaperProvider provider = new LocalWallpaperProviderFactory().instance();

        argsChecker(args);

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options, args);

        tryPrintHelp(cmd);

        if (!cmd.hasOption("dir")) {
            System.err.println("dir required.");
            return 127;
        }

        try {
            String dir = cmd.getOptionValue("dir");
            File file = new File(dir);
            if (!file.exists()) {
                System.err.println("No such directory: '" + dir + "'");
                return 2;
            } else if (!file.isDirectory()) {
                System.err.println("Not a directory: '" + dir + "'");
                return 2;
            }

            provider.setLocalWrapperDirs(new String[]{dir});
            System.out.println(provider.getWallpaper().getUrl());
            return 0;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return 1;
        }
    }
}
