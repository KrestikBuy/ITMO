package classes;

import commands.Commands;

import java.io.*;
import java.util.Scanner;

public class FileReader {
    public void readFile(String filePath) {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath))) {
            int data;
            while ((data = bis.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void execute_script(String filePath) {
        try {
            File file = new File(filePath);
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String data = fileScanner.nextLine();
                System.out.println(data);
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}