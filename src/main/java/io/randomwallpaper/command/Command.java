package io.randomwallpaper.command;

import io.randomwallpaper.UnknownWallpaperQualityException;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public abstract class Command {
    protected HelpFormatter helpFormatter = new HelpFormatter();
    protected Options options = new Options();
    protected String command = "Command";

    /**
     * exit if args length equals 0
     * @param args command line option
     */
    public void argsChecker(String[] args) {
        if (args.length == 0) {
            helpFormatter.printHelp(command, options);
            System.exit(0);
        }
    }

    /**
     * options checker exit if has help option
     * @param cmd parsed options
     */
    public void tryPrintHelp(CommandLine cmd) {
        if (cmd.hasOption("help")) {
            helpFormatter.printHelp(command, options);
            System.exit(0);
        }
    }

    /**
     * execute and return status code
     * @param args arguments
     * @return int status code of execute result
     */
    public abstract int execute(String[] args) throws ParseException, UnknownWallpaperQualityException;
}
