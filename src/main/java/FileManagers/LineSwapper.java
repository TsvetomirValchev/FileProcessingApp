package FileManagers;


import java.util.List;

public class LineSwapper {

    public static void swapLines(int firstLine, int secondLine) {

        List<List<String>> text = FileIO.getText();
        List<String> temp = text.get(firstLine);
        text.set(firstLine, text.get(secondLine));
        text.set(secondLine, temp);
    }

}
