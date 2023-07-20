package com.jerry.study.jse.net.chat.chat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * ClassName: ChatServer
 * Package: com.jerry.jse.net.chat
 * Description:
 *
 * @Author: Jerry
 * @Date: 2023/4/16
 */
public class ChatServer {
    static ArrayList<Socket> online = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8989);

        while (true) {
            Socket socket = server.accept();
            online.add(socket);

            MessageHandler mh = new MessageHandler(socket);
            mh.start();
        }

    }

    static class MessageHandler extends Thread{
        private final Socket socket;

        public MessageHandler(Socket socket) {
            super();
            this.socket = socket;
        }

        @Override
        public void run() {
            String address = null;
            try {
                address = socket.getInetAddress().getHostAddress();
                sendToOther(address + "上线了！");
                InputStream inputStream = socket.getInputStream();
                Scanner scan = new Scanner(inputStream);
                while (scan.hasNextLine()) {
                    String message = socket.getInetAddress() + ": " + scan.nextLine();
                    sendToOther(message);
                }
                sendToOther(address + "下线了！");
            } catch (IOException e) {
                if (address != null) {
                    try {
                        sendToOther(address + "掉线了！");
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            } finally {
                online.remove(socket);
            }
        }

        private void sendToOther(String message) throws IOException {
            for (Socket socket1: online) {
                if (socket1 != socket) {
                    OutputStream outputStream1 = socket1.getOutputStream();
                    PrintStream ps1 = new PrintStream(outputStream1);
                    ps1.println(message);
                }
            }
        }
    }
}
