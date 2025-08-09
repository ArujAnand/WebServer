import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private ServerSocket serverSocket;

    public void start(int port) throws IOException {
        System.out.println("Listening on port: " + port);
        serverSocket = new ServerSocket(port);
        ExecutorService executor = Executors.newFixedThreadPool(250);
        while (true) {
            RecvMsg client = new RecvMsg(serverSocket.accept());
            executor.submit(client);
        }
    }

    public static void main(String[] args) {
        int port = 9999;

        try {
            Server serverSocket1 = new Server();
            serverSocket1.start(port);
        } catch (Exception exception) {
            System.out.println("Unable to create server socket\n" + exception.getMessage());
        }

    }
}
