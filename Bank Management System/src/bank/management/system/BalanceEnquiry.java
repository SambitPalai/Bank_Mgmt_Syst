package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener{

    JButton back;
    String cardNumber;
    int balance;

    BalanceEnquiry(String cardNumber)
    {
        this.cardNumber = cardNumber;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Balance Enquiry");
        text.setBounds(240,330,700,30);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,25));
        image.add(text);

        JLabel text1 = new JLabel("Available Balance ");
        text1.setBounds(240,380,700,30);
        text1.setForeground(Color.WHITE);
        text1.setFont(new Font("System",Font.PLAIN,15));
        image.add(text1);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bank where Acc_no ='"+cardNumber+"'");
            balance = 0;
            while(rs.next()){
                if(rs.getString("type").equals("Deposit") ){
                    balance += Integer.parseInt(rs.getString("amount"));
                }else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }

        JLabel text2 = new JLabel("Rs "+balance);
        text2.setBounds(240,400,700,30);
        text2.setForeground(Color.WHITE);
        text2.setFont(new Font("System",Font.PLAIN,20));
        image.add(text2);

        JLabel text3 = new JLabel("HAVE A NICE DAY !");
        text3.setBounds(270,480,700,16);
        text3.setForeground(Color.WHITE);
        text3.setFont(new Font("Times New Roman",Font.PLAIN,15));
        image.add(text3);

        back = new JButton("Back");
        back.setBounds(295,520,80,16);
        back.setForeground(Color.BLACK);
        back.setBackground(Color.WHITE);
        back.addActionListener(this);
        image.add(back);

        setLayout(null);
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(true);
            new Transactions(cardNumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
}
