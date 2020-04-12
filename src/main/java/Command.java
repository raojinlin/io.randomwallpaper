import io.randomwallpaper.UnknownWallpaperProviderException;
import io.randomwallpaper.UnknownWallpaperQualityException;
import io.randomwallpaper.command.LocalWallpaperProviderCommand;
import io.randomwallpaper.command.UnSplashWallpaperCommand;
import org.apache.commons.cli.*;


public class Command {
    public static String[] slice(String[] args, int start, int end) {
        if (start >= args.length - 1) {
            return args;
        }

        String[] slices = new String[end - start];

        System.arraycopy(args, start, slices, 0, end - start);

        return slices;
    }

    public static void main(String[] args) throws ParseException, UnknownWallpaperProviderException, UnknownWallpaperQualityException {
        Options options = new Options();
        HelpFormatter helpFormatter = new HelpFormatter();

        options.addOption("p", "provider", true, "wallpaper provider. 'local'|'unspash'");
        Option help = new Option("h", "print help");
        help.setLongOpt("help");
        help.setOptionalArg(true);
        options.addOption(help);

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
