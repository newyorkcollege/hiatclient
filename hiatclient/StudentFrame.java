/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hiatclient;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

/**
 *
 * @author gprok
 */
public class StudentFrame extends JFrame {
    
    private JTextField questionField;
    
    private JSlider interestingSlider;
    private JSlider understandingSlider;
    
    public StudentFrame(StudentController control) {
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        JPanel centerPanel = new JPanel();
        
        centerPanel.add(new JLabel("Interesting"));
        interestingSlider = new JSlider(JSlider.VERTICAL);
        interestingSlider.setName("I");
        interestingSlider.addChangeListener(control);
        centerPanel.add(interestingSlider);
        
        centerPanel.add(new JLabel("Understanding"));
        understandingSlider = new JSlider(JSlider.VERTICAL);
        understandingSlider.setName("U");
        understandingSlider.addChangeListener(control);
        centerPanel.add(understandingSlider);
        
        add(centerPanel, BorderLayout.CENTER);
        
        JPanel southPanel = new JPanel();
        
        questionField = new JTextField(30);
        questionField.addKeyListener(control);
        southPanel.add(questionField);
        
        add(southPanel, BorderLayout.SOUTH);
        
        
        setVisible(true);
    }
    
}
