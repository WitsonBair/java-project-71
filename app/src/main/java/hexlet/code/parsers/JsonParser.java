package hexlet.code.parsers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.Parser;

import java.util.HashMap;

public class JsonParser implements Parser {
    @Override
    public final HashMap<String, Object> parse(String jsonData) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<HashMap<String, Object>> ref = new TypeReference<HashMap<String, Object>>() { };
        return mapper.readValue(jsonData, ref);
    }
}
