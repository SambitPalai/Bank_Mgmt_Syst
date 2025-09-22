package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transactions extends JFrame implements ActionListener {

    JButton deposit,withdrawal,fastCash,miniStmt,pinChange,balanceEnquiry,exit;
    String cardNumber;

    Transactions(String cardNumber) {
        this.cardNumber=cardNumber;

/* We can directly set bounds to image but we went so far to change the image into object and convert it to certain scale to scale up the actual image
and then apply it on the JLabel jsut to maintain the image its like
    There is a Pizza(Image) in short way you are stretching it so it won't remain the same the pizza will get thin and get torn (like pixels)
     but if I enlarge the pizza(Image) there will be no major alterations and it will be in good condition .*/
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Please select your Transactions");
        text.setBounds(215,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

        deposit = new JButton("Deposit");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawal = new JButton("Cash Withdrawal");
        withdrawal.setBounds(355,415,150,30);
        withdrawal.addActionListener(this);
        image.add(withdrawal);

        fastCash = new JButton("Fast Cash");
        fastCash.setBounds(170,450,150,30);
        fastCash.addActionListener(this);
        image.add(fastCash);

        miniStmt = new JButton("Mini Statement");
        miniStmt.setBounds(355,450,150,30);
        miniStmt.addActionListener(this);
        image.add(miniStmt);

        pinChange = new JButton("Pin Change");
        pinChange.setBounds(170,485,150,30);
        pinChange.addActionListener(this);
        image.add(pinChange);

        balanceEnquiry  = new JButton("Balance Enquiry");
        balanceEnquiry.setBounds(355,485,150,30);
        balanceEnquiry.addActionListener(this);
        image.add(balanceEnquiry);

        exit = new JButton ("Exit");
        exit.setBounds(355,520,150,30);
        exit.addActionListener(this);
        image.add(exit);

        setLayout(null);
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true); // It removes the undecorated area like the place where is the title of the page is .
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){ // if button pressed exits the page
            System.exit(0);
        } else if (ae.getSource() == deposit) {
            setVisible(false);
            new Deposit(cardNumber).setVisible(true);
            // Just a debug line to check wether transactions class the cardNumber or not .
            System.out.println("Transactions cardNumber = " + this.cardNumber);
        }

    }

    public static void main(String[] args) {
        new Transactions("");
    }
}
