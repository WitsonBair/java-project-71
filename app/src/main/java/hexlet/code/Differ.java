package hexlet.code;

import hexlet.code.parsers.JsonParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Differ {
    public static String generate(String filepath1, String filepath2, String format) throws Exception {
        Path path1 = Paths.get(filepath1).toAbsolutePath().normalize();
        Path path2 = Paths.get(filepath2).toAbsolutePath().normalize();

        String fileExtension1 = getFileExtension(filepath1);
        String fileExtension2 = getFileExtension(filepath2);

        String fileContent1 = Files.readString(path1);
        String fileContent2 = Files.readString(path2);

        Parser parser1 = ParserFactory.createParser(fileExtension1);
        Parser parser2 = ParserFactory.createParser(fileExtension2);

        assert parser1 != null;
        HashMap<String, Object> convertedData1 = parser1.parse(fileContent1);
        assert parser2 != null;
        HashMap<String, Object> convertedData2 = parser2.parse(fileContent2);

        Formatter formatter = FormatterFactory.createFormatter(format);

        Map<String, List<Object>> tree = TreeBuilder.buildTree(convertedData1, convertedData2);

        assert formatter != null;

        return formatter.format(tree);
    }

    private static String getFileExtension(String filePath) {
        int index = filePath.lastIndexOf('.');
        return index > 0 ? filePath.substring(index + 1) : "";
    }
}
