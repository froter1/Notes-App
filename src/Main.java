import java.util.Scanner;

public class Main {
    public static Scanner input = new Scanner(System.in);
    private String username;
    private boolean isLogged;


    public Main(String username, boolean isLogged) {
        this.username = username;
        this.isLogged = isLogged;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public void setLogged(boolean logged) {
        this.isLogged = logged;
    }

    public static void main(String[] args) {
        Tests.runPreTests();
        Main user = new Main(null, false);
        String arg;

        while (true) {
            arg = input.next();

            if (!user.isLogged) {
                switch (arg) {
                    case "login" -> {
                        user.setUsername(Commands.login());
                        if (user.username != (null)) user.setLogged(true);
                    }
                    case "register" -> Commands.register();
                    case "help" -> Commands.help();
                    case "exit" -> Commands.exit();
                }
            } else {
                switch (arg) {
                    case "logout" -> Commands.logout(user);
                    case "files" -> Commands.files(user);
                    case "help" -> Commands.help();
                    case "exit" -> Commands.exit();
                    case "new" -> Commands.newNote(user);
                }
            }
        }
    }
}
