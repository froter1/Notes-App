import javax.swing.*;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Tests {

    public static void runPreTests() {
        if (!isCriticalFilesExist()) {
            System.out.println("Something goes wrong...");
            Runtime.getRuntime().exit(0);
        }
    }

    private static boolean isCriticalFilesExist() {
        Path path = Paths.get("./accounts");

        if (Files.notExists(path)) {
            try {
                Files.createDirectory(path);
            } catch (IOException e) {
                return false;
            }
        }

        path = Paths.get("./content");

        if (Files.notExists(path)) {
            try {
                Files.createDirectory(path);
            } catch (IOException e) {
                return false;
            }
        }

        return true;
    }
}
