package hexlet.code;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Differ {
    public static String generate(String filepath1, String filepath2, String format) throws IOException {
        Path path1 = Paths.get(filepath1);
        Path path2 = Paths.get(filepath2);
        String fileContent1 = Files.readString(path1);
        String fileContent2 = Files.readString(path2);
        return fileContent1 + "\n" + fileContent2;
    }
}
