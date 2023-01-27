package Handlers;

public class ErrorHandler {
    public static void errorCodes(int id) {
        switch (id) {
            case 0 -> System.out.println("Nie podałeś litery!");
            case 1 -> System.out.println("Nie ma ani jednego slowa na podaną literę w słowniku");
        }
        System.exit(0);
    }
}
