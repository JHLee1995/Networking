import java.io.*;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class GreetingClient {

    private String host = "localhost";
    private int port = 8189;// default port

    public GreetingClient() {

    }

    // link to server and port
    public GreetingClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void chat() {
        try {
            // link to server
            Socket socket = new Socket(host, port);

            try {
                // read message from server DataInputStream
                DataInputStream in = new DataInputStream(socket
                        .getInputStream());
                // message from server DataOutputStream
                DataOutputStream out = new DataOutputStream(socket
                        .getOutputStream());

                // for cmd input
                Scanner scanner = new Scanner(System.in);

                while (true) {
                	System.out.println("input message"); 
                    String send = scanner.nextLine();
                    System.out.println("send to server£º" + send);
                    // get message from cmd and send to client
                    out.writeUTF("message from client£º" + send + ";" + new Date().getTime());
                    // read message
                    String accpet = in.readUTF();
                    System.out.println(accpet);
                }

            } finally {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input IP address");
        String host = scanner.nextLine();
        
        
        new GreetingClient(host, 8189).chat();
    }
}
