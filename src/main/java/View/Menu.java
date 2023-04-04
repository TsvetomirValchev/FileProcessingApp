package View;
import FileManagers.FileIO;
import FileManagers.LineSwapper;
import FileManagers.WordSwapper;


import java.io.File;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private final Scanner input = new Scanner(System.in);

    public void start() {

        String filePath = getFilePath();
        FileIO fileIO = new FileIO(filePath);
        fileIO.readFile();

        if (verifyFile(filePath)) {
            System.out.println("File Verified!");
            int choice = 0;
            while (choice != 4) {
                System.out.println("\nSelect an option:");
                System.out.println("1. Switch lines");
                System.out.println("2. Switch words");
                System.out.println("3. Display file content");

                choice = input.nextInt();
                input.nextLine();

                switch (choice) {
                    case 1 -> {
                        try{
                        System.out.print("Enter the index of the first line you want to switch: ");
                        int lineIndex1 = input.nextInt();
                        System.out.print("Enter the index of the second line you want to switch: ");
                        int lineIndex2 = input.nextInt();
                        LineSwapper.swapLines(FileIO.getText(),lineIndex1, lineIndex2);
                        fileIO.saveFile();
                        System.out.println("Lines switched!");

                        }
                        catch (IndexOutOfBoundsException | InputMismatchException e){
                            System.out.println("Please enter valid indexes!");
                        }
                    }
                    case 2 -> {
                        try{
                        System.out.print("Enter line index of the first word to switch: ");
                        int lineIndex1 = input.nextInt();
                        System.out.print("Enter word index of the first word to switch: ");
                        int wordIndex1 = input.nextInt();
                        System.out.print("Enter line index of the second word to switch: ");
                        int lineIndex2 = input.nextInt();
                        System.out.print("Enter word index of the second word to switch: ");
                        int wordIndex2 = input.nextInt();
                        WordSwapper.swapWords(FileIO.getText(),lineIndex1,wordIndex1,lineIndex2,wordIndex2);
                        fileIO.saveFile();
                        System.out.println("Words switched!");
                        }catch (IndexOutOfBoundsException | InputMismatchException e){
                            System.out.println("Please enter valid indexes!");
                        }
                    }
                    case 3 -> displayText(FileIO.getText());

                    default -> System.out.println("Invalid option! Try again.");
                }
            }
        } else {
            System.out.println("File not found! Try again.");
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
    public boolean verifyFile(String filePath) {
        File file = new File(filePath);
        if (file.exists() && !file.isDirectory()) {
            return true;
        }
        System.out.println("File does not exist or is a directory. Please try again.");
        return false;
    }
    public static String getFilePath() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the file path: ");
        return scanner.nextLine();
    }

}
