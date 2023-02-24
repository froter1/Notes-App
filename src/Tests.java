import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Tests {

    public static void runPreTests() {
        isCriticalFilesExist();
    }

    public static void criticalExitApplication() {
        System.out.println("Something goes wrong...");
        Runtime.getRuntime().exit(0);
    }

    public static boolean isUserExist(String username) {
        Path path = Paths.get("./accounts/"+username+".txt");

        if (Files.exists(path)) {
            System.out.println("User "+username+" already exists...");
            return true;
        }

        return false;
    }


    private static void isCriticalFilesExist() {
        Path path = Paths.get("./accounts");

        if (Files.notExists(path)) {
            try {
                Files.createDirectory(path);
            } catch (IOException e) {
                criticalExitApplication();
            }
        }

        path = Paths.get("./content");

        if (Files.notExists(path)) {
            try {
                Files.createDirectory(path);
            } catch (IOException e) {
                criticalExitApplication();
            }
        }
    }
}
