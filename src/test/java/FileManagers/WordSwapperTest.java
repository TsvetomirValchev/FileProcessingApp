package FileManagers;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class WordSwapperTest {



    @Test
    public void testSwapLinesWithProperIndexes() {
        //We swap word5 with word 8
        WordSwapper.swapWords(createTestText(), 2,1, 1, 2);
        List<List<String>> ExpectedText =
                Arrays.asList(Arrays.asList("word1","word2", "word3"),
                        Arrays.asList("word4", "word8","word6"),
                        Arrays.asList("word7", "word5", "word9"));


        //Check if word5 is in the place of word8
        assertEquals(createTestText().get(1).get(1),ExpectedText.get(2).get(1));
        //Check if word8 is in the place of word5
        assertEquals(createTestText().get(2).get(1),ExpectedText.get(1).get(1));


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
