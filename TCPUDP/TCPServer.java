import java.io.*;
import java.net.*;

public class TCPServer {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(8080);
        System.out.println("Server started on port 8080");
        
        Socket s = ss.accept();
        System.out.println("Client connected");

        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);

        String msg = in.readLine();
        System.out.println("Received: " + msg);

        out.println("Hello from Server");

        s.close();
        ss.close();
    }
}