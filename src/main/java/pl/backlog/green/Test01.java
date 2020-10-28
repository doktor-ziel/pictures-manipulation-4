package pl.backlog.green;

import org.apache.commons.cli.*;

public class Test01 {
    public static void main(String[] args) {
        Option option = new Option("a", "first option without value, not mandatory");

        Options options = new Options();
        options.addOption(option);

        CommandLineParser parser = new DefaultParser();
        HelpFormatter help = new HelpFormatter();
        CommandLine cmd = null;

        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            help.printHelp("Test01", options);
            System.exit(1);
        }

        if (cmd.hasOption("a")) {
            System.out.println("Podałeś opcję 'a'");
        } else {
            System.out.println("Nie podałeś opcji 'a'");
        }
    }
}
