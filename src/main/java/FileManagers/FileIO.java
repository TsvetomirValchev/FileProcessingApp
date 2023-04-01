package FileManagers;

import java.io.*;
import java.util.*;


public class FileIO {




    private static final List<List<String>> text = new ArrayList<>();
    private final String filePath;




    public static List<List<String>> getText() {
        return text;
    }

    public FileIO(String filePath) {
        this.filePath = filePath;
    }

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


    public void saveFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (List<String> line : text) {
                for (int i = 0; i < line.size(); i++) {
                    bw.write(line.get(i));
                    if (i < line.size() - 1) {
                        bw.write("\\s+");
                    }
                }
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void displayText(List<List<String>> text) {
        for (List<String> strings : text) {
            if (strings.isEmpty()) {
                System.out.println();
            } else {
                for (String word : strings) {
                    System.out.print(word + " ");
                }
                System.out.println();
            }
        }
    }


    public static String getFilePath() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the file path: ");
        return scanner.nextLine();
    }


    public boolean verifyFile(String filePath) {
        File file = new File(filePath);
        if (file.exists() && !file.isDirectory()) {
            return true;
        }
        System.out.println("File does not exist or is a directory. Please try again.");
        return false;
    }
}


