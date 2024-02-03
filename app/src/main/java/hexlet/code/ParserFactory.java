package hexlet.code;

import hexlet.code.parsers.JsonParser;
import hexlet.code.parsers.YamlParser;

public class ParserFactory {
    public static Parser createParser(String fileExtension) throws Exception {
        return switch (fileExtension) {
            case "json" -> new JsonParser();
            case "yml" -> new YamlParser();
            default -> throw new Exception("Wrong file format");
        };
    }
}
