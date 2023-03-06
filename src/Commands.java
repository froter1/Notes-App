import java.util.Scanner;
public class Commands {
    private final static Scanner input = new Scanner(System.in);

    public static String login() {
        return LoginHandling.loginProtocol(input.next(), input.next());
    }

    public static void register() {
        LoginHandling.registerProtocol(input.next(), input.next());
    }

    public static void help() {
        System.out.println("----------");
        System.out.println("login\nregister\nhelp\nexit");
        System.out.println("----------");
    }

    public static void exit() {
        System.exit(0);
    }

    public static void logout(Main user) {
        LoginHandling.logout(user);
    }

    public static void files(Main user) {
        FileHandling.checkFiles(user);
    }

    public static void newNote(Main user) {
        FileHandling.newNote(user);
    }
}
