import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void errorCodes(int id){
        switch (id) {
            case 0 -> System.out.println("Nie podales litery!");
            case 1 -> System.out.println("Nie ma ani jednego slowa na podana litere w slowniku");
        }
        System.exit(0);
    }

    private static boolean isLetter(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }
    public static char getInput(){
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Podaj litere: ");

        char letter = myScanner.next().charAt(0);

        if(!isLetter(letter)){
           errorCodes(0);
        }
        return letter;
    }
    public static String[] loadDictionary(String filename) throws IOException {
        List<String> listOfStrings;
        listOfStrings = Files.readAllLines(Paths.get(filename));
        return listOfStrings.toArray(new String[0]);
    }

    public static void main(String[] args) throws IOException {
        final long startTime = System.currentTimeMillis();

        String[] dictionary = loadDictionary("slownik.txt");
        String inputLetter = Character.toString(getInput()); //Letter given by user

        List<String> firstWord = new ArrayList<>(); //Pool of words starting with inputLetter
        List<String> secondWord = new ArrayList<>(); // Pool of reversed words
        String longestWord = "";

        for (String word : dictionary) {
            if (word.startsWith(inputLetter)) {
                firstWord.add(word);
                if (word.length() > longestWord.length()){
                    longestWord = word;
                }
            }
            secondWord.add(new StringBuilder(word).reverse().toString()); //reverses word and adds it to list
        }

        if(firstWord.size() == 0){
            errorCodes(1);
        }

        for (String first : firstWord){
            for (String second : secondWord){
                if ((first.length()+second.length())<=longestWord.length() && firstWord.contains(first+second)){
                    System.out.println(first+second + " = " + first + " " + new StringBuilder(second).reverse());
                }
            }
        }



        final long endTime = System.currentTimeMillis();
        System.out.println("\nCzas trwania programu: " + (endTime - startTime) + "ms");
    }
}