/*
 * This software is open source and it is provided as-is without and warranty.
 * Licence file to be added soon.
 */
package hiatclient;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Controls the execution of the client app and also acts as a listener
 * for slider and keyboard (text field) events.
 * 
 * @author gprok
 */
public class StudentController implements ChangeListener, KeyListener {
    
    /** A reference to the main frame (window) of the app */
    private StudentFrame frame;
    /** A thread which is responsible for the connectivity with the server */
    private StudentThread thread;
    
    
    /**
     * Constructor.
     * Instantiates the main components of the app, and starts the 
     * network thread.
     */
    public StudentController() {
        frame = new StudentFrame(this);
        thread = new StudentThread();
        thread.start();
    }

    /**
     * Handles slider events and sends respective value change to the server
     * @param e The event that triggered the listener
     */
    @Override
    public void stateChanged(ChangeEvent e) {
        JSlider source = (JSlider)e.getSource();
        
        // accept only the value at the final state of the slider
        if(!source.getValueIsAdjusting()) {
            System.out.println(source.getName() + "#" + source.getValue());

            thread.sendMessage(source.getName() + "#" + source.getValue());
        }
    }

    
    @Override
    public void keyTyped(KeyEvent e) {
        // do nothing
    }

    
    /**
     * Handles keyboard events from the text field and upon ENTER pressed 
     * sends the message to the server
     * @param e The event that triggered the listener
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER) {
            JTextField field = (JTextField)e.getSource();
            
            System.out.println("message#" + field.getText());
            
            thread.sendMessage("message#" + field.getText());
            
            field.setText("");
        }
    }

    
    @Override
    public void keyReleased(KeyEvent e) {
        // do nothing
    }
    
}
