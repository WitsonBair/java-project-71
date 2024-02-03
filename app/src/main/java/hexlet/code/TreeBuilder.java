package hexlet.code;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Set;
import java.util.TreeSet;
import java.util.Arrays;
import java.util.Objects;

public class TreeBuilder {
    public static Map<String, List<Object>> buildTree(HashMap<String, Object> convertedData1,
                                                      HashMap<String, Object> convertedData2) {
        Map<String, List<Object>> tree = new TreeMap<>();
        Set<String> keys = new TreeSet<>();
        keys.addAll(convertedData1.keySet());
        keys.addAll(convertedData2.keySet());

        keys.forEach((key) -> {
            if (convertedData1.containsKey(key) && !convertedData2.containsKey(key)) {
                tree.put(key, Arrays.asList(convertedData1.get(key), Operations.REDUCED));
            } else if (!convertedData1.containsKey(key) && convertedData2.containsKey(key)) {
                tree.put(key, Arrays.asList(convertedData2.get(key), Operations.ADDED));
            } else {
                if (!Objects.equals(convertedData1.get(key), convertedData2.get(key))) {
                    tree.put(key, Arrays.asList(convertedData1.get(key), convertedData2.get(key), Operations.CHANGED));
                } else {
                    tree.put(key, Arrays.asList(convertedData1.get(key), Operations.STAYED));
                }
            }
        });

        return tree;
    }
}
