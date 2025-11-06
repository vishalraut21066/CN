import java.io.*;
import java.net.*;

public class TCPClient {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 8080);
        System.out.println("Connected to server");

        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);

        out.println("Hello from Client");
        String reply = in.readLine();
        System.out.println("Received: " + reply);

        s.close();
    }
}