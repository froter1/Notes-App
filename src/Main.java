import java.util.Scanner;

public class Main {
    public static Scanner input = new Scanner(System.in);
    protected String username;
    protected boolean isLogged;


    public Main(String username, boolean isLogged) {
        this.username = username;
        this.isLogged = isLogged;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setLogged(boolean logged) {
        this.isLogged = logged;
    }

    public static void main(String[] args) {
        Tests.runPreTests();
        Main user = new Main(null, false);
        String arg;


        while (!user.isLogged) {
            arg = input.next();

            switch (arg) {
                case "login" -> {
                    user.setUsername(Commands.login());
                    if (user.username != (null)) user.setLogged(true);
                }
                case "register" -> Commands.register();
                case "exit" -> Commands.exit();
            }
        }
    }
}
