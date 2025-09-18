package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {

//Defining it globally so it can be accessed outside the method.
    JButton login,signup,clear;
    JTextField cardTextField;
    JPasswordField pinTextField;
//Constructor
    Login(){
        setTitle("💲💲 AUTOMATED TELLER MACHINE 💲💲");//5. sets title of the interface.

/* 12. Setting layout to null to use or custom layout i.e.
       label.setBounds(70,10,100,100); or text.setBounds(90,40,90,90); */
        setLayout(null);

// For the image "logo.jpg"
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));//6. Gets the image form a specifc address it directly checks the src folder and here object i1 is created
        Image i2 = i1.getImage().getScaledInstance(90,90, Image.SCALE_DEFAULT); //8. Sets the size of the logo where i2 object is created from i1
        ImageIcon i3 = new ImageIcon(i2); //9. i2 cant be directly used so object i3 is created from i2
        JLabel label = new JLabel(i3); //10. here we created a JLabel on which we use to show our object i3 i.e. image "logo.jpg"
        label.setBounds(370,20,90,90); //11. used to set bounds(location) of label (image)
        add(label); //7. it helps to place JLabel (label) , on the frame

//13. sets colour in the frame
        getContentPane().setBackground(Color.WHITE );

//14. With the help of JLabel you can write anything on the frame.
        JLabel text = new JLabel(" WELCOME TO ATM "); //Places JLabel (text)
        text.setBounds(270,110,400,40); //sets JLabel (text) location
        add(text);//places JLabel (text) on the frame
        text.setFont(new Font("Times New Roman", Font.BOLD, 28));

//15. For Card No.
        JLabel cardno = new JLabel("Card No. :");
        cardno.setBounds(260,170,400,40);
        cardno.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(cardno);
        /*It can be written as "JTextField cardTextField = new JTextField();"
   but as it is globally defined therefore we write
    " cardTextField = new JTextField();" */
        cardTextField = new JTextField();
        cardTextField.setBounds(380,180,180,21);
        cardTextField.setFont(new Font("Aerial",Font.BOLD,14));
        add(cardTextField);

//16. For PIN
        JLabel pin = new JLabel("PIN :");
        pin.setBounds(260,220,400,40);
        pin.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(pin);
        pinTextField = new JPasswordField();
        pinTextField.setBounds(380,230,180,21);
        add(pinTextField);

//17. For Login
/*It can be written as " JButton login = new JButton("Login");"
   but as it is globally defined therefore we write
    "login = new JButton("Login");" */
        login = new JButton("Login");
        login.setBounds(325,280,190,19);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

//18. For Signup
        signup = new JButton("Signup");
        signup.setBounds(345,310,155,19);
        signup.setBackground(Color.black);
        signup.setForeground(Color.white);
        signup.addActionListener(this);
        add(signup);

//19. For clear
        clear = new JButton("Clear");
        clear.setBounds(365,340,115,19);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);

// Customize Frame
        setSize(800, 480); //2. sets size of frame
        setVisible(true); //3. makes the frame visible.
        setLocation(350,200); //4. sets the location for the frame to open on the display
    }

/*20. As we have implemented the ActionListener interface -> ("public class Login extends JFrame implements ActionListener")
    due to the abstract method i.e. declared inside the ActionListener interface and not defined therefore
    we need to override it .
>> ("When we have an interface and when we implement that interface
     we need to override all its methods. ")
>> ActionEvent class lets us know which button was pressed .
>> ae is the object of the class ActionEvent. */
    @Override
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==clear){
            cardTextField.setText("");
            pinTextField.setText("");
        } else if (ae.getSource()==login) {
            
        } else if (ae.getSource()==signup) {
            setVisible(false);  // when signup button is pressed it closes the login page
            new SignupOne().setVisible(true); // this opens up the signup page
        }
    }


    public static void main(String[] args) {

        /*1.new object of class Login
        it calls the constructor --> Login() */
        new Login();

    }
}
