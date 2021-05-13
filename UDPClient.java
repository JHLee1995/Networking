import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPClient {
    public static void main(String[] args) throws IOException {
        InetAddress address = InetAddress.getByName("localhost");
        int portNumber = 8800;
        byte[] data = "Account: admin; Password: 123".getBytes();

        DatagramPacket packet = new DatagramPacket(data, data.length, address, portNumber);
        DatagramSocket socket = new DatagramSocket();
        socket.send(packet);

        byte[] data2 = new byte[1024];
        DatagramPacket packet2 = new DatagramPacket(data2, data2.length);
        socket.receive(packet2);

        String reply = new String(data2, 0, packet2.getLength());
        System.out.println("Server sending......" + reply);
        socket.close();
    }
}