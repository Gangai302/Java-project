import javax.swing.*;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

public class BankingApp {

 private double balance = 0;

 public BankingApp() {

 JFrame frame = new JFrame("Banking Application");

 frame.setSize(400, 300);

 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

 frame.setLayout(null);

 JLabel balanceLabel = new JLabel("Current Balance: ₹" + balance);

 balanceLabel.setBounds(50, 20, 300, 30);

 frame.add(balanceLabel);

 JLabel amountLabel = new JLabel("Enter Amount:");

 amountLabel.setBounds(50, 70, 100, 30);

 frame.add(amountLabel);

 JTextField amountField = new JTextField();

 amountField.setBounds(150, 70, 150, 30);

 frame.add(amountField);

 JButton depositButton = new JButton("Deposit");

 depositButton.setBounds(50, 120, 100, 30);

 frame.add(depositButton);

 JButton withdrawButton = new JButton("Withdraw");

 withdrawButton.setBounds(200, 120, 100, 30);

 frame.add(withdrawButton);
   depositButton.addActionListener(new ActionListener() {

 @Override

 public void actionPerformed(ActionEvent e) {

 try {

 double amount = Double.parseDouble(amountField.getText());

 if (amount > 0) {

 balance += amount;

 balanceLabel.setText("Current Balance: ₹" + balance);

 JOptionPane.showMessageDialog(frame, "₹" + amount + " deposited 

successfully!");

 } else {

 JOptionPane.showMessageDialog(frame, "Amount must be 

positive!");

 }

 } catch (NumberFormatException ex) {

 JOptionPane.showMessageDialog(frame, "Invalid input! Please enter a 

valid amount.");

 }

 }

 });

 withdrawButton.addActionListener(new ActionListener() {

 @Override

 public void actionPerformed(ActionEvent e) {

 try {

 double amount = Double.parseDouble(amountField.getText());

 if (amount > 0 && amount <= balance) {

 balance -= amount;

 balanceLabel.setText("Current Balance: ₹" + balance);

 JOptionPane.showMessageDialog(frame, "₹" + amount + " withdrawn 

successfully!");

 } else if (amount > balance) {

 JOptionPane.showMessageDialog(frame, "Insufficient balance!");

 } else {

 JOptionPane.showMessageDialog(frame, "Amount must be 

positive!");

 }

 } catch (NumberFormatException ex) {

 JOptionPane.showMessageDialog(frame, "Invalid input! Please enter a 

valid amount.");

 }

 }
   });

 frame.setVisible(true);

 }

 public static void main(String[] args) {

 new BankingApp();

 }

}
