package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*; // it contains the random class "Random ram = new Random();"
import com.toedter.calendar.JDateChooser;

public class SignupOne extends JFrame implements ActionListener {

    long random;
    JTextField nameTextField,fnameTextField , emailTextField,addressTextField,cityTextField,pinTextField,stateTextField;
    JRadioButton male ,female ,married ,unmarried, other;
    JDateChooser dateChooser;
    JButton next;

    SignupOne() {

/*  Never forget to set the layout of the JLabel to null because
    in default the format will be center aligned and changes can't be done . */
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

// IT IS FOR THE HEADING "APPLICATION FORM NO.( RANDOM NUMBER )"
        Random ram = new Random();
/*  (Math.abs(ram.nextLong() % 9000L ) + 1000L) this line generates 4 digit positive random no
    and to ignore to get random negative we used Math.abs */
        random = (Math.abs(ram.nextLong() % 9000L ) + 1000L);
        JLabel formno = new JLabel("APPLICATION FORM NO. "+random);
        formno.setFont(new Font ("Raleway",Font.BOLD,38));
        formno.setBounds(135,20,600,40);
        add(formno);

//  "PERSONAL DETAILS"
        JLabel presonaldetails = new JLabel("Page 1: Personal Details");
        presonaldetails.setFont(new Font ("Raleway",Font.BOLD,20));
        presonaldetails.setBounds(285,80,400,30);
        add(presonaldetails);

//  For Name
        JLabel name = new JLabel("Name : ");
        name.setBounds(100,140,100,30);
        name.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(name);
        nameTextField = new JTextField();
        nameTextField.setBounds(300,140,300,25);
        nameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        add(nameTextField);
//  For Fathers name
        JLabel fname = new JLabel("Father's name : ");
        fname.setBounds(100,190,200,30);
        fname.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(fname);
        fnameTextField = new JTextField();
        fnameTextField.setBounds(300,190,300,25);
        fnameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        add(fnameTextField);
//  For DOB
        JLabel dob = new JLabel("Date Of Birth : ");
        dob.setBounds(100,240,200,30);
        dob.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(dob);
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300,240,300,25);
        dateChooser.setForeground(new Color(0,0,0));
        add(dateChooser);

//  For Gender
        JLabel gender = new JLabel("Gender : ");
        gender.setBounds(100,290,100,30);
        gender.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(gender);
        male = new JRadioButton("Male");
        male.setBounds(300,290,80,25);
        female = new JRadioButton("Female");
        female.setBounds(390,290,80,25);
        other = new JRadioButton("Other");
        other.setBounds(480,290,80,25);
        // Group is made to choose one option and prevents accidental choosing both options .
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(other);
        add(male);
        add(female);
        add(other);

//  For Email Address
        JLabel email = new JLabel("Email Address : ");
        email.setBounds(100,340,200,30);
        email.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(email);
        emailTextField = new JTextField();
        emailTextField.setBounds(300,340,300,25);
        emailTextField.setFont(new Font("Raleway",Font.BOLD,14));
        add(emailTextField);

//  For Martial Status
        JLabel mstat = new JLabel("Martial Status : ");
        mstat.setBounds(100,390,200,30);
        mstat.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(mstat);
        married = new JRadioButton("Married");
        married.setBounds(300,390,90,25);
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(400,390,90,25);
        // Group is made to choose one option and prevents accidental choosing both options .
        ButtonGroup martialstat = new ButtonGroup();
        martialstat.add(married);
        martialstat.add(unmarried);
        add(married);
        add(unmarried);

//  For address
        JLabel address = new JLabel("Adderss : ");
        address.setBounds(100,440,100,30);
        address.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(address);
        addressTextField = new JTextField();
        addressTextField.setBounds(300,440,300,25);
        addressTextField.setFont(new Font("Raleway",Font.BOLD,14));
        add(addressTextField);
//  For city
        JLabel city = new JLabel("City : ");
        city.setBounds(100,490,100,30);
        city.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(city);
        cityTextField = new JTextField();
        cityTextField.setBounds(300,490,300,25);
        cityTextField.setFont(new Font("Raleway",Font.BOLD,14));
        add(cityTextField);
//  For pin code
        JLabel pin = new JLabel("PIN : ");
        pin.setBounds(100,540,100,30);
        pin.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(pin);
        pinTextField = new JTextField();
        pinTextField.setBounds(300,540,300,25);
        pinTextField.setFont(new Font("Raleway",Font.BOLD,14));
        add(pinTextField);
//  For State
        JLabel state = new JLabel("State : ");
        state.setBounds(100,590,100,30);
        state.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(state);
        stateTextField = new JTextField();
        stateTextField.setBounds(300,590,300,25);
        stateTextField.setFont(new Font("Raleway",Font.BOLD,14));
        add(stateTextField);

//  For Next
        next = new JButton("Next");
        next.setBounds(400,640,80,30);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this); // action listener for Next button .
        add(next);

        setSize(850,800);
        setLocation(350,10);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        String formno = ""+random;
        String name = nameTextField.getText();
        String fname = nameTextField.getText();
        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getToolTipText();
        String gender = null;
        if(male.isSelected()){
            gender = "Male";
        }
        else if(female.isSelected()){
            gender = "Female";
        }
        String email = emailTextField.getText();
        String mstat = null;
        if(married.isSelected()){
            mstat = "Married";
        }
        else if(unmarried.isSelected()){
            mstat = "Unmarried";
        } else if (other.isSelected()) {
            mstat = "Other";
        }
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String pin = pinTextField.getText();
        String state = stateTextField.getText();

        try{
           if(name.equals("")){
               JOptionPane.showMessageDialog(null,"Name is required");
           }
           else{
               Conn c = new Conn();
               String query = "insert into signup value ('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+mstat+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
               c.s.executeUpdate(query);
           }
        }catch(Exception e){
            System.out.println(e);
        }

    }


    public static void main(String[] args) {
        new SignupOne();
    }
}
