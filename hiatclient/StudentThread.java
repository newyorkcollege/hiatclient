/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hiatclient;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gprok
 */
public class StudentThread implements Runnable {
    
    private Thread th;
    private Socket socket;
    private PrintWriter out;

    @Override
    public void run() {
        try {
            String serverAddress = "127.0.0.1";
            socket = new Socket(serverAddress, 9090);
            out = new PrintWriter(socket.getOutputStream(), true);
            while(true) {
                // keep connection open
            }
        } catch (IOException ex) {
            Logger.getLogger(StudentThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void sendMessage(String msg) {
        out.println(msg);
    }
    
    
    public void start ()
    {
        if (th == null)
        {
           th = new Thread(this);
           th.start ();
        }
   }
}
