package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class FileHelper {

    public static void main(String[] args) {
        List<String> something = new ArrayList<>();
        something.add("hello, this is the start");
        something.add("");
        something.add("and this will be the end");
        String file = "example.txt";
        try {
            spit(file, something);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            slurp(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            makeExciting(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected static List<String> slurp(String filepath) throws IOException {
        List<String> lines;
        Path path = Paths.get(filepath);
        lines = Files.readAllLines(path);
        return lines;
    }
    protected static void spit(String filename, List<String> contents) throws IOException {
        Path path = Paths.get(filename);
        Files.write(path, contents);
    }
    protected static void spit(String filename, List<String> contents, boolean append) throws IOException {
        Path path = Paths.get(filename);
        if (append) {
            Files.write(path, contents, StandardOpenOption.APPEND);
        } else {
            spit(filename, contents);
        }
    }
    protected static void makeExciting(String filename) throws IOException {
        Path path = Paths.get(filename);
        List<String> lines = slurp(filename);
        List<String> newlines = new ArrayList<>();
        for (String line : lines) {
            if (!line.isEmpty()) {
                String newline = line.substring(0, 1).toUpperCase() + line.substring(1, line.length()) + "!";
                newlines.add(newline);
            } else newlines.add(" ");
        }
        Files.write(path, newlines);
    }

}
