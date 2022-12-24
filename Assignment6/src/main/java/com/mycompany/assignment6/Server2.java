/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.assignment6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class Server2 {

  
    public static void main(String[] args) {
        
        try {
            
            //server2 to client3(server3)
            ServerSocket server = new ServerSocket(3022);
            Socket client3 = server.accept();
            DataOutputStream cOut = new DataOutputStream(client3.getOutputStream()); 
                       
            //from server1
            Socket client2 = new Socket("localhost" , 3021);
            DataInputStream cIn = new DataInputStream(client2.getInputStream());

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
            client3.close();
            server.close();
            
            
        } catch (IOException ex) {
            Logger.getLogger(Server2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
