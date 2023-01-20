package Handlers;

import java.util.Scanner;

public class UserInput {
    private static boolean isLetter(char c) {
        return (c >= 'a' && c <= 'ź') || (c >= 'A' && c <= 'Ź');
    }

    public static char getInput() {
        Scanner myScanner = new Scanner(System.in, "Cp1250");
        System.out.print("Podaj literę: ");

        char letter = myScanner.next().charAt(0);

        if (!isLetter(letter)) {
            ErrorHandler.errorCodes(0);
        }
        return letter;
    }
}
