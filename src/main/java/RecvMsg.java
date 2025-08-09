import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class RecvMsg implements Runnable{
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    RecvMsg(Socket socket) {
        clientSocket = socket;
    }
    @Override
    public void run() {
        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out.println("hello client\n");
            String msg = in.readLine();
            in.close();
            out.close();
            clientSocket.close();
        } catch (Exception exception) {
            System.out.println("Exception while reading: " + exception.getMessage());
        }
    }
}
