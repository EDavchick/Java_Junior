package org.example.L05;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;
/**
 * Клиент должен уметь:
 * 1. подключение к серверу: клиент должен иметь функционал для подключения в
 * чат-серверу. Это включает в себя установку соединения с сервером,
 * указанием адреса и порта для подключения
 * 2. параллельная обработка сообщений: клиент должен быть способен принимать и
 * отправлять сообщения параллельно. Это означает, что клиент может одновременно
 * отправлять свои и обрабатывать входящие сообщения от других пользователей чата
 * 3. обработка множественных сообщений: клиент должен быть готов к ситуации,
 * когда в процессе ввода своего сообщения могут приходить сообщения от других
 * пользователей. Это предотвращает зацикливание работы клиента на вводе или передаче сообщений
 * 4. корректное закрытие ресурсов: клиент должен иметь механизм корректного закрытия
 * всех используемых ресурсов при завершении работы. Это вкдючает в себя закрытие
 * сокета и других потоков
 * 5. простота использования: клиент должен быть разработан так, чтобы им было легко
 * пользоваться. Он должен предоставлять удобный интерфейс для ввода сообщений,
 * подключения к серверу и отображения полученных сообщений
 */

public class Client {
    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private String name;

    public Client(Socket socket, String name) {
        this.socket = socket;
        this.name = name;
        try {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            closeEverything(socket, bufferedReader, bufferedWriter);
        }
    }

    public void sendMessage(){
        try {
            bufferedWriter.write(name);
            bufferedWriter.newLine();
            bufferedWriter.flush();

            Scanner scanner  = new Scanner(System.in);
            while (socket.isConnected()) {
                String message = scanner.nextLine();
                bufferedWriter.write(name + ": " + message);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            closeEverything(socket, bufferedReader, bufferedWriter);
        }
    }

    public void listenForMessage(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                String messageFromGroup;
                while (socket.isConnected()) {
                    try {
                        messageFromGroup = bufferedReader.readLine();
                        System.out.println(messageFromGroup);
                    } catch (IOException e) {
                        closeEverything(socket, bufferedReader, bufferedWriter);
                    }
                }
            }
        }).start();
    }

    private void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter) {
        try {
            if (bufferedReader != null){
                bufferedReader.close();
            }
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name  = scanner.nextLine();
        Socket socket = new Socket("localhost", 1300);
        Client client = new Client(socket, name);
        client.listenForMessage();
        client.sendMessage();
    }
}
