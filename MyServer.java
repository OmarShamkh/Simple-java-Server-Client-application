package myserver;
/**
 *
 * @author shamkh
 */
import java.net.*;
import java.io.*;

class MyServer {

    public static void main(String args[]) throws Exception {
        
        ServerSocket server = new ServerSocket(3333);
        // Accept Connection
        Socket client = server.accept();
        // Read from client
        DataInputStream ClienReadSource = new DataInputStream(client.getInputStream());
        // Write to client
        DataOutputStream ClientWriteSource = new DataOutputStream(client.getOutputStream());
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        
        String str1 = "" , str2 = "";
        while(!str1.equalsIgnoreCase("stop")){
            str1 = ClienReadSource.readUTF();
            System.out.println("Client says: " + str1);
            str2 = buffer.readLine();
            ClientWriteSource.writeUTF(str2);
            ClientWriteSource.flush();
        }
        ClienReadSource.close();
        client.close();
        server.close();
        
    }
}
