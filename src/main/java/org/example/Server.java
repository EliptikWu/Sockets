package org.example;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Server {
    public static void main(String[] args) {

        ServerSocket servidor = null;
        Socket socket = null;
        DataInputStream in;
        DataOutputStream out;

        final int port = 5050;

        try {

            servidor = new ServerSocket(port);
            System.out.println("Start Server");

            while(true){
                socket = servidor.accept();  //Espero a que un cliente se conecte

                System.out.println("Client Connected");
                in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());

                String message = in.readUTF();
                System.out.println(message);

                out.writeUTF("Hi Everyone");

                socket.close();
                System.out.println("Client disconnected ");
            }
        } catch (IOException e) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE,null,e);
        }
    }
}