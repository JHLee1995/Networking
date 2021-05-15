import java.net.Socket;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.SocketException;
import java.net.InetAddress;


public class UDPServer {
    private DatagramSocket socket;
    private int portNumber = 8080;

    private void service(){
        try {
            socket = new DatagramSocket(portNumber);
            System.out.println("Server running at: " + InetAddress.getLocalHost());
            String message;
    
            while (true) {
                byte[] data = new byte[256];
                DatagramPacket packet = new DatagramPacket(data, data.length);
    
                socket.receive(packet);
                message = new String(packet.getData()).trim();
    
                System.out.println("Receive from: " + packet.getAddress().getHostAddress() + message);
            }
        } catch (Exception e) {
            System.out.println("Error !");
        }
        
    }
        
    public static void main(String[] args) {
        UDPServer udp = new UDPServer();
        udp.service();
    }
}