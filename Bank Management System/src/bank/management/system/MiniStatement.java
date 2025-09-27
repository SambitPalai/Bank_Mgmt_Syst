package bank.management.system;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class MiniStatement extends JFrame {
    String cardNumber;
    int balance;
    MiniStatement(String cardNumber){
        this.cardNumber = cardNumber;

        setTitle("Mini Statement");

        JLabel bank = new JLabel("PERSONAL BANK");
        bank.setBounds(140,20,200,20);
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(30,60,200,20);
        add(card);

        JLabel txt = new JLabel("Mini Statement : ");
        txt.setBounds(30,80,200,40);
        add(txt);

        // Shows user card no eg. xxxx xxxx xxxx 1234
        try{
           Conn c = new Conn();
           ResultSet rs = c.s.executeQuery("Select * from signupthree where cardNumber = '"+cardNumber+"'" );
           if(rs.next()){
               card.setText("Card Number : xxxx xxxx xxxx "+rs.getString("cardNumber").substring(12,16));
           }
        }
        catch(Exception e){
            System.out.println(e);
        }

        // Shows a Mini Statement
        DefaultTableModel model = new DefaultTableModel(
                new String[]{"Date","Type","Amount"},0
        );

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bank where Acc_no = '"+cardNumber+"' order by date desc limit 20 ");
                while(rs.next()){
                   model.addRow(new Object[]{
                           rs.getString("date"),
                           rs.getString("type"),
                           rs.getString("amount")
                   });
                }
        }catch(Exception e){
            System.out.println(e);
        }
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(30,120,340,250);
        add(scrollPane);

        // Shows Total Amount
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

        JLabel bal = new JLabel("Your Current Account Balance Is Rs."+balance+" .");
        bal.setBounds(30,390,400,20);
        add(bal);


        setLayout(null);
        setSize(400,700);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MiniStatement("");
    }
}
