package hexlet.code.formatters;

import hexlet.code.Formatter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PlainFormatter implements Formatter {
    private static final String templateForChanged = "Property '%s' was updated. From %s to %s";
    private static final String templateForAdded = "Property '%s' was added with value: %s";
    private static final String templateForReduced = "Property '%s' was removed";

    @Override
    public final String format(Map<String, List<Object>> tree) {
        return tree.entrySet().stream()
                .map(entry -> {
                    List<Object> stepList = entry.getValue();
                    String template = "";
                    switch (stepList.get(stepList.size() - 1).toString()) {
                        case ("CHANGED"):
                            template = String.format(templateForChanged, entry.getKey(),
                                    stringify(stepList.get(0)), stringify(stepList.get(1)));
                            break;
                        case ("ADDED"):
                            template = String.format(templateForAdded, entry.getKey(),
                                    stringify(stepList.get(0)));
                            break;
                        case ("REDUCED"):
                            template = String.format(templateForReduced, entry.getKey());
                            break;
                        case ("STAYED"):
                            break;
                        default:
                            System.out.println("Wrong operation type found!");
                            System.exit(0);
                    }
                    return template;
                })
                .filter(entry -> !entry.isEmpty())
                .collect(Collectors.joining("\n"));
    }

    public static String stringify(Object obj) {
        if (obj instanceof Map || obj instanceof Arrays || obj instanceof ArrayList<?>) {
            return "[complex value]";
        }
        if (obj instanceof String) {
            return "'" + obj + "'";
        }
        return String.valueOf(obj);
    }
}
