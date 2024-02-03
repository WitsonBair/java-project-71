package hexlet.code.formatters;

import hexlet.code.Formatter;

import java.util.List;
import java.util.Map;

public class StylishFormatter implements Formatter {
    @Override
    public String format(Map<String, List<Object>> tree) {
        StringBuilder stylishString = new StringBuilder();
        stylishString.append("{");

        tree.forEach((k, v) -> {
            stylishString.append("\n ");
            String operation = v.get(v.size() - 1).toString();
            switch (operation) {
                case "CHANGED":
                    stylishString.append("- ").append(k).append(": ").append(v.get(0));
                    stylishString.append("\n ");
                    stylishString.append("+ ").append(k).append(": ").append(v.get(1));
                    break;

                case "ADDED":
                    stylishString.append("+ ").append(k).append(": ").append(v.get(0));
                    break;

                case "REDUCED":
                    stylishString.append("- ").append(k).append(": ").append(v.get(0));
                    break;

                case "STAYED":
                    stylishString.append("  ").append(k).append(": ").append(v.get(0));
                    break;

                default:
                    try {
                        throw new Exception("Wrong operation");
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
            }
        });

        stylishString.append("\n}");

        return stylishString.toString();
    }
}
