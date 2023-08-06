package com.rinseo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {

        // Socket is listening on port 3000 for incoming connections
        try (ServerSocket serverSocket = new ServerSocket(3000)) {

            // When client connects, server accepts the connection
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            String echoString;
            while (true) {
                echoString = input.readLine();
                if (echoString.equals("end")) {
                    break;
                }
                output.println("Echo from server: " + echoString);
            }

        } catch (IOException e) {
            System.out.println("Server exception " + e.getMessage());
        }
    }
}

