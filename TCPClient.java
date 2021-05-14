import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {
    Socket socket;
    PrintWriter writer;
    
    private void request() {
        System.out.println("Connecting......");

        try {
            socket = new Socket("192.168.0.13", 8080);
            writer = new PrintWriter(socket.getOutputStream(), true);
            System.out.println("Connected");

            Scanner inputMsg = new Scanner(socket.getInputStream());
            System.out.println(inputMsg.nextLine());
            Scanner receivedMsg = new Scanner(System.in);

            while (true) {
                String data = receivedMsg.nextLine();
                writer.println(data);
                writer.flush();

                String _data = inputMsg.nextLine();
                System.out.println("Server: " + _data);
                System.out.println("Client: ");
;           }           
        } catch (Exception e) {
            System.out.println("Disconnected !");
        }
    }

    public static void main(String[] args) {
        TCPClient tcp = new TCPClient();
        tcp.request();
    }
}
