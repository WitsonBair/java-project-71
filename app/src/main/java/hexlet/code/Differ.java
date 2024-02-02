package hexlet.code;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Differ {
    public static String generate(String filepath1, String filepath2, String format) {
        Path filename1 = Paths.get(filepath1);
        Path filename2 = Paths.get(filepath2);
        return filename1 + "\n" + filename2;
    }
}
