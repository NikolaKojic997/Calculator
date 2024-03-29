
package calculator;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class Calculator {
    
    private JFrame frame;
    private JPanel panel;
    private JButton addButton, subtractButton;
    private JLabel firstNumber, secondNumber, resultLabel;
    private JTextField firstNumberTextField,secondNumberTextField, resultTextField; 
    
    public Calculator(){
        gui();
    }
    
    public void gui(){
        frame = new JFrame("Calculator");
        
        frame.setSize(600,400);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        
        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 10, 20));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        
        
        firstNumber = new JLabel("FirstNumber:",SwingConstants.CENTER);
        firstNumber.setFont(new Font("SansSerif", Font.BOLD, 20));
        firstNumberTextField = new JTextField();
        firstNumberTextField.setFont(new Font("SansSerif", Font.BOLD, 20));
        secondNumber = new JLabel("SeondNumber:", SwingConstants.CENTER);
        secondNumber.setFont(new Font("SansSerif", Font.BOLD, 20));
        secondNumberTextField = new JTextField();
        secondNumberTextField.setFont(new Font("SansSerif", Font.BOLD, 20));
        resultLabel = new JLabel("Resault:", SwingConstants.CENTER);
        resultLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
        resultTextField = new JTextField();
        resultTextField.setFont(new Font("SansSerif", Font.BOLD, 20));
        resultTextField.setEditable(false);
        addButton = new JButton("Add");
        addButton.setFont(new Font("SansSerif", Font.PLAIN, 20));
        subtractButton = new JButton("Substract");
        subtractButton.setFont(new Font("SansSerif", Font.PLAIN, 20));
        
        panel.add(this.firstNumber);
        panel.add(this.firstNumberTextField);
        panel.add(this.secondNumber);
        panel.add(this.secondNumberTextField);
        panel.add(this.resultLabel);
        panel.add(this.resultTextField);
        panel.add(this.addButton);
        panel.add(this.subtractButton);
        
        frame.add(panel);
        frame.setVisible(true);
        
        this.addButton.addActionListener(new ActionListener() {
             @Override
            public void actionPerformed(ActionEvent e) {
                 Add();
            }
        });
        
         this.subtractButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 Subtract();
            }
        });
        
        
   }
    
    
    private void Add(){
        String firstNumberString = firstNumberTextField.getText();
        String secondNumberString = secondNumberTextField.getText();
        
        if(!isNumeric(firstNumberString) || !isNumeric(secondNumberString)){
             JOptionPane.showMessageDialog(this.frame, "Value is not numeric.","ERROR",JOptionPane.WARNING_MESSAGE);
             return;
        }
        Double a = Double.parseDouble(firstNumberString)+Double.parseDouble(secondNumberString);
        this.resultTextField.setText(a.toString());
    }
    
    private void Subtract(){
        String firstNumberString = firstNumberTextField.getText();
        String secondNumberString = secondNumberTextField.getText();
        
        if(!isNumeric(firstNumberString) || !isNumeric(secondNumberString))
        {
            JOptionPane.showMessageDialog(this.frame, "Value is not numeric.","ERROR",JOptionPane.WARNING_MESSAGE);
            return;
        }
        Double a = Double.parseDouble(firstNumberString)-Double.parseDouble(secondNumberString);
        this.resultTextField.setText(a.toString());
    }
    
    public static boolean isNumeric(String strNum) {
    try {
        double d = Double.parseDouble(strNum);
    } catch (NumberFormatException | NullPointerException nfe) {
        return false;
    }
    return true;
   }
    
    public static void main(String[] args) {
        Calculator c = new Calculator();
    }
    
}
