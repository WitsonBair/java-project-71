package hexlet.code;

import hexlet.code.parsers.JsonParser;

public class ParserFactory {
    public static Parser createParser(String fileExtension) throws Exception {
        Parser parser = null;
        switch (fileExtension) {
            case "json":
                parser = new JsonParser();
                break;
            case "yml":
                System.out.println("YAML");
                break;
            default:
                throw new Exception("Wrong file format");
        }
        return parser;
    }
}
