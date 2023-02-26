import java.io.File;

public class FileHandling {

    public static void checkFiles(Main user) {
        String path = "./content";

        String[] files;
        File file = new File(path);

        files = file.list();

        for (String fileName : files) {
            System.out.println(fileName.replace(".txt",""));
        }
    }
}
