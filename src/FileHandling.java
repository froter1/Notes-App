import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Paths;

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

    public static void editNote(Main user){
        String title = chooseNote(user.getUsername());
        if (title==null) return;
        String fileName = title+".txt";
        String file = "./content/"+user.getUsername()+"/"+fileName;
        Path path = Paths.get(file);

        try {
            Process process = new ProcessBuilder("notepad", file).start();
            FileTime lastModificationTime = Files.getLastModifiedTime(path);

            while (process.isAlive()) {
                Thread.onSpinWait();
            }

            if (isModified(lastModificationTime, Files.getLastModifiedTime(path))) {
                System.out.println("Note saved successfully");
            } else System.out.println("Note haven't been saved");

        } catch (IOException e) {
            System.out.println("The text editor couldn't be opened");
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

    private static String chooseNote(String user) {
        System.out.println("Enter part of the note title");
        Map<String, String> titles = new HashMap<>(similarTitles(input.next(), user));
        if (titles.isEmpty()) {
            System.out.println("No files were found with a matching title");
            return null;
        }

        for (String key : titles.keySet()) {
            System.out.println(key+". "+ titles.get(key));
        }
        System.out.print("Choose note by number: ");
        String key = input.next();
        if (titles.get(key) == null) {
            return null;
        } else return titles.get(key);
    }

    private static Map<String,String> similarTitles(String titleShard, String user) {
        Map<String,String> titlesMap = new HashMap<>();
        String[] titles = listOfFiles(user);
        int counter = 0;
        for (String title : titles) {
            if (title.contains(titleShard)) {
                counter++;
                titlesMap.put(String.valueOf(counter),title.replace(".txt",""));
            }
        } return titlesMap;
    }

    private static boolean isModified(FileTime lastModificationTime, FileTime actualModificationTime) {
        return !lastModificationTime.equals(actualModificationTime);
    }
}
