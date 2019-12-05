package com.company;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Upis {

    private boolean check;


    public void sacuvaj (String username, String password) {
        try {
            FileOutputStream output = new FileOutputStream("Kredencijali.txt", true);

            output.write(cleaner(username).getBytes());
            output.write('|');
            output.write(cleaner(password).getBytes());
            output.write('\n');
            System.out.println("Novo korisnicko ime i lozinka su kreirani");
            output.close();
            check = true;

        } catch (IOException e) {
            System.err.println(e);
            check = false;
        }
    }

    private String cleaner (String string) {
        return string.toLowerCase().trim();
    }

    public boolean isCheck() {
        return check;
    }
}
