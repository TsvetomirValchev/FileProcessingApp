package FileManagers;

import java.util.List;

public class WordSwapper {

    //This method swaps two words in a List<List<String>> text
    public static void swapWords(List<List<String>> text, int firstLineIndex, int firstWordIndex, int secondLineIndex, int secondWordIndex) {
        String temp = text.get(firstLineIndex).get(firstWordIndex);
        text.get(firstLineIndex).set(firstWordIndex, text.get(secondLineIndex).get(secondWordIndex));
        text.get(secondLineIndex).set(secondWordIndex, temp);

    }
}
