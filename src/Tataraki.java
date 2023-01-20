import Handlers.ErrorHandler;
import Handlers.FileReader;
import Handlers.UserInput;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Tataraki {

    public static void main(String[] args) throws IOException {
        String[] dictionary = FileReader.loadDictionary("slownik.txt");
        String inputLetter = Character.toString(UserInput.getInput()); //Letter given by user

        List<String> firstWord = new ArrayList<>(); //Pool of words starting with inputLetter
        List<String> secondWord = new ArrayList<>(); //Pool of reversed words
        String longestWord = "";

        for (String word : dictionary) {
            if (word.startsWith(inputLetter)) {
                firstWord.add(word);
                if (word.length() > longestWord.length()) {
                    longestWord = word;
                }
            }
            secondWord.add(new StringBuilder(word).reverse().toString()); //reverses word and adds it to list
        }

        if (firstWord.size() == 0) {
            ErrorHandler.errorCodes(1);
        }

        for (String first : firstWord) {
            for (String second : secondWord) {
                if ((first.length() + second.length()) <= longestWord.length() && firstWord.contains(first + second)) {
                    System.out.println(first + second + " = " + first + " " + new StringBuilder(second).reverse());
                }
            }
        }
    }
}