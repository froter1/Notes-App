import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LoginHandling extends Main{
    protected static String username;
    public LoginHandling(String username) {
        super(username);
    }

    public static boolean loginProtocol(String localUsername, String password) {
        username = localUsername;
        if (checkCredentials(username, password)) {
            System.out.println("Successfully logged in to account "+username);
            isLogged = true;
            return true;
        } else {
            return false;
        }
    }

    public static void registerProtocol(String username, String password) {
        if (!Tests.isUserExist(username)) {
            Path path = Paths.get("./accounts/"+username+".txt");

            try {
                Files.createFile(path);
                Files.writeString(path,password);
            } catch (IOException e) {
                System.out.println("Something goes wrong, try again...");
            }
        }
    }

    private static boolean checkCredentials(String username, String password) {
        if (checkUsername(username) && checkPassword(password, username)) {
            return true;
        } else {
            System.out.println("Wrong login or password");
            return false;
        }
    }

    private static boolean checkUsername(String username) {
        return Files.exists(pathCreator(username));
    }

    private static boolean checkPassword(String password, String username) {
        return password.equals(readingFile(pathCreator(username)));
    }

    private static String readingFile(Path path) {
        try {
            return Files.readString(path);
        } catch (IOException e) {
            return null;
        }
    }

    private static Path pathCreator(String fileName) {
        return Paths.get("./accounts/"+fileName+".txt");
    }

}
