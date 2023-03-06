import java.io.File;
import java.util.Objects;

public class FileHandling {

    public static void checkFiles(Main user) {
        String path = "./content"+user.getUsername()+"/";

        String[] files;
        File file = new File(path);

        files = file.list();


        try{
            for (String fileName : Objects.requireNonNull(files)) {
                System.out.println(fileName.replace(".txt",""));
            }
        } catch (NullPointerException e) {
            System.out.println("User "+user.getUsername()+" don't have any notes.");
        }
    }
}
