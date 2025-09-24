package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;


public class pinChange extends JFrame implements ActionListener {

    JPasswordField newPin,renewPin;
    JButton change,cancel;
    String cardNumber;

    pinChange(String cardNumber){
        this.cardNumber = cardNumber;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);


        JLabel pinText = new JLabel("CHANGE YOUR PIN");
        pinText.setForeground(Color.WHITE);
        pinText.setFont(new Font("Raleway",Font.BOLD,16));
        pinText.setBounds(265,300,500,35);
        image.add(pinText);

        // Enter your New Pin
        JLabel pinText1 = new JLabel("Enter New PIN :");
        pinText1.setForeground(Color.WHITE);
        pinText1.setFont(new Font("Raleway",Font.BOLD,16));
        pinText1.setBounds(180,340,400,25);
        image.add(pinText1);

        newPin = new JPasswordField();
        newPin.setBackground(Color.WHITE);
        newPin.setForeground(Color.BLACK);
        newPin.setBounds(330,340,140,25);
        newPin.addActionListener(this);
        image.add(newPin);

        //Re-enter your new pin
        JLabel pinText2 = new JLabel("Re-Enter New PIN:");
        pinText2.setForeground(Color.WHITE);
        pinText2.setFont(new Font("Raleway",Font.BOLD,16));
        pinText2.setBounds(180,380,400,25);
        image.add(pinText2);

        renewPin = new JPasswordField();
        renewPin.setBounds(330,380,140,25);
        renewPin.addActionListener(this);
        image.add(renewPin);

        //Change
        change = new JButton("Change");
        change.setBounds(370,450,90,25);
        change.addActionListener(this);
        image.add(change);

        //cancel
        cancel = new JButton("Cancel");
        cancel.setBounds(370,480,90,25);
        cancel.addActionListener(this);
        image.add(cancel);

        setLayout(null);
        setUndecorated(true);
        setVisible(true);
        setSize(900,900);
        setLocation(300,0);

    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource() == change) {
            try {
                char[] nPin = newPin.getPassword();
                char[] rPin = renewPin.getPassword();

                if(nPin.length == 0) {
                    JOptionPane.showMessageDialog(null,"Please enter the password !");
                    return;
                }
                if(rPin.length == 0) {
                    JOptionPane.showMessageDialog(null,"Please Re-enter the password !");
                    return;
                }

                Conn conn = new Conn();
                String query1 = "update login set pinNumber = '"+String.valueOf(rPin)+"' where cardNumber = '"+cardNumber+"' ";  // String.valueOf(rPin) this convert the char[] to string
                String query2 = "update signupthree set pinNumber = '"+String.valueOf(rPin)+"' where cardNumber = '"+cardNumber+"' ";
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null,"PIN changed Successfully !");
                setVisible(false);
                new Login().setVisible(true);

            }catch (Exception e){
                System.out.println(e);
            }
        }
        else{
            setVisible(false);
            new Transactions(cardNumber).setVisible(true);
        }

    }

    public static void main(String[] args) {
        new pinChange("");
    }
}
