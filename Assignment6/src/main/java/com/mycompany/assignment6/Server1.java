
package com.mycompany.assignment6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Server1 {

    public static void main(String[] args) {
        
        try {
            
            
            // server4 sends to client1
            Socket client1 = new Socket("localhost" , 3024);
            DataInputStream cIn = new DataInputStream(client1.getInputStream());
            
            //server to client2(server2)
            ServerSocket server = new ServerSocket(3021);
            Socket client2 = server.accept();
            DataOutputStream sOut = new DataOutputStream(client2.getOutputStream());
            
            
            Random rand = new Random();
            int count = 0;
            while(true){
                count++;
                int x = rand.nextInt(10)+1;
                sOut.writeInt(x);
                System.out.println(x);
                int n = cIn.readInt();
                if(n > 25 && n < 35){
                    sOut.writeUTF("stop");
                    System.out.println("Stop");
                    System.out.println("Answer: " + n);
                    System.out.println("Counter: " + count);
                    break;
                }
                else{
                    sOut.writeUTF("");
                }
            }
            
            cIn.close();
            sOut.close();
            client2.close();
            server.close();
            
            
        } catch (IOException ex) {
            Logger.getLogger(Server1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
