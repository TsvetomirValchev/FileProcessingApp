package FileManagers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

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
        testFilePath = "src/test/java/FileManagers/testFile.txt";
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


    @Test
    public void testSaveFile() {
        List<List<String>> newText = Arrays.asList(
                Arrays.asList("new1", "new2"),
                Arrays.asList("new3", "new4", "new5")
        );
        FileIO.getText().clear();
        FileIO.getText().addAll(newText);

        fileIO.saveFile();

        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get(testFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertTrue(lines.contains("new1 new2"));
        assertTrue(lines.contains("new3 new4 new5"));
    }


    @Order(1)
    @Test
    @DisplayName("should read the file and store its content correctly")
    void readFileAndStoreContent() {
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