package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Map;

public interface Parser {
    static Map<String, Object> parse(String data) throws JsonProcessingException {
        return null;
    }
}
