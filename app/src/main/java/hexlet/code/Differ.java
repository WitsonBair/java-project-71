package hexlet.code;

import hexlet.code.parsers.JsonParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

public class Differ {
    public static String generate(String filepath1, String filepath2, String format) throws IOException {
        Path path1 = Paths.get(filepath1).toAbsolutePath().normalize();
        Path path2 = Paths.get(filepath2).toAbsolutePath().normalize();

        String fileContent1 = Files.readString(path1);
        String fileContent2 = Files.readString(path2);

        HashMap<String, Object> converted1 = JsonParser.parse(fileContent1);
        HashMap<String, Object> converted2 = JsonParser.parse(fileContent2);

        converted1.forEach((key, value) -> System.out.println(key + " = " + value));

        return "LOK'TAR OGAR!";
    }
}
