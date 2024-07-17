import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class calculator extends JFrame implements ActionListener {
    // GUI components
    private JTextField firstNumberField, secondNumberField, resultField;
    private JButton addButton, subButton, mulButton, divButton, modButton, clearButton;

    public calculator() {
        // Create and set up the window
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // First Number Label and Text Field
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("First Number:"), gbc);

        firstNumberField = new JTextField(10);
        gbc.gridx = 1;
        add(firstNumberField, gbc);

        // Second Number Label and Text Field
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Second Number:"), gbc);

        secondNumberField = new JTextField(10);
        gbc.gridx = 1;
        add(secondNumberField, gbc);

        // Result Label and Text Field
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Result:"), gbc);

        resultField = new JTextField(10);
        resultField.setEditable(false);
        gbc.gridx = 1;
        add(resultField, gbc);

        // Buttons
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        modButton = new JButton("%");
        clearButton = new JButton("Clear");

        // Add buttons to the frame
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(addButton, gbc);

        gbc.gridx = 1;
        add(subButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(mulButton, gbc);

        gbc.gridx = 1;
        add(divButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        add(modButton, gbc);

        gbc.gridx = 1;
        add(clearButton, gbc);

        // Add action listeners
        addButton.addActionListener(this);
        subButton.addActionListener(this);
        mulButton.addActionListener(this);
        divButton.addActionListener(this);
        modButton.addActionListener(this);
        clearButton.addActionListener(this);

        // Set the size of the window and make it visible
        setSize(300, 250);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double num1 = Double.parseDouble(firstNumberField.getText());
            double num2 = Double.parseDouble(secondNumberField.getText());
            double result = 0.0;

            if (e.getSource() == addButton) {
                result = num1 + num2;
            } else if (e.getSource() == subButton) {
                result = num1 - num2;
            } else if (e.getSource() == mulButton) {
                result = num1 * num2;
            } else if (e.getSource() == divButton) {
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    resultField.setText("Error");
                    return;
                }
            } else if (e.getSource() == modButton) {
                if (num2 != 0) {
                    result = num1 % num2;
                } else {
                    resultField.setText("Error");
                    return;
                }
            } else if (e.getSource() == clearButton) {
                firstNumberField.setText("");
                secondNumberField.setText("");
                resultField.setText("");
                return;
            }

            resultField.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            resultField.setText("Invalid Input");
        }
    }

    public static void main(String[] args) {
        new calculator();
    }
}