package hexlet.code.parsers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import hexlet.code.Parser;

import java.util.HashMap;

public class YamlParser implements Parser {
    @Override
    public HashMap<String, Object> parse(String yamlData) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        return mapper.readValue(yamlData, new TypeReference<HashMap<String, Object>>() {});
    }
}
