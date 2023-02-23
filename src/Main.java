import java.util.Scanner;

public class Main {
    public static Scanner input = new Scanner(System.in);
    public static boolean isLogged = false;
    protected final String username;


    public Main(String username) {

        this.username = username;
    }

    public static void main(String[] args) {
        Tests.runPreTests();
        String arg;

        while (!isLogged) {
            arg = input.next();

            switch (arg) {
                case "login":
                    if (Commands.login()) {
                        Main user = new Main(LoginHandling.username);

                        System.out.println(user.username);
                    }
            }
        }
    }
}
