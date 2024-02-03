package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.HashMap;

public interface Parser {
    public HashMap<String, Object> parse(String data) throws JsonProcessingException;
}
