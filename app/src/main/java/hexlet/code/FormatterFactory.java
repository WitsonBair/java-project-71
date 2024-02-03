package hexlet.code;

import hexlet.code.formatters.JsonFormatter;
import hexlet.code.formatters.StylishFormatter;

public class FormatterFactory {
    public static Formatter createFormatter(String format) throws Exception {
        switch (format) {
            case "json":
                return new JsonFormatter();
            case "stylish":
                return new StylishFormatter();
            case "plain":
                System.out.println("Plain!");
                break;
            default:
                throw new Exception("Unknown format");
        }
        return null;
    };
}
