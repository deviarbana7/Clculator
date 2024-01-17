import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Main implements ActionListener {
    JFrame frame;
    JTextField textField;
    JButton[] numbers = new JButton[10];
    JButton[] funksion = new JButton[9];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton,negButton;
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

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        clrButton = new JButton("AC");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Delete");
        negButton= new JButton("(-)");

        funksion[0] = addButton;
        funksion[1] = delButton;
        funksion[2] = subButton;
        funksion[3] = mulButton;
        funksion[4] = divButton;
        funksion[5] = clrButton;
        funksion[6] = decButton;
        funksion[7] = equButton;
        funksion[8] = negButton;

        for (int i = 0; i < 9; i++) {
            funksion[i].addActionListener(this);
            funksion[i].setFont(myFont);
            funksion[i].setFocusable(false);
        }

        for (int i = 0; i < 10; i++) {
            numbers[i] = new JButton(String.valueOf(i));
            numbers[i].addActionListener(this);
            numbers[i].setFont(myFont);
            numbers[i].setFocusable(false);
        }

        negButton.setBounds(50,430,100,50);
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
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if (e.getSource() == equButton) {
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
            }
            textField.setText(String.valueOf(res));
            num1 = res;
        }
        if (e.getSource() == clrButton) {
            textField.setText("");
        }
        if (e.getSource() == delButton) {
           String string=textField.getText();
           textField.setText("");
           for (int i=0;i<string.length()-1;i++){
               textField.setText(textField.getText()+string.charAt(i));
           }
        }
        if (e.getSource() == negButton){
            double temp=Double.parseDouble(textField.getText());
            temp*=-1;
            textField.setText(String.valueOf(temp));
        }
    }
}