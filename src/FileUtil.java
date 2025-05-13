import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileUtil {
    public static boolean isFileExist(String input) {
        String inputName = input;
        File folder = new File("PlayerData");
        boolean found = false;

        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.getName().equals(inputName)) {
                        found = true;
                        break;
                    }
                }
            }
        }

        if (found) {
            System.out.println("File found!");
            return true;
        } else {
            System.out.println("File not found.");
            return false;
        }
    }

    public static String getLine(int lineNumber, String filePath) throws Exception{
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            int currentLine = 1;
            String line;
            while ((line = reader.readLine()) != null) {
                if (currentLine == lineNumber) {
                    return line;
                }
                currentLine++;
            }
            return null; // Line number not found
        } 
        finally {
            reader.close();
        }

        // try {
        //     List<String> allLines = Files.readAllLines(Paths.get("sample.txt"));

        //     for (String line : allLines) {
        //         System.out.println(line);
        //     }
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }
    }
}
