package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;
import java.util.Map;

public interface Formatter {
    public String format(Map<String, List<Object>> tree) throws JsonProcessingException;
}
