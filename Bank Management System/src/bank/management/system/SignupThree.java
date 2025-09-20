package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*; // it contains the random class "Random ram = new Random();"


public class SignupThree extends JFrame implements ActionListener {

    JRadioButton savAcc,curAcc,fixdepositAcc,recdepositAcc;
    JButton submit,cancel;
    JCheckBox c1,c2,c3,c4,c5,c6,c7 ;
    String formno;

    SignupThree(String formno) {

        this.formno = formno;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");
        getContentPane().setBackground(Color.WHITE);


//  "ACCOUNT DETAIL"
        JLabel acc = new JLabel("Page 3: Account Details");
        acc.setFont(new Font ("Raleway",Font.BOLD,20));
        acc.setBounds(285,80,400,30);
        add(acc);

//  For Account Type
        JLabel accType = new JLabel("Account Type : ");
        accType.setBounds(100,140,200,30);
        accType.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(accType);
        savAcc = new JRadioButton("Saving Account");
        savAcc.setBackground(Color.WHITE);
        savAcc.setBounds(300,140,210,25);
        curAcc = new JRadioButton("Current Account");
        curAcc.setBackground(Color.WHITE);
        curAcc.setBounds(300,160,210,25);
        fixdepositAcc = new JRadioButton("Fixed Deposit Account");
        fixdepositAcc.setBackground(Color.WHITE);
        fixdepositAcc.setBounds(300,180,210,25);
        recdepositAcc = new JRadioButton("Recurring Deposit Account");
        recdepositAcc.setBackground(Color.WHITE);
        recdepositAcc.setBounds(300,200,210,25);
        // Group is made to choose one option and prevents accidental choosing both options .
        ButtonGroup acctypeGroup = new ButtonGroup();
        acctypeGroup.add(savAcc);
        acctypeGroup.add(curAcc);
        acctypeGroup.add(fixdepositAcc);
        acctypeGroup.add(recdepositAcc);
        add(savAcc);
        add(curAcc);
        add(fixdepositAcc);
        add(recdepositAcc);

//  For Card Number
        JLabel cardNo = new JLabel("Card Number :  ");
        cardNo.setBounds(100,250,200,30);
        cardNo.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(cardNo);
        JLabel cardnoInfo = new JLabel("(Your 16 digit card number)   ");
        cardnoInfo.setBounds(100,270,200,30);
        cardnoInfo.setFont(new Font("Times New Roman", Font.BOLD, 15));
        add(cardnoInfo);
        JLabel cardnoFormat = new JLabel("xxxx-xxxx-xxxx-xxxx");
        cardnoFormat.setBounds(300,250,200,30);
        cardnoFormat.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(cardnoFormat);

//  For PIN
        JLabel cardPin  = new JLabel("PIN :");
        cardPin.setBounds(100,320,200,30);
        cardPin.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(cardPin);
        JLabel pinInfo = new JLabel("(Your 4 digit PIN )   ");
        pinInfo.setBounds(100,340,200,30);
        pinInfo.setFont(new Font("Times New Roman", Font.BOLD, 15));
        add(pinInfo);
        JLabel cardpinFormat  = new JLabel("xxxx");
        cardpinFormat.setBounds(300,320,200,30);
        cardpinFormat.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(cardpinFormat);

//  For Services Required
        JLabel servics = new JLabel("Services Required : ");
        servics.setBounds(100,390,200,30);
        servics.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(servics);
        c1 = new JCheckBox("ATM Card");
        c1.setBounds(300,390,200,30);
        c1.setBackground(Color.WHITE);
        add(c1);
        c2 = new JCheckBox("Mobile Banking");
        c2.setBounds(300,420,200,30);
        c2.setBackground(Color.WHITE);
        add(c2);
        c3 = new JCheckBox("Cheque Book");
        c3.setBounds(300,450,200,30);
        c3.setBackground(Color.WHITE);
        add(c3);
        c4 = new JCheckBox("Internet Banking");
        c4.setBounds(300,480,200,30);
        c4.setBackground(Color.WHITE);
        add(c4);
        c5 = new JCheckBox("Email and SMS Alerts");
        c5.setBounds(300,510,200,30);
        c5.setBackground(Color.WHITE);
        add(c5);
        c6 = new JCheckBox("E-Statement");
        c6.setBounds(300,540,200,30);
        c6.setBackground(Color.WHITE);
        add(c6);

//  For Declaration
        c7 = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge.");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        c7.setBounds(100,600,700,30);
        add(c7);

//  For Submit
        submit = new JButton("SUBMIT");
        submit.setBounds(100,640,100,30);
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this); // action listener for Next button .
        add(submit);

//  For Cancel
        cancel = new JButton("CANCEL");
        cancel.setBounds(600,640,100,30);
        cancel.setFont(new Font("Raleway",Font.BOLD,14));
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.addActionListener(this); // action listener for Next button .
        add(cancel);


        setSize(850,800);
        setLocation(350,10);
        setVisible(true);

    }


    public void actionPerformed(ActionEvent ae){
        String formno = this.formno;
        if(ae.getSource() == submit ){
            //For accType
            String accType = null;
            if(savAcc.isSelected()){
                accType = "Saving Account";
            }
            else if(curAcc.isSelected()){
                accType = "Current Account";
            }else if (fixdepositAcc.isSelected()) {
                accType = "Fixed Deposit Account";
            }else if (recdepositAcc.isSelected()) {
                accType = "Recurring Deposit Account";
            }

            Random random = new Random();
            //to generate Random Card Number
            String cardNumber = ""+Math.abs((random.nextLong()%90000000L)+5040936000000000L);
            //to generate Random Card Number
            String pinNumber=""+Math.abs((random.nextLong()%9000L)+1000L);
            //For services for the Check Boxes .
            String services = "";
            if(c1.isSelected()){
                services = services+"ATM Card";
            }
            else if(c2.isSelected()){
                services = services+"Mobile Banking";
            }
            else if(c3.isSelected()){
                services = services+"Cheque Book";
            }
            else if(c4.isSelected()){
                services = services+"Internet Banking";
            }
            else if(c5.isSelected()){
                services = services+"E-mail and SMS alerts";
            }
            else if(c6.isSelected()){
                services = services+"E-Statement";
            }



        try{
            if(accType.equals("")){
                JOptionPane.showMessageDialog(null,"Account Type is required.");
            }
            else{
                Conn c = new Conn();
                String query3 = "insert into signupthree values ('"+formno+"','"+accType+"','"+cardNumber+"','"+pinNumber+"','"+services+"')";
                String query4 = "insert into login values ('"+formno+"','"+cardNumber+"','"+pinNumber+"')";
                c.s.executeUpdate(query3);
                c.s.executeUpdate(query4);

                JOptionPane.showMessageDialog(null,"Your Card Number :"+cardNumber+"\n Your Pin Number:"+pinNumber);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }

        }

        else if (ae.getSource() == cancel) {

        }
    }


    public static void main(String[] args) {
        new SignupThree("");
    }
}
