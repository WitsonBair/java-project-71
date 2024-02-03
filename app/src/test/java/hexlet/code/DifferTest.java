package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class DifferTest {

    @Test
    public void differStylishTest1() throws Exception {
        String file1 = "src/test/resources/file1.json";
        String file2 = "src/test/resources/file2.json";
        String format = "stylish";

        String expected = readFixture("expected1.txt");
        String actual = Differ.generate(file1, file2, format);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void differStylishTest2() throws Exception {
        String file1 = "src/test/resources/file1.yml";
        String file2 = "src/test/resources/file2.yml";

        String expected = readFixture("expected2.txt");
        String actual = Differ.generate(file1, file2);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void differPlainTest() throws Exception {
        String filepath4 = "src/test/resources/file1.json";
        String filepath5 = "src/test/resources/file2.json";
        String format = "plain";

        String expected = readFixture("expected3.txt");
        String actual = Differ.generate(filepath4, filepath5, format);
        assertThat(actual).isEqualTo(expected);
    }

    private static Path getFixturePath(String fileName) {
        return Paths.get("src", "test", "resources", fileName)
                .toAbsolutePath().normalize();
    }

    private static String readFixture(String fileName) throws Exception {
        Path filePath = getFixturePath(fileName);
        return Files.readString(filePath);
    }
}