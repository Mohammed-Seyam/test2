package librarysystem;

import java.io.*;
import java.util.*;

public class ReadAndWriteFile {
    public static void writeUserToFile(ArrayList<User> users){
        try (FileWriter writer = new FileWriter(Main.userFile)) {
            for (User user : users) {
                writer.write(user.getId() + "," + user.getUsername() + "," + user.getPassword() + "," + user.getRole() + "\n");
            }
        } catch (IOException ex) {
            System.out.println("Not found user ..");
        }
    }

    public static ArrayList<String> readFile(String fileName) throws IOException {
        ArrayList<String> data = new ArrayList<>();
        File file = new File(fileName);
        if (!file.exists()) {
            file.createNewFile();
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                data.add(line);
            }
        } catch (IOException error) {
            System.out.println("Error reading file: " + fileName);
        }
        return data;
    }

    public static void writrFile(String fileName, String data, boolean append) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, append))) {
            writer.write(data);
            writer.newLine();
        } catch (IOException error) {
            System.out.println("An error occurred while writing..");
        }
    }

    public static boolean isItemExists(String fileName, String search) {
        try {
            ArrayList<String> lines = readFile(fileName);
            for (String line : lines) {
                if (line.contains(search)) {
                    return true;
                }
            }
        } catch (Exception error) {
            System.out.println("An error occurred while search..");
        }
        return false;
    }
}