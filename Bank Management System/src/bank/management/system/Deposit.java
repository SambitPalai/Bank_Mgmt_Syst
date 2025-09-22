package bank.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {

    JTextField amt;
    JButton deposit,back ;
    String cardNumber;

    Deposit(String cardNumber) {
        this.cardNumber=cardNumber;

/* We can directly set bounds to image but we went so far to change the image into object and convert it to certain scale to scale up the actual image
and then apply it on the JLabel jsut to maintain the image its like
    There is a Pizza(Image) in short way you are stretching it so it won't remain the same the pizza will get thin and get torn (like pixels)
     but if I enlarge the pizza(Image) there will be no major alterations and it will be in good condition .*/
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Enter the amount you want to deposit");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(195,350,400,20);
        image.add(text);

        amt = new JTextField();
        amt.setBounds(215,400,250,30);
        amt.addActionListener(this);
        image.add(amt);

        deposit = new JButton("Confirm");
        deposit.setBounds(400,450,90,25);
        deposit.addActionListener(this);
        image.add(deposit);

        back = new JButton("Back");
        back.setBounds(400,479,90,25);
        back.addActionListener(this);
        image.add(back);


        setLayout(null);
        setUndecorated(true);
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == deposit){
            String num = amt.getText();
            Date date = new Date();
            if(num.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter the amount you want to deposit");
            }
            else{
                try {
                    Conn conn = new Conn();
                    String query = "insert into bank values('"+cardNumber+"','"+date+"','Deposit','"+num+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs "+num+" Deposited Successfully");
                    setVisible(false);
                    new Transactions(cardNumber).setVisible(true);
                }
                catch (SQLException e) {
                    System.out.println(e);
                }

            }
        }
        else if(ae.getSource() == back) {
            setVisible(false);
            new Transactions(cardNumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Deposit("");
    }

}
