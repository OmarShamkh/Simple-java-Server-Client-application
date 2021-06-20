package myclient;
/**
 *
 * @author shamkh
 */
import java.net.*;
import java.io.*;

class MyClient {

    public static void main(String args[]) throws Exception {
        
        Socket client = new Socket("localhost" , 3333);
        // Read from client
        DataInputStream ClienReadSource = new DataInputStream(client.getInputStream());
        // Write to client
        DataOutputStream ClientWriteSource = new DataOutputStream(client.getOutputStream());
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        
        String str1 = "" , str2 = "";
        while(!str1.equalsIgnoreCase("stop")){
            str1 = buffer.readLine();
            ClientWriteSource.writeUTF(str1);
            ClientWriteSource.flush();
            str2 = ClienReadSource.readUTF();
            System.out.println("Server says: "+ str2);
        }
        ClientWriteSource.close();
        client.close();

    }
}
