package pl.backlog.green;

import org.apache.commons.cli.*;

public class Test02 {
    public static void main(String[] args) {
        Options options = new Options();

        options.addOption(new Option("a", "first option without value, not mandatory"));
        options.addOption(new Option("b", false,"second option without value, not mandatory"));
        options.addOption(new Option("c", true,"third option with value, not mandatory"));



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

        if (cmd.hasOption("b")) {
            System.out.println("Podałeś opcję 'b'");
        } else {
            System.out.println("Nie podałeś opcji 'b'");
        }

        if (cmd.hasOption("c")) {
            String value = cmd.getOptionValue('c');
            System.out.println("Podałeś opcję 'c' z wartością " + value);
        } else {
            System.out.println("Nie podałeś opcji 'c'");
        }
    }
}
