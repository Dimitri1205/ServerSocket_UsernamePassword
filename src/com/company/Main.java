package com.company;

import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(9090);
            System.out.println("Cekam konekciju klijenta");

            boolean loop = false;
            while (!loop) {
                Socket socket = serverSocket.accept();
                System.out.println("Klijent je konektovan");
                Klijent klijent = new Klijent(socket);
                klijent.start();
            }
        } catch (Exception e) {
            System.err.println(e);
        }


    }
}
