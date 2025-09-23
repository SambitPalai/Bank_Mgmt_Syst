package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JButton v1,v2,v3,v4,v5,v6,back;
    String cardNumber;

    FastCash(String cardNumber) {
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

        JLabel text = new JLabel("Select Withdrawal Amount");
        text.setBounds(215,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

        v1 = new JButton("Rs 100");
        v1.setBounds(170,415,150,30);
        v1.addActionListener(this);
        image.add(v1);

        v2 = new JButton("Rs 500");
        v2.setBounds(355,415,150,30);
        v2.addActionListener(this);
        image.add(v2);

        v3 = new JButton("Rs 1000");
        v3.setBounds(170,450,150,30);
        v3.addActionListener(this);
        image.add(v3);

        v4 = new JButton("Rs 2000");
        v4.setBounds(355,450,150,30);
        v4.addActionListener(this);
        image.add(v4);

        v5 = new JButton("Rs 5000");
        v5.setBounds(170,485,150,30);
        v5.addActionListener(this);
        image.add(v5);

        v6  = new JButton("Rs 10,000");
        v6.setBounds(355,485,150,30);
        v6.addActionListener(this);
        image.add(v6);

        back = new JButton ("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);

        setLayout(null);
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true); // It removes the undecorated area like the place where is the title of the page is .
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){ // if button pressed exits the page
            setVisible(false);
            new Transactions(cardNumber).setVisible(true);
        } else {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn c =new Conn();
            try {
                // This calculates the total balance in the account
                //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
                ResultSet rs = c.s.executeQuery("select * from bank where Acc_no ='"+cardNumber+"'");
                int balance = 0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit") ){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

                if(ae.getSource() != back && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient balance!");
                    return;
                }

                Date date = new Date();
                String query = "insert into bank values('"+cardNumber+"','"+date+"','Withdrawal','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+amount+" Debited Successfully");
                setVisible(false);
                new Transactions(cardNumber).setVisible(true);

            }catch (Exception e){
                System.out.println(e);
            }
        }

    }

    public static void main(String[] args) {
        new FastCash("");
    }
}
