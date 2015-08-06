/*
 * This software is open source and it is provided as-is without and warranty.
 * Licence file to be added soon.
 */
package hiatclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A thread responsible for the communication with the server
 * 
 * @author gprok
 */
public class StudentThread implements Runnable {
    
    /** The thread responsible to execute the run method */
    private Thread th;
    /** The socket which initiated the connection, where we write and read from */
    private Socket socket;
    /** Writer of the socket, used to send data to the server */
    private PrintWriter out;

    /**
     * Initiates writer to the socket and then keeps the connection open 
     * for writing whenever necessary.
     */
    @Override
    public void run() {
        try {
            Properties prop = new Properties();
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("hiatclient/student.properties");
            prop.load(inputStream);
            
            String serverAddress = prop.getProperty("server_ip");
            int port = Integer.parseInt(prop.getProperty("server_port"));
            socket = new Socket(serverAddress, port);
            
            BufferedReader input =
                            new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String idStr = "";
            while((idStr = input.readLine()) != null) {
                System.out.println(idStr);
                break;
            }
            out = new PrintWriter(socket.getOutputStream(), true);
            while(true) {
                // keep connection open
            }
        } catch (IOException ex) {
            Logger.getLogger(StudentThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    /**
     * Sends a message to the server using the open writer
     * @param msg The message to be send
     */
    public void sendMessage(String msg) {
        out.println(msg);
    }
    
    
    /**
     * Starts the thread
     */
    public void start ()
    {
        if (th == null)
        {
           th = new Thread(this);
           th.start ();
        }
   }
}
