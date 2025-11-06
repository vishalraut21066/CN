// UDPClient.java
import java.net.*;

public class UDPClient {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket();
        InetAddress ip = InetAddress.getByName("127.0.0.1"); // localhost

        String msg = "Hello from UDP Client";
        DatagramPacket dp = new DatagramPacket(msg.getBytes(), msg.length(), ip, 8080);
        ds.send(dp);  // server ko msg bhejna
        System.out.println("Message sent to server!");

        byte[] buf = new byte[1024];
        DatagramPacket dpRecv = new DatagramPacket(buf, buf.length);
        ds.receive(dpRecv);  // server se reply lena

        System.out.println("Server: " + new String(dpRecv.getData(), 0, dpRecv.getLength()));
        ds.close();
    }
}