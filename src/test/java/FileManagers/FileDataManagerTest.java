package FileManagers;

import org.junit.jupiter.api.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class FileDataManagerTest {
    private final String testFilePath = "src/test/java/FileManagers/testFile.txt" ;
    private FileDataManager testFileDataManager = new FileDataManager(testFilePath);

    @BeforeEach
    public void setUp(){testFileDataManager.readFile();}

    @Order(1)
    @Test
    @DisplayName("should read the file and store its content correctly")
    public void readFileAndStoreContentInList() {
        try {
            FileWriter writer = new FileWriter(testFilePath);
            writer.write("word1 word2 word3\n");
            writer.write("word4 word5 word6\n");
            writer.write("word7 word8 word9");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<List<String>> expectedText =
                Arrays.asList(
                        Arrays.asList("word1", "word2","word3"),
                        Arrays.asList("word4", "word5","word6"),
                        Arrays.asList("word7", "word8","word9"));
        assertEquals(expectedText, testFileDataManager.getText());
    }

    @Order(2)
    @Test
    @DisplayName("should save the file with the correct content")
    void saveFileWithCorrectContent() {
        List<List<String>> expectedText =
                Arrays.asList(
                        Arrays.asList("word1", "word2","word3"),
                        Arrays.asList("word4", "word5","word6"),
                        Arrays.asList("word7", "word8","word9"));

        assertEquals(expectedText, testFileDataManager.getText());
    }



    @Test
    public void testSwapLinesWithProperIndexes() {
        testFileDataManager.readFile();
        testFileDataManager.swapLines(2,1);
        List<List<String>> ExpectedText =
                Arrays.asList(
                        Arrays.asList("word1", "word2","word3"),
                        Arrays.asList("word4", "word5","word6"),
                        Arrays.asList("word7", "word8","word9"));
        assertEquals(testFileDataManager.getText().get(1),ExpectedText.get(2));
        //swap them back so next test can be valid
        testFileDataManager.swapLines(2,1);
    }



    @Test
    public void testSwapWordsWithProperIndexes() {

        testFileDataManager.readFile();
        //We swap word5 with word 8
        testFileDataManager.swapWords(1,1,2,1);
        List<List<String>> ExpectedText =
                Arrays.asList(
                        Arrays.asList("word1", "word2","word3"),
                        Arrays.asList("word4", "word5","word6"),
                        Arrays.asList("word7", "word8","word9"));
        //Check if word5 is in the place of word8
        assertEquals(testFileDataManager.getText().get(1).get(1), ExpectedText.get(2).get(1));
        //Check if word8 is in the place of word5
        assertEquals(testFileDataManager.getText().get(2).get(1),ExpectedText.get(1).get(1));
    }



}