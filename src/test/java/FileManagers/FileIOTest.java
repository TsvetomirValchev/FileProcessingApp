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
        fileIO.readFile();
    }

    @AfterEach
    public void tearDown(){
        fileIO.getText().clear();
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
        fileIO.getText().clear();
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
        fileIO.getText().clear();
        fileIO.getText().addAll(expectedText);
        fileIO.saveFile();
        assertEquals(expectedText, fileIO.getText());
    }

    @Test
    @DisplayName("should read the file and store its content correctly")
    public void readFileAndStoreContentInList() {

        List<List<String>> expectedText =
                Arrays.asList(
                        Arrays.asList("word1", "word2", "word3"),
                        Arrays.asList("word4", "word5"),
                        Arrays.asList("word6", "word7", "word8", "word9"));
        assertEquals(expectedText, fileIO.getText());
    }

    @Test
    public void testSwapLinesWithProperIndexes() {
        //We swap line2 with line1 (lines start counting from 0)
        fileIO.swapLines(createTestText(), 2,1);
        List<List<String>> ExpectedText =
                Arrays.asList(Arrays.asList("word1","word2", "word3"),
                        Arrays.asList("word7", "word8", "word9"),
                        Arrays.asList("word4", "word5","word6"));

        assertEquals(createTestText().get(1),ExpectedText.get(2));
    }
    //This method creates the List<List<String>> text that we use to test the method SwapLines
    private List<List<String>> createTestText(){
        return Arrays.asList(Arrays.asList("word1","word2", "word3"),
                Arrays.asList("word4", "word5","word6"),
                Arrays.asList("word7", "word8", "word9"));
    }

    @Test
    public void testSwapWordsWithProperIndexes() {
        //We swap word5 with word 8
        fileIO.swapWords(createTestText(), 2,1, 1, 2);
        List<List<String>> ExpectedText =
                Arrays.asList(Arrays.asList("word1","word2", "word3"),
                        Arrays.asList("word4", "word8","word6"),
                        Arrays.asList("word7", "word5", "word9"));
        //Check if word5 is in the place of word8
        assertEquals(createTestText().get(1).get(1),ExpectedText.get(2).get(1));
        //Check if word8 is in the place of word5
        assertEquals(createTestText().get(2).get(1),ExpectedText.get(1).get(1));
    }



}