package FileManagers;

import java.util.List;

public class WordSwapper {

    public static void swapWords(int firstLineIndex, int firstWordIndex, int secondLineIndex, int secondWordIndex) {
        List<List<String>> text = FileIO.getText();
        String temp = text.get(firstLineIndex).get(firstWordIndex);
        text.get(firstLineIndex).set(firstWordIndex, text.get(secondLineIndex).get(secondWordIndex));
        text.get(secondLineIndex).set(secondWordIndex, temp);
    }
}
