package org.example;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {

        ServerSocket servidor = null;
        Socket socket = null;
        DataInputStream in;
        DataOutputStream out;

        final int port = 5050;//puerto de nuestro servidor

        try {

            servidor = new ServerSocket(port);
            System.out.println("Start Server");

            while(true){ //Siempre estara escuchando peticiones
                socket = servidor.accept(); //Espero a que un cliente se conecte

                System.out.println("Client Connected");
                in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());

                String message = in.readUTF(); //Leo el mensaje que me envia
                System.out.println(message);

                out.writeUTF("Hi Everyone"); //Le envio un mensaje

                socket.close();//Cierro el socket
                System.out.println("Client disconnected ");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}