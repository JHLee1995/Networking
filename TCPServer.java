import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCPServer {
    ServerSocket server;
    Socket socket;
    PrintWriter writer;

    private void service() {
        try {
            server = new ServerSocket(8080);
            System.out.println("Server Established");

            while (true) {
                System.out.println("Waiting Client......");
                socket = server.accept();
                writer = new PrintWriter(socket.getOutputStream(), true);
                writer.println("Connected");
                writer.flush();

                Scanner inputMsg = new Scanner(System.in);
                Scanner _inputMsg = new Scanner(socket.getInputStream());

                while (true) {
                    String data = _inputMsg.nextLine();
                    System.out.println("Server: " + data);

                    System.out.println("Client: ");
                    String _data = inputMsg.nextLine();

                writer.println(_data);
                    writer.flush();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TCPServer tcp = new TCPServer();
        tcp.service();
    }
}