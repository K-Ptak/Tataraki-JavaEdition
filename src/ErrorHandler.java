public class ErrorHandler {
    public static void errorCodes(int id){
        switch (id) {
            case 0 -> System.out.println("Nie podales litery!");
            case 1 -> System.out.println("Nie ma ani jednego slowa na podana litere w slowniku");
        }
        System.exit(0);
    }
}
