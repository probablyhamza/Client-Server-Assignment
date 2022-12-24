
package com.mycompany.assignment6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server4 {

  
    public static void main(String[] args) {
       //server3 to client1(server1)
            ServerSocket server4;
        try {
            server4 = new ServerSocket(3024);
            Socket client4 = server4.accept();
            DataOutputStream cOut = new DataOutputStream(client4.getOutputStream()); 
            
            //from server2
            Socket client3 = new Socket("localhost" , 3022);
            DataInputStream cIn = new DataInputStream(client3.getInputStream());
            
            Random rand = new Random();
            
            while(true){
                int newRand = rand.nextInt(10)+1;
                int x = cIn.readInt();
                int total = x + newRand;
                cOut.writeInt(total);
                
                String str = cIn.readUTF();
                cOut.writeUTF(str);
                if(str.equals("stop")){
                    System.out.println(str);
                    break;
                }
                
            }
            
            cIn.close();
            cOut.close();
            client4.close();
            server4.close();
        } catch (IOException ex) {
            Logger.getLogger(Server4.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
}
