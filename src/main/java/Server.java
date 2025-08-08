import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void start(int port) throws IOException {
        System.out.println("Listening on port: " + port);
        serverSocket = new ServerSocket(port);
        while (true) {
            clientSocket = serverSocket.accept();
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out.println("hello client");
            String msg = in.readLine();
            System.out.println(msg);
            in.close();
            out.close();
            clientSocket.close();
        }
//        serverSocket.close();
    }

    public static void main(String[] args) {
        int port = 8080;

        try {
            Server serverSocket1 = new Server();
            serverSocket1.start(port);
        } catch (Exception exception) {
            System.out.println("Unable to create  server socket\n" + exception.getMessage());
        }

    }
}
