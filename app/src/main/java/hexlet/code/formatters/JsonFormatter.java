package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.Formatter;

import java.util.List;
import java.util.Map;

public class JsonFormatter implements Formatter {
    @Override
    public final String format(Map<String, List<Object>> tree) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(tree);
    };
}
