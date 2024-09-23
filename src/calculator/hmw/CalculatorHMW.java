/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator.hmw;

/**
 *
 * @author HP
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorHMW extends JFrame implements ActionListener {

    // Components for the calculator
    private JTextField numberInput1, numberInput2, numberInput3;
    private JComboBox<String> operatorBox, operatorBox1;
    private JTextField resultField, resultField1;
    private JButton calculateButton, resetButton;

    public CalculatorHMW() {
        // Frame settings
        setTitle("Calculator HMW");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(10, 10, 5, 5));

        // Initialize components
        numberInput1 = new JTextField();
       //numberInput1.setSize(10, 10);
       numberInput1.setFont(new Font("Arial", Font.PLAIN, 24));

        numberInput2 = new JTextField();
        numberInput2.setFont(new Font("Arial", Font.PLAIN, 24));
        
        numberInput3 = new JTextField();
        numberInput3.setFont(new Font("Arial", Font.PLAIN, 24));
        
        operatorBox = new JComboBox<>(new String[]{"+", "-", "×", "÷"});
        operatorBox.setFont(new Font("Aril",Font.PLAIN,25));
        //operatorBox.setSize(200, 200);
        operatorBox1 = new JComboBox<>(new String[]{"+", "-", "×", "÷"});
        operatorBox1.setFont(new Font("Aril",Font.PLAIN,25));
        
        resultField1 = new JTextField();
        calculateButton = new JButton("=");
        resetButton = new JButton("Reset");

        // Configure result fielfalse);

        // Add components to framed (no input allowed)
        //        resultField1.setEditable(
        add(new JLabel("Number 1:"));
        add(numberInput1);
        add(new JLabel("Operator:"));
        add(operatorBox);
        add(new JLabel("Number 2:"));
        add(numberInput2);
        add(new JLabel("Operator:"));
        add(operatorBox1);
        add(new JLabel("Number 3:"));
        add(numberInput3);
        add(calculateButton);
        add(resetButton);
        add(new JLabel("Result:"));
        add(resultField1);

        // Add listeners
        calculateButton.addActionListener(this);
        // calculateButton.setBackground(Color.);
        //calculateButton.setBackground(Color.black);
        resetButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calculateButton) {
            try {
                // Get input values
                double num1 = Double.parseDouble(numberInput1.getText());
                double num2 = Double.parseDouble(numberInput2.getText());
                double num3 = Double.parseDouble(numberInput3.getText());
                String operator = (String) operatorBox.getSelectedItem();
                String operator1 = (String) operatorBox1.getSelectedItem();

                // Perform calculation
                double result = 0;
                double result1 = 0;
                switch (operator) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "×":
                        result = num1 * num2;
                        break;
                    case "÷":
                        if (num2 == 0) {
                            throw new ArithmeticException("Cannot divide by zero");
                        }
                        result = num1 / num2;
                        break;
                }
                resultField1.setText(String.valueOf(result));
                switch (operator1) {
                    case "+":
                        result1 = result + num3;
                        break;
                    case "-":
                        result1 = result - num3;
                        break;
                    case "×":
                        result1 = result * num3;
                        break;
                    case "÷":
                        if (num3 == 0) {
                            throw new ArithmeticException("Cannot divide by zero");
                        }
                        result1 = result / num3;
                        break;
                }
                resultField1.setText(String.valueOf(result1));
                resultField1.setFont(new Font("Arial", Font.PLAIN, 24));

            } catch (NumberFormatException ex) {
                // Show error message if the input is invalid
                JOptionPane.showMessageDialog(this, "Please enter valid numbers.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (ArithmeticException ex) {
                // Show error message for division by zero
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == resetButton) {
            // Clear inputs and result
            numberInput1.setText("");
            numberInput2.setText("");
            numberInput3.setText("");
            resultField1.setText("");
        }
    }

    public static void main(String[] args) {
        // Create and display the calculator
        CalculatorHMW calculator = new CalculatorHMW();
        calculator.setVisible(true);
        calculator.setLocationRelativeTo(null);
        //calculator.setSize(400, 400);
        
    }
}
