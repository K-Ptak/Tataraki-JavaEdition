import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static boolean isLetter(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }
    public static char getInput(){
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Podaj litere: ");

        char letter = myScanner.next().charAt(0);

        if(!isLetter(letter)){
            System.out.print("Nie podałes litery!");
            System.exit(0);
        }
        return letter;
    }
    public static String[] loadDictionary(String filename) throws IOException {
        List<String> listOfStrings = new ArrayList<String>();

        // load the data from file
        listOfStrings = Files.readAllLines(Paths.get(filename));

        // convert arraylist to array
        return listOfStrings.toArray(new String[0]);
    }

    public static void main(String[] args) throws IOException {
        final long startTime = System.currentTimeMillis();

        String[] dictionary = loadDictionary("slownik.txt");
        String inputLetter = Character.toString(getInput());

        for (String word : dictionary) {
            if (word.startsWith(inputLetter)) {
                System.out.println(word);
            }
        }


        final long endTime = System.currentTimeMillis();
        System.out.println("\nCzas trwania programu: " + (endTime - startTime) + "ms");
    }
}