import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class GreetingServer extends Thread {

    private int port = 8189;// default port

    public GreetingServer() {
    }

    // special port server
    public GreetingServer(int port) {
        this.port = port;
    }

    
    public void service() {
        try {// server link 
            ServerSocket server = new ServerSocket(port);
            // wait client link
            Socket socket = server.accept();
            try {
                // read client DataInputStream
                DataInputStream in = new DataInputStream(socket
                        .getInputStream());
                // send message to client DataOutputStream
                DataOutputStream out = new DataOutputStream(socket
                        .getOutputStream());
                // get input Scanner
                Scanner scanner = new Scanner(System.in);
                while (true) {
                    // read message from client
                    String accpet = in.readUTF();
                    String[] strArr = accpet.split(";");
                    System.out.println(strArr[0]);
                    System.out.println("time:" + (new Date().getTime() - Long.parseLong(strArr[1])) + "ms");
                    String send = scanner.nextLine();
                    System.out.println("server send message£º" + send);
                    // send message from server to client
                    out.writeUTF("server send message£º" + send);
                }
            } finally {// if link fail can not be use socket.close();
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new GreetingServer().service();
    }
}
