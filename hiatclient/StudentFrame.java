/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hiatclient;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

/**
 *
 * @author gprok
 */
public class StudentFrame extends JFrame {
    
    private JTextField questionField;
    
    private JSlider interestingSlider;
    private JSlider understandingSlider;
    
    public StudentFrame(StudentController control) {
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(4, 1));
        
        centerPanel.add(new JLabel("Interesting:"));
        interestingSlider = new JSlider(1, 5);
        interestingSlider.setMinorTickSpacing(1);
        interestingSlider.setMajorTickSpacing(1);
        interestingSlider.setPaintTicks(true);
        interestingSlider.setPaintLabels(true);
        interestingSlider.setSnapToTicks(true);
        interestingSlider.setPaintTrack(true);
        interestingSlider.setName("I");
        interestingSlider.addChangeListener(control);
        interestingSlider.setToolTipText("Interesting");
        centerPanel.add(interestingSlider);
        
        centerPanel.add(new JLabel("Understanding:"));
        understandingSlider = new JSlider(1, 5);
        understandingSlider.setMinorTickSpacing(1);
        understandingSlider.setMajorTickSpacing(1);
        understandingSlider.setPaintTicks(true);
        understandingSlider.setPaintLabels(true);
        understandingSlider.setSnapToTicks(true);
        understandingSlider.setPaintTrack(true);
        understandingSlider.setName("U");
        understandingSlider.addChangeListener(control);
        understandingSlider.setToolTipText("Understanding");
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
