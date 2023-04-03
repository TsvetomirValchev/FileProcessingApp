package FileManagers;

import java.io.*;
import java.util.*;


public class FileIO {

    // This field stores the lines of text read from or to be written to the file.
    private static final List<List<String>> text = new ArrayList<>();
    private final String filePath;

    public static List<List<String>> getText() {
        return text;
    }

    public FileIO(String filePath) {
        this.filePath = filePath;
    }
   //this method reads the file and saves it's content in the store field
    public void readFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                List<String> lines = Arrays.asList(words);
                text.add(lines);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //this method saves the content of the store field to the file
    public void saveFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (List<String> line : text) {
                for (int i = 0; i < line.size(); i++) {
                    bw.write(line.get(i));
                    if (i < line.size() - 1) {
                        bw.write("\s");
                    }
                }
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


