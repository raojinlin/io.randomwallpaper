import io.randomwallpaper.UnknownWallpaperProviderException;
import io.randomwallpaper.UnknownWallpaperQuantityException;
import io.randomwallpaper.command.LocalWallpaperProviderCommand;
import io.randomwallpaper.command.UnSplashWallpaperCommand;
import org.apache.commons.cli.*;


public class Command {
    public static String[] slice(String[] args, int start, int end) {
        if (start + 1 > args.length) {
            return new String[]{};
        }

        String[] slices = new String[end - start];
        for (int i = start; i < end; i++) {
            slices[i - start] = args[i];
        }

        return slices;
    }

    public static void main(String[] args) throws ParseException, UnknownWallpaperProviderException, UnknownWallpaperQuantityException {
        Options options = new Options();
        HelpFormatter helpFormatter = new HelpFormatter();

        options.addOption("h", "help", false, "print help");
        options.addOption("p", "provider", true, "wallpaper provider. 'local'|'unspash'");

        String prog = "randomwallpaper";
        if (args.length == 0) {
            helpFormatter.printHelp(prog, options);
            return;
        }

        CommandLineParser commandLineParser = new DefaultParser();
        CommandLine commandLine = commandLineParser.parse(options, slice(args, 0, 2));

        if (commandLine.hasOption("help")) {
            helpFormatter.printHelp(prog, options);
            return;
        }

        if (commandLine.hasOption("provider")) {
            String provider = commandLine.getOptionValue("provider");
            io.randomwallpaper.command.Command command;
            int status = 0;
            if (provider.equals("local")) {
                command = new LocalWallpaperProviderCommand();
            } else if (provider.equals("unsplash")) {
                command = new UnSplashWallpaperCommand();
            } else {
                throw new UnknownWallpaperProviderException("unknown wallpaper provider: '" + provider + "'");
            }

            status = command.execute(slice(args, 2, args.length));
            System.exit(status);
        }
    }
}
