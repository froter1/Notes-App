import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileHandling {

    private static final Scanner input = new Scanner(System.in);

    public static void checkFiles(Main user) {
        String[] files = listOfFiles(user.getUsername());
        for (String fileName : Objects.requireNonNull(files)) {
            System.out.println(fileName.replace(".txt",""));
        }
        if (files.length==0) {
            System.out.println("User "+user.getUsername()+" don't have any notes.");
        }
    }

    public static void newNote(Main user) {
        System.out.print("Note title: ");
        String title = input.nextLine();
        System.out.println(title);
        title = title.strip();
        System.out.println(title);
        if (!checkIllegalChars(title)) {
            try {
                Files.createFile(Paths.get("./content/" + user.getUsername() + "/" + title + ".txt"));
                System.out.println("Note created successfully");
            } catch (IOException e) {
                System.out.println("Something goes wrong, try again...");
            }
        }
    }

    private static String[] listOfFiles(String user) {
        String path = "./content/"+user+"/";
        File file = new File(path);
        return file.list();
    }

    private static boolean checkIllegalChars(String title) {
        final char[] illegalChars = {'/','\\','<','>',':',';','"','\'','|','?','*'};
        for (char symbol : illegalChars) {
            if (title.contains(Character.toString(symbol))) {
                System.out.println("Your title contains illegal character ["+symbol+"]");
                return true;
            }
        } return false;
    }
}
