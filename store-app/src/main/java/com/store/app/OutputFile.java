package com.store.app;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Vector;


public class OutputFile {
    private Vector<String> content;
    String path;

    public OutputFile(String path) {
        content = new Vector<String>();
        this.path = path;
    }
    
    public void writeToFile(String string) {
        content.add(string);
    }

    public void saveFile(String fileName) {
        LocalTime time = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        try (FileWriter file = new FileWriter(this.path + time.format(formatter) + "_" + fileName)) {
            for (String line: content) file.write(line + '\n');
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}