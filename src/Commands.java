import java.util.Scanner;
public class Commands {
    private final static Scanner input = new Scanner(System.in);

    public static String login() {
        return LoginHandling.loginProtocol(input.next(), input.next());
    }

    public static void register() {
        LoginHandling.registerProtocol(input.next(), input.next());
    }

    public static void exit() {
        System.exit(0);
    }
}
