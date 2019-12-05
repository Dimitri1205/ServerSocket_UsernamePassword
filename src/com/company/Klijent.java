package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Klijent extends Thread  {

    private Socket socket;
    private String username, password;
    private int select = 3;

    public Klijent(Socket socket) {
        this.socket = socket;
    }



    @Override
    public void run() {
        Upis upis = new Upis();
        Provera provera = new Provera();

        try {
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            while (select != 0) {
                boolean check = false;

                while (!check) {
                    try {
                        output.println("1 - Novi unos Korisnickog imena i lozinke");
                        output.println("2 - Provera Korisnickog imena i lozinke");
                        output.println("0 - Izlaz");
                        select = Integer.parseInt(input.readLine());
                        output.println();
                        check = true;
                    } catch (Exception e) {
                        output.println("niste uneli broj");

                    }
                }
                if (select == 1) {
                    output.println("Unesite korisnicko ime" );
                    username = input.readLine();
                    output.println();
                    output.println("Unesite lozinku");
                    password = input.readLine();
                    output.println();
                    upis.sacuvaj(username, password);
                    output.println(upis.isCheck() ? "Novo korisnicko ime: \"" + username + "\" je kreirano" : "Korisnicko ime ne moze biti kreirano");
                } else if (select == 2) {
                    output.println("Unesite korisnicko ime");
                    username = input.readLine();
                    output.println();
                    output.println("Unesite lozinku");
                    password = input.readLine();
                    output.println();
                    output.println(provera.proveri(username, password) ? "Ispravna lozinka za " + username : "Pogresno Korisnicko ime/Lozinka");
                }
            }
            input.close();
            output.close();
            socket.close();

        } catch (Exception e) {
            System.err.println(e);
        }


    }
}
