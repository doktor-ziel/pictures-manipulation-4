package pl.backlog.green;

import org.apache.commons.cli.*;

public class Test05 {
    public static void main(String[] args) {
        Option option = new Option("a", "first option without value, mandatory");
        option.setRequired(true);

        Options options = new Options();
        options.addOption(option);

        CommandLineParser parser = new DefaultParser();
        HelpFormatter help = new HelpFormatter();
        CommandLine cmd = null;

        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            help.printHelp("Test05 [OPTIONS] ARG", options);
            System.exit(1);
        }

        if (cmd.hasOption("a")) {
            System.out.println("Podałeś opcję 'a'");
        }

        System.out.println(cmd.getArgList());
    }
}
