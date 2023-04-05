package FileManagers;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LineSwapperTest {
    @BeforeAll
    public static void setUp () {
        createTestText();
    }
    @Test
    public void testSwapLinesWithProperIndexes() {
        //We swap line2 with line1 (lines start counting from 0)
        LineSwapper.swapLines(createTestText(), 2,1);
                List<List<String>> ExpectedText =
                        Arrays.asList(Arrays.asList("word1","word2", "word3"),
                                Arrays.asList("word7", "word8", "word9"),
                                Arrays.asList("word4", "word5","word6"));

        assertEquals(createTestText().get(1),ExpectedText.get(2));

    }
    //This method creates the List<List<String>> text that we use to test the method SwapLines
    private static List<List<String>> createTestText(){
        List<List<String>> text =
                        Arrays.asList(Arrays.asList("word1","word2", "word3"),
                                Arrays.asList("word4", "word5","word6"),
                                Arrays.asList("word7", "word8", "word9"));
        return text;
    }
}
