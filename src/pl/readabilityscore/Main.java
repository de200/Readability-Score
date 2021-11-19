package pl.readabilityscore;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static String readFileAsString(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

    public static void main(String[] args) throws IOException {

        String fileName = args[0];
        String text = readFileAsString(fileName);
        TextReader reader = new TextReader(text);
        new Evaluation(reader);

    }
}
