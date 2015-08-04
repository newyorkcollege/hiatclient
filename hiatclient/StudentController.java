/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hiatclient;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author gprok
 */
public class StudentController implements ChangeListener, KeyListener {
    
    private StudentFrame frame;
    private StudentThread thread;
    
    public StudentController() {
        frame = new StudentFrame(this);
        thread = new StudentThread();
        thread.start();
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        JSlider source = (JSlider)e.getSource();
        
        if(!source.getValueIsAdjusting()) {
            System.out.println(source.getName() + "#" + source.getValue());

            thread.sendMessage(source.getName() + "#" + source.getValue());
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // do nothing
    }

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
