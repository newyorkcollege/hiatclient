/*
 * This software is open source and it is provided as-is without and warranty.
 * Licence file to be added soon.
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
 * The user interface of the client side part (student)
 * Displays 2 sliders for interesting and understanding values respectively,
 * and a text field for messages. 
 * 
 * @author gprok
 */
public class StudentFrame extends JFrame {
    
    /** Text field where the student writes a message for the tutor */
    private JTextField questionField;
    /** Slider where the student sets the leven of interest for the current topic */
    private JSlider interestingSlider;
    /** Slider where the student sets the leven of understanding for the current topic */
    private JSlider understandingSlider;
    
    
    /**
     * Constructor. 
     * Initializes the frame and the included widgets.
     * 
     * @param control Listener for both the sliders and the text field.
     */
    public StudentFrame(StudentController control) {
        setSize(300, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(6, 1));
        
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
                
        questionField = new JTextField(24);
        questionField.addKeyListener(control);
        centerPanel.add(new JLabel("Send Message:"));
        centerPanel.add(questionField);
        
        add(centerPanel, BorderLayout.CENTER);

        setVisible(true);
    }
    
}
