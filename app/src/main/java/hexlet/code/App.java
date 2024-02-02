package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 0.2",
        description = "Compares two configuration files and shows a difference.")
public class App implements Runnable {
  @Option(names = {"-h", "--help"}, usageHelp = true, description = "Show this help message and exit")
  private boolean helpRequested;
  @Option(names = { "-V", "--version" }, versionHelp = true,
          description = "Print version information and exit")
  private boolean versionRequested;
  @Option(names = { "-f", "--format"}, paramLabel = "format",
          description = "output format [default: stylish]")
  private static String format;
  @Parameters(index = "0", description = "path to first file")
  private static String filepath1;
  @Parameters(index = "1", description = "path to second file")
  private static String filepath2;

  @Override
  public void run() {
    System.out.println(Differ.generate(filepath1, filepath2, format));
  }

  public static void main(String[] args) {
    new CommandLine(new App()).execute(args);
  }
}
