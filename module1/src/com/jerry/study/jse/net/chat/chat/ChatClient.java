package com.jerry.study.jse.net.chat.chat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * ClassName: ChatClient
 * Package: com.jerry.jse.net.chat
 * Description:
 *
 * @Author: Jerry
 * @Date: 2023/4/16
 */
public class ChatClient {

    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket("127.0.0.1", 8989);

        Receive receive = new Receive(socket);
        receive.start();

        Send send = new Send(socket);
        send.start();

        send.join();

        socket.close();
    }
}

class Receive extends Thread {
    private final Socket socket;

    public Receive(Socket socket) {
        super();
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream inputStream = socket.getInputStream();
            Scanner scan = new Scanner(inputStream);

            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Send extends Thread {
    private final Socket socket;

    public Send(Socket socket) {
        super();
        this.socket = socket;
    }

    @Override
    public void run() {

        try {
            Scanner scan = new Scanner(System.in);

            OutputStream outputStream = socket.getOutputStream();
            PrintStream ps = new PrintStream(outputStream);

            while (true) {
                System.out.print("自己的话：");
                String str = scan.nextLine();
                if ("bye".equals(str)) {
                    break;
                }
                ps.println(str);
            }
            scan.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
