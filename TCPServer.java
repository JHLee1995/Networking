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
                Scanner receivedMsg = new Scanner(socket.getInputStream());

                while (true) {
                    String data = receivedMsg.nextLine();
                    System.out.println("Client: " + data);

                    System.out.println("Server : ");
                    String _data = inputMsg.nextLine();

                    writer.println(_data);
                    writer.flush();
                }
            }
        } catch (Exception e) {
            System.out.println("Disconnected !");
        }
    }

    public static void main(String[] args) {
        TCPServer tcp = new TCPServer();
        tcp.service();
    }
}
