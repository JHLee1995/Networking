import java.io.IOException;
import java.net.Socket;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.SocketException;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPClient {
    private int portNumber = 8080;
    private Scanner inputMsg;
    private InetAddress address;
    private DatagramSocket socket;

    private void service() {
        try {
            address = InetAddress.getByName("192.168.0.13");
            socket = new DatagramSocket(8080);
            inputMsg = new Scanner(System.in);
    
            String msg = inputMsg.nextLine();
            DatagramPacket packet 
                = new DatagramPacket(msg.getBytes(), msg.getBytes().length, address, portNumber);
    
            socket.send(packet);
        } catch (Exception e) {
            System.out.println("Error !");
        }
        
    }

    public static void main(String[] args) {
        UDPClient udp = new UDPClient();
        udp.service();
    }
}
