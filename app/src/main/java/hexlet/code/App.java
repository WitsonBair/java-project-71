package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 0.2",
        description = "Compares two configuration files and shows a difference.")
public class App {
  @Option(names = {"-h", "--help"}, usageHelp = true, description = "Show this help message and exit")
  private boolean helpRequested;
  @Option(names = { "-V", "--version" }, versionHelp = true,
          description = "Print version information and exit")
  private boolean versionRequested;
  @Parameters(paramLabel = "filepath1", description = "path to first file")
  private static String filepath1;
  @Parameters(paramLabel = "filepath2", description = "path to second file")
  private static String filepath2;

  public static void main(String[] args) {
    CommandLine commandLine = new CommandLine(new App());
    commandLine.parseArgs(args);
    if (commandLine.isUsageHelpRequested()) {
      commandLine.usage(System.out);
      return;
    } else if (commandLine.isVersionHelpRequested()) {
      commandLine.printVersionHelp(System.out);
      return;
    }
  }
}
