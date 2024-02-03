package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
@Command(name = "gendiff", version = "gendiff 1.0",
        description = "Compares two configuration files and shows a difference.")
public class App {

    @Parameters(paramLabel = "filepath1", description = "path to first file")
    private static String fileName1;
    @Parameters(paramLabel = "filepath2", description = "path to second file")
    private static String fileName2;
    @Option(names = { "-f", "--format"}, paramLabel = "format", defaultValue = "stylish",
            description = "output format [default: ${DEFAULT-VALUE}]")
    private static String format;
    @Option(names = {"-h", "--help"}, usageHelp = true, description = "Show this help message and exit")
    private boolean usageHelpRequested;
    @Option(names = { "-V", "--version" }, versionHelp = true,
            description = "print version information and exit")
    private boolean versionRequested;
    public static void main(String[] args) throws Exception {

        CommandLine commandLine = new CommandLine(new App());
        commandLine.parseArgs(args);
        if (commandLine.isUsageHelpRequested()) {
            commandLine.usage(System.out);
        } else if (commandLine.isVersionHelpRequested()) {
            commandLine.printVersionHelp(System.out);
        } else {
            System.out.println(Differ.generate(fileName1, fileName2, format));
        }
    }
}
