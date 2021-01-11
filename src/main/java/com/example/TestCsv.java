package com.example;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class TestCsv {

    private static final Map<String, String> AUTHOR_BOOK_MAP = new HashMap<>();
    private static final String[] HEADERS = { "author", "title" };
    private static final String PATH_TO_DIR = System.getProperty("user.home")
        + File.separator
        + "Hackdays"
        + File.separator
        + "hackday-20201115"
        + File.separator
        + "books.csv";

    static {
        AUTHOR_BOOK_MAP.put("Dan Simmons", "Hyperion");
        AUTHOR_BOOK_MAP.put("Douglas Adams", "The Hitchhiker's Guide to the Galaxy");
    }

    public static void main(String[] args) throws Exception {
        FileWriter out = new FileWriter(PATH_TO_DIR, StandardCharsets.UTF_8, false);
        try (CSVPrinter printer = new CSVPrinter(out, CSVFormat.DEFAULT.withHeader(HEADERS).withDelimiter(';'))) {
            AUTHOR_BOOK_MAP.forEach((author, title) -> {
                try {
                    printer.printRecord(author, title);
                } catch (IOException e) {
                    throw new UncheckedIOException(e);
                }
            });
        }
    }
}
