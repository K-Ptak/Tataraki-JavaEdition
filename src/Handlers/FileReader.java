package Handlers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileReader {
    public static String[] loadDictionary(String filename) throws IOException {
        List<String> listOfStrings;
        listOfStrings = Files.readAllLines(Paths.get(filename));
        return listOfStrings.toArray(new String[0]);
    }
}
