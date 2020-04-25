package io.randomwallpaper;

import io.randomwallpaper.command.LocalWallpaperProviderCommand;
import io.randomwallpaper.command.UnSplashWallpaperCommand;
import org.apache.commons.cli.*;


public class Command {
    public static String[] slice(String[] args, int start, int end) {
        if (end >= args.length) {
            end = args.length - 1;
        }

        if (start > args.length) {
            return new String[]{};
        }

        String[] slices = new String[end - start + 1];
        for (int i = start; i <= end; i++) {
            slices[i - start] = args[i];
        }

        return slices;
    }

    public static int execute(String[] args) throws ParseException, UnknownWallpaperProviderException, UnknownWallpaperQualityException {
        Options options = new Options();
        HelpFormatter helpFormatter = new HelpFormatter();

        options.addOption("p", "provider", true, "wallpaper provider. 'local'|'unslpash'");
        Option help = new Option("h", "print help");
        help.setLongOpt("help");
        help.setOptionalArg(true);
        options.addOption(help);

        String prog = "randomWallpaper";
        if (args.length == 0) {
            helpFormatter.printHelp(prog, options);
            return 0;
        }

        CommandLineParser commandLineParser = new DefaultParser();
        CommandLine commandLine = commandLineParser.parse(options, slice(args, 0, 1));

        if (commandLine.hasOption("help")) {
            helpFormatter.printHelp(prog, options);
            return 0;
        }

        if (commandLine.hasOption("provider")) {
            String provider = commandLine.getOptionValue("provider");
            io.randomwallpaper.command.Command command;
            if (provider.equals("local")) {
                command = new LocalWallpaperProviderCommand();
            } else if (provider.equals("unsplash")) {
                command = new UnSplashWallpaperCommand();
            } else {
                throw new UnknownWallpaperProviderException("unknown wallpaper provider: '" + provider + "'");
            }

            return command.execute(slice(args, 2, args.length));
        }

        return 0;
    }

    public static void main(String[] args) throws ParseException, UnknownWallpaperQualityException, UnknownWallpaperProviderException {
        System.exit(execute(args));
    }
}
