import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements ActionListener {
    JFrame frame;
    JTextField textField;
    JButton[] numbers = new JButton[10];
    JButton[] functions = new JButton[9];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton, negButton;
    JPanel panel;
    Font myFont = new Font("Calibri", Font.BOLD, 30);
    double num1 = 0, num2 = 0, res = 0;
    char operator;

    Main() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(myFont);
        textField.setEditable(false);
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char keyChar = e.getKeyChar();
                if (Character.isDigit(keyChar)) {
                    textField.setText(textField.getText().concat(String.valueOf(keyChar)));
                } else if (keyChar == '.') {
                    textField.setText(textField.getText().concat("."));
                } else if (keyChar == '+') {
                    performOperation();
                    operator = '+';
                    textField.setText("");
                } else if (keyChar == '-') {
                    performOperation();
                    operator = '-';
                    textField.setText("");
                } else if (keyChar == '*') {
                    performOperation();
                    operator = '*';
                    textField.setText("");
                } else if (keyChar == '/') {
                    performOperation();
                    operator = '/';
                    textField.setText("");
                } else if (keyChar == '=') {
                    performOperation();
                    operator = ' ';
                    textField.setText(String.valueOf(res));
                } else if (keyChar == '\b') { // '\b' represents the backspace key
                    String string = textField.getText();
                    if (!string.isEmpty()) {
                        textField.setText(string.substring(0, string.length() - 1));
                    }
                }
            }
        });

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        clrButton = new JButton("AC");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Delete");
        negButton = new JButton("(-)");

        functions[0] = addButton;
        functions[1] = delButton;
        functions[2] = subButton;
        functions[3] = mulButton;
        functions[4] = divButton;
        functions[5] = clrButton;
        functions[6] = decButton;
        functions[7] = equButton;
        functions[8] = negButton;

        for (int i = 0; i < 9; i++) {
            functions[i].addActionListener(this);
            functions[i].setFont(myFont);
            functions[i].setFocusable(false);
        }

        for (int i = 0; i < 10; i++) {
            numbers[i] = new JButton(String.valueOf(i));
            numbers[i].addActionListener(this);
            numbers[i].setFont(myFont);
            numbers[i].setFocusable(false);
        }

        negButton.setBounds(50, 430, 100, 50);
        delButton.setBounds(150, 430, 100, 50);
        clrButton.setBounds(250, 430, 100, 50);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        panel.add(numbers[1]);
        panel.add(numbers[2]);
        panel.add(numbers[3]);
        panel.add(addButton);
        panel.add(numbers[4]);
        panel.add(numbers[5]);
        panel.add(numbers[6]);
        panel.add(subButton);
        panel.add(numbers[7]);
        panel.add(numbers[8]);
        panel.add(numbers[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numbers[0]);
        panel.add(equButton);
        panel.add(divButton);

        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textField);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Main calculator = new Main();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numbers[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decButton) {
            textField.setText(textField.getText().concat("."));
        }

        if (e.getSource() == addButton) {
            performOperation();
            operator = '+';
            textField.setText("");
        }
        if (e.getSource() == subButton) {
            performOperation();
            operator = '-';
            textField.setText("");
        }
        if (e.getSource() == mulButton) {
            performOperation();
            operator = '*';
            textField.setText("");
        }
        if (e.getSource() == divButton) {
            performOperation();
            operator = '/';
            textField.setText("");
        }
        if (e.getSource() == equButton) {
            performOperation();
            operator = ' ';
            textField.setText(String.valueOf(res));
        }
        if (e.getSource() == clrButton) {
            textField.setText("");
            num1 = 0;
            num2 = 0;
            res = 0;
            operator = ' ';
        }
        if (e.getSource() == delButton) {
            String string = textField.getText();
            if (!string.isEmpty()) {
                textField.setText(string.substring(0, string.length() - 1));
            }
        }
        if (e.getSource() == negButton) {
            double temp = Double.parseDouble(textField.getText());
            temp *= -1;
            textField.setText(String.valueOf(temp));
        }
    }

    private void performOperation() {
        if (!textField.getText().isEmpty()) {
            num2 = Double.parseDouble(textField.getText());
            switch (operator) {
                case '+':
                    res = num1 + num2;
                    break;
                case '-':
                    res = num1 - num2;
                    break;
                case '/':
                    res = num1 / num2;
                    break;
                case '*':
                    res = num1 * num2;
                    break;
                default:
                    res = num2;
                    break;
            }
            num1 = res;
        }
    }
}
