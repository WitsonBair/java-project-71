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

  public static void main(String[] args) {
    CommandLine cmd = new CommandLine(new App());
    int gendiff = cmd.execute(args);
    System.exit(gendiff);
  }
}
