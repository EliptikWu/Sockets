package org.example;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {
    public static void main(String[] args){
        final String host = "127.0.0.1";//Host del servidor
        final int port = 5050;//Puerto del servidor
        DataInputStream in;
        DataOutputStream out;

        {
            try {
                while(true) {
                    Socket socket = new Socket(host, port);//Creo el socket para conectarme con el cliente

                    in = new DataInputStream(socket.getInputStream());
                    out = new DataOutputStream(socket.getOutputStream());

                    out.writeUTF("Hi Client");//Envio un mensaje al cliente

                    String message = in.readUTF();//Recibo el mensaje del servidor

                    System.out.println(message);
                    socket.close();

                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        }
    }

