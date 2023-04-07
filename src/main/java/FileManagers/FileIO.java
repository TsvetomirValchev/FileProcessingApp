package FileManagers;

import java.io.*;
import java.util.*;

public class FileIO {
    // This field stores the lines of text read from or to be written to the file.
    private final List<List<String>> text = new ArrayList<>();
    private final String filePath;
    public List<List<String>> getText() {return text;}

    public FileIO(String filePath) {
        this.filePath = filePath;
    }
   //this method reads the file and saves it's content in the store field
    public void readFile(){
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                List<String> lines = Arrays.asList(words);
                text.add(lines);
            }
        } catch (IOException e) {
            System.out.println("Something went wrong with reading the file...");
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
            }
        } catch (IOException e) {
            System.out.println("Something went wrong with saving the file...");
        }
    }
    public void swapLines(List<List<String>> text,  int firstLine, int secondLine) {
        List<String> temp = text.get(firstLine);
        text.set(firstLine, text.get(secondLine));
        text.set(secondLine, temp);
    }
    public  void swapWords(List<List<String>> text, int firstLineIndex, int firstWordIndex, int secondLineIndex, int secondWordIndex) {
        String temp = text.get(firstLineIndex).get(firstWordIndex);
        text.get(firstLineIndex).set(firstWordIndex, text.get(secondLineIndex).get(secondWordIndex));
        text.get(secondLineIndex).set(secondWordIndex, temp);
    }
}


