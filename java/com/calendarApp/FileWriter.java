package com.calendarApp;

import java.io.*;

/**
 * Created by ivan on 15.10.15.
 */
public class FileWriter {
    private  String fileName;
    private FileOutputStream fileStream;

    public FileWriter() {
        this.fileName = "fileCalendar2.html";
    }

    public FileWriter(String fileName) {
        this.fileName = fileName;
    }

    public PrintStream createPrintStream() throws IOException {
        fileStream = new FileOutputStream(createFile());
        return new PrintStream(fileStream);
    }

    private File createFile(String fileName) throws IOException {
        File file = new File(fileName);
        if (!file.exists()) {
            file.createNewFile();
        }
        return file;
    }

    private File createFile() throws IOException {
        File file = new File(fileName);
        if (!file.exists()) {
            file.createNewFile();
        }
        return file;
    }

}
