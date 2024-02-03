package hexlet.code;

import hexlet.code.formatters.JsonFormatter;
import hexlet.code.formatters.PlainFormatter;
import hexlet.code.formatters.StylishFormatter;

public class FormatterFactory {
    public static Formatter createFormatter(String format) throws Exception {
        return switch (format) {
            case "json" -> new JsonFormatter();
            case "stylish" -> new StylishFormatter();
            case "plain" -> new PlainFormatter();
            default -> throw new Exception("Unknown format");
        };
    };
}
