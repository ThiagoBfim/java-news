package com.bomfim.java11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 *<a href="https://www.baeldung.com/java-11-new-features#2-new-file-methods">New File Methods</a>
 */
public class NewsFile {

    public String writeAndReadFromFile(String text) throws IOException {
        Path tempFile = Files.createTempFile("demo", ".txt");
        Files.writeString(tempFile, text);
        String finalText = Files.readString(tempFile);
        Files.deleteIfExists(tempFile);
        return finalText;
    }


}
