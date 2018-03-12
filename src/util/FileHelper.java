package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class FileHelper {
    protected static List<String> slurp(String filepath) {
        try {
            List<String> lines;
            Path path = Paths.get(filepath);
            lines = Files.readAllLines(path);
            return lines;
        } catch (IOException e) {
            System.out.println("Unable to read the file, check the path and run the command again");
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }
    protected static void spit(String filename, List<String> contents) {
        Path path = Paths.get(filename);
        try {
            Files.write(path, contents);
        } catch (Exception e) {
            System.out.println("Unable to write the file, check the path and run the command again");
            e.printStackTrace();
            System.exit(1);
        }
    }
    protected static void spit(String filename, List<String> contents, boolean append) {
        Path path = Paths.get(filename);
        if (append) {
            try {
                Files.write(path, contents, StandardOpenOption.APPEND);
            } catch (Exception e) {
                System.out.println("Unable to write the file, check the path and run the command again");
                e.printStackTrace();
                System.exit(1);
            }
        } else {
            spit(filename, contents);
        }
    }
    protected static void makeExciting(String filename) {
        Path path = Paths.get(filename);
        List<String> lines = slurp(filename);
        List<String> newlines = new ArrayList<>();
        for (String line : lines) {
            if (!line.isEmpty()) {
                String newline = line.substring(0, 1).toUpperCase() + line.substring(1, line.length()) + "!";
                newlines.add(newline);
            } else newlines.add(" ");
        }
        try {
            Files.write(path, newlines);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        List<String> something = new ArrayList<>();
        something.add("hello, this is the start");
        something.add("");
        something.add("and this will be the end");
        String file = "example.txt";
        spit(file, something);
        slurp(file);
        makeExciting(file);
    }
}
