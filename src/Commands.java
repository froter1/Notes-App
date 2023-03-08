import java.util.Scanner;
public class Commands {
    private final static Scanner input = new Scanner(System.in);

    public static String login() {
        System.out.println("Input your login and password");
        return LoginHandling.loginProtocol(input.next(), input.next());
    }

    public static void register() {
        System.out.println("Input login and password");
        LoginHandling.registerProtocol(input.next(), input.next());
    }

    public static void help() {
        System.out.println("----------");
        System.out.println("""
                login - Login user (Takes login and password)
                register - Register user (Takes login and password)
                help - Show command list
                files - Show user notes
                new - Create new note
                edit - Edit note
                exit - Exit program""");
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

    public static void editNote(Main user) {
        FileHandling.editNote(user);
    }
}
