package FileManagers;

import org.junit.jupiter.api.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileIOTest {

    private FileIO fileIO;
    private String testFilePath;

    @BeforeEach
    public void setUp() {
        testFilePath = "src/test/java/FileManagers/FileIOTestFile.txt";
        fileIO = new FileIO(testFilePath);
        createTestFile();
    }

    private void createTestFile() {
        List<String> lines =
                Arrays.asList("word1 word2 word3", "word4 word5", "word6 word7 word8 word9");
        try {
            Files.write(Paths.get(testFilePath), lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("should save an empty file when the text list is empty")
    void saveFileWhenTextListIsEmpty() {
        FileIO.getText().clear();
        fileIO.saveFile();
        assertEquals(0, new File(testFilePath).length());
    }

    @Order(1)
    @Test
    @DisplayName("should save the file with the correct content")
    void saveFileWithCorrectContent() {
        List<List<String>> expectedText =
                Arrays.asList(
                        Arrays.asList("word1", "word2", "word3"),
                        Arrays.asList("word4", "word5"),
                        Arrays.asList("word6", "word7", "word8", "word9"));
        FileIO.getText().addAll(expectedText);
        fileIO.saveFile();
        assertEquals(expectedText, FileIO.getText());
    }

    @Order(2)
    @Test
    @DisplayName("should read the file and store its content correctly")
    void readFileAndStoreContentInList() {
        FileIO.getText().clear();
        fileIO.readFile();
        List<List<String>> expectedText =
                Arrays.asList(
                        Arrays.asList("word1", "word2", "word3"),
                        Arrays.asList("word4", "word5"),
                        Arrays.asList("word6", "word7", "word8", "word9"));
        assertEquals(expectedText, FileIO.getText());
    }
}
