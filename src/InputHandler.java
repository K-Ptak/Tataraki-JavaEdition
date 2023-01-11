import java.util.Scanner;

public class InputHandler {
    private static boolean isLetter(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }
    public static char getInput(){
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Podaj litere: ");

        char letter = myScanner.next().charAt(0);

        if(!isLetter(letter)){
            ErrorHandler.errorCodes(0);
        }
        return letter;
    }
}
