package Handlers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileReader {
    public static String[] loadDictionary(String filename){
        List<String> listOfStrings = null;
        try {
            listOfStrings = Files.readAllLines(Paths.get(filename));
        } catch (IOException e) {
            ErrorHandler.errorCodes(2);
        }
        assert listOfStrings != null;
        return listOfStrings.toArray(new String[0]);
    }
}
