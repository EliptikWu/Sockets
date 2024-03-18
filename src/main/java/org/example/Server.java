package org.example;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Servidor {
    public static void main(String[] args) {

        ServerSocket servidor = null;
        Socket socket = null;
        final int PUERTO = 5000;
        DataInputStream in;
        DataOutputStream out;


        try {
            servidor = new ServerSocket(PUERTO);
            System.out.println("Serivodr iniciando");

            while(true){
                socket = servidor.accept();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}