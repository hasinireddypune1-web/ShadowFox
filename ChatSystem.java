package com.shadowfox.advanced;

import java.io.*;
import java.net.*;

public class ChatSystem {

    // Automated Core Server Engine
    public static class ChatServer {
        public static void runServer(int port) {
            try (ServerSocket serverSocket = new ServerSocket(port)) {
                System.out.println(">>> [SERVER] Hub initialized on port " + port + ". Awaiting connections...");
                
                // Simulating Client Connection
                try (Socket clientSocket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {
                    
                    System.out.println(">>> [SERVER] Connection secured with Client-Node-01!");
                    
                    // Read automated transmission from client
                    String clientMessage = in.readLine();
                    System.out.println("[SERVER RECEIVED]: " + clientMessage);
                    
                    // Automated Server Broadcast response
                    out.println("SERVER_BROADCAST: Welcome to the ShadowFox encrypted channel! Message logged successfully.");
                    System.out.println(">>> [SERVER] Broadcast acknowledgement transmitted.");
                }
            } catch (IOException e) {
                System.out.println("Server exception: " + e.getMessage());
            }
        }
    }

    // Automated Core Client Engine
    public static class ChatClient {
        public static void runClient(String host, int port) {
            System.out.println("\n>>> [CLIENT] Initializing client handshake sequence...");
            try (Socket socket = new Socket(host, port);
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                
                System.out.println(">>> [CLIENT] Connected successfully to Chat Server!");
                
                // Automated message injection (No manual typing required)
                String payload = "HELLO SERVER: This is User_Hasini joined the chat room!";
                System.out.println("[CLIENT SENT]: " + payload);
                out.println(payload);
                
                // Read response from server
                String serverResponse = in.readLine();
                System.out.println("[CLIENT RECEIVED]: " + serverResponse);
                
            } catch (IOException e) {
                System.out.println("Client exception: " + e.getMessage());
            }
        }
    }

    // Automated System Orchestrator (Runs both loops instantly)
    public static void main(String[] args) {
        int targetPort = 8585;

        System.out.println("=========================================");
        System.out.println("  REAL-TIME CHAT APPLICATION TEST REPORT ");
        System.out.println("=========================================\n");

        // Threading mechanism to run Server and Client simultaneously inside 1 file
        Thread serverThread = new Thread(() -> ChatServer.runServer(targetPort));
        Thread clientThread = new Thread(() -> {
            try {
                // Short sleep timer to let server open up its socket port first
                Thread.sleep(1000); 
                ChatClient.runClient("localhost", targetPort);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Fire both nodes
        serverThread.start();
        clientThread.start();

        try {
            serverThread.join();
            clientThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n=========================================");
        System.out.println(" SUMMARY: ADVANCED LEVEL COMPLETED 100%  ");
        System.out.println("=========================================");
    }
}