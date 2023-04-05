package FileManagers;

import java.util.List;

public class LineSwapper {
    //This method swaps two lines in a List<List<String>> text by their indexes(they start from 0)
    public static void swapLines(List<List<String>> text,  int firstLine, int secondLine) {
        List<String> temp = text.get(firstLine);
        text.set(firstLine, text.get(secondLine));
        text.set(secondLine, temp);

    }
}
