package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Provera {

    private ArrayList<String> kredencijali = new ArrayList<>();


    public boolean proveri (String username, String password) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Kredencijali.txt"));
            String line = null;
            while ((line = reader.readLine()) != null) {
                kredencijali.add(line);
            }

        } catch (IOException e) {
            System.err.println("Fajl ne postoji");
        }
        String usernamePassword = cleaner(username) + '|' + password;
        return kredencijali.contains(usernamePassword);
    }

    private String cleaner (String string) {
        return string.toLowerCase().trim();
    }

}
