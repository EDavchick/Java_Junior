package org.example.L05;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    /**
     * Создать чат-сервер, сервер должен уметь:
     * 1. слушать заданный порт в ожидании запроса на подключение
     * 2. После получения запроса и начала формирования связи с клиентом,
     * сервер должен продолжить слушать порт и быть готовым к новым подключениям
     * 3. Идентифицировать участников чата по имени
     * 4. Формировать оповещение о подключенных участниках чата
     * 5. При подключении участника уметь оповестить оставшихся участников об этом
     * 6. Уметь передавать сообщения всем участникам, кроме него самого
     */

    private ServerSocket serverSocket;

    public Server(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public void runServer(){
        try {
            while (!serverSocket.isClosed()) {
                Socket socket = serverSocket.accept();
                System.out.println("Connected new client");
                ClientManager client = new ClientManager(socket);
                Thread thread = new Thread(client);
                thread.start();
            }
        } catch (IOException e) {
            closeSocket();
        }
    }

    public void closeSocket(){
        try {
            if (serverSocket != null) {
                serverSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1300);
        Server server = new Server(serverSocket);
        server.runServer();
    }

}
