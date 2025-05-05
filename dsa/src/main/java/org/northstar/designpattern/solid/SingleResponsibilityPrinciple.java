package org.northstar.designpattern.solid;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Lets say you have to persistent the journal
 * Should that be part of Journal Class??
 *
 * Good to move to a new class -> Persistence
 */

public class SingleResponsibilityPrinciple {
    public static void main(String[] args) {
        Journal journal = new Journal();
        journal.addEntry("I am happy");
        journal.addEntry("happy me");
        System.out.println(journal.toString());

        // This is bad design
        try {
            journal.save("test.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            new Persistence().save("Test.txt", true, journal);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

class Persistence {
    public void save(String filename, boolean override, Object object) throws FileNotFoundException {
        if(override || new File(filename).exists()) {
            try(PrintStream ps = new PrintStream(filename)) {
                ps.println(object.toString());
            }
        }
    }
}

class Journal {
    private List<String> entries = new ArrayList<>();
    private static int count = 0;

    //public void load(String filename)
    //public void load(URL uri)
    // After having Persistence, this method is not needed
    public void save(String filename) throws FileNotFoundException {
        try(PrintStream ps = new PrintStream(filename)) {
            ps.println(toString());
        }
    }
    public void addEntry(String text) {
        entries.add(text);
        count++;
    }

    public void removeEntry(int index) {
        entries.remove(index);
        count--;
    }

    @Override
    public String toString() {
        return String.join(System.lineSeparator(), entries);
    }
}