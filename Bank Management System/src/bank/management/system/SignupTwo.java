package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class SignupTwo extends JFrame implements ActionListener {

    JTextField panTextField,aadharTextField;
    JComboBox religioncombobox,categorycombobox,salarycombobox,educationcombobox,occupationcombobox;
    JRadioButton yes1,no1,yes2,no2;
    JButton next;
    String formno;

    SignupTwo(String formno) {
        this.formno=formno;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        getContentPane().setBackground(Color.WHITE);

//  "ADDITIONAL DETAILS"
        JLabel additionaldetails = new JLabel("Page 2: Additional Detail ");
        additionaldetails.setFont(new Font ("Raleway",Font.BOLD,20));
        additionaldetails.setBounds(285,80,400,30);
        add(additionaldetails);

//  For religion
        JLabel religion = new JLabel("Religion : ");
        religion.setBounds(100,140,100,30);
        religion.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(religion);
        String valReligion[] = {"General","SEBC","OBC","SC","ST","Other"};
        religioncombobox = new JComboBox(valReligion);
        religioncombobox.setBounds(350,140,300,25);
        religioncombobox.setFont(new Font("Raleway",Font.BOLD,14));
        religioncombobox.setBackground(Color.WHITE);
        add(religioncombobox);

//  For Category
        JLabel category = new JLabel("Category : ");
        category.setBounds(100,190,200,30);
        category.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(category);
        String valCategory[] = {"Hindu","Muslim","Sikh","Christian","Other"};
        categorycombobox = new JComboBox(valCategory);
        categorycombobox.setBounds(350,190,300,25);
        categorycombobox.setFont(new Font("Raleway",Font.BOLD,14));
        categorycombobox.setBackground(Color.WHITE);
        add(categorycombobox);

//  For income
        JLabel income = new JLabel("Income : ");
        income.setBounds(100,240,200,30);
        income.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(income);
        String salaryvalue[] = {"Null","< 5 lakhs","< 12 lakhs","< 20 lakhs","Upto 30 lakhs"};
        salarycombobox = new JComboBox(salaryvalue);
        salarycombobox.setBounds(350,240,300,25);
        salarycombobox.setFont(new Font("Raleway",Font.BOLD,14));
        salarycombobox.setBackground(Color.WHITE);
        add(salarycombobox);

//  For education qualification
        JLabel edqua = new JLabel("Education Qualification : ");
        edqua.setBounds(100,290,250,30);
        edqua.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(edqua);
        String edvalue[] = {"Non-Graduate","Graduate","Post-Graduate","Doctrate","Others"};
        educationcombobox = new JComboBox(edvalue);
        educationcombobox.setBounds(350,290,300,25);
        educationcombobox.setFont(new Font("Raleway",Font.BOLD,14));
        educationcombobox.setBackground(Color.WHITE);
        add(educationcombobox);

//  For Occupation
        JLabel occupation = new JLabel("Occupation : ");
        occupation.setBounds(100,340,200,30);
        occupation.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(occupation);
        String occvalue[] = {"Student","Salried","Self-Employed","Business","Retired","Others"};
        occupationcombobox = new JComboBox(occvalue);
        occupationcombobox.setBounds(350,340,300,25);
        occupationcombobox.setFont(new Font("Raleway",Font.BOLD,14));
        occupationcombobox.setBackground(Color.WHITE);
        add(occupationcombobox);

//  For Pan no
        JLabel panno = new JLabel("PAN No : ");
        panno.setBounds(100,390,200,30);
        panno.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(panno);
        panTextField = new JTextField();
        panTextField.setBounds(350,390,300,25);
        panTextField.setFont(new Font("Raleway",Font.BOLD,14));
        add(panTextField);

//  For Aadhar No
        JLabel aadharno = new JLabel("Aadhar no : ");
        aadharno.setBounds(100,440,150,30);
        aadharno.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(aadharno);
        aadharTextField = new JTextField();
        aadharTextField.setBounds(350,440,300,25);
        aadharTextField.setFont(new Font("Raleway",Font.BOLD,14));
        add(aadharTextField);

//  For Senior citizen (Yes/No)
        JLabel srcitizen = new JLabel("Senior Citizen : ");
        srcitizen.setBounds(100,490,200,30);
        srcitizen.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(srcitizen);
        yes1 = new JRadioButton("Yes");
        yes1.setBounds(350,490,80,25);
        no1 = new JRadioButton("No");
        no1.setBounds(450,490,80,25);
        // Group is made to choose one option and prevents accidental choosing both options .
        ButtonGroup srgrp = new ButtonGroup();
        srgrp.add(yes1);
        srgrp.add(no1);
        add(yes1);
        add(no1);

//  For Existing account (Yes/No)
        JLabel existacc = new JLabel("Existing Account : ");
        existacc.setBounds(100,540,200,30);
        existacc.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(existacc);
        yes2 = new JRadioButton("Yes");
        yes2.setBounds(350,540,80,25);
        no2 = new JRadioButton("No");
        no2.setBounds(450,540,80,25);
        // Group is made to choose one option and prevents accidental choosing both options .
        ButtonGroup existaccgroup = new ButtonGroup();
        existaccgroup.add(yes2);
        existaccgroup.add(no2);
        add(yes2);
        add(no2);

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
        String formno = this.formno; //long
        String sreligion = (String) religioncombobox.getSelectedItem(); // This lets us to access the data from the dropdown menu
        String scategory = (String) categorycombobox.getSelectedItem();
        String seducation = (String) educationcombobox.getSelectedItem();
        String soccupation = (String) occupationcombobox.getSelectedItem();
        String seniorcitizen = null;  // This is for the radioButton
        if(yes1.isSelected()){
            seniorcitizen = "Yes";
        }
        else if (no1.isSelected()) {
            seniorcitizen = "No";
        }
        String sexistingaccount = null;
        if(yes2.isSelected()){
            sexistingaccount = "Yes";
        }
        else if(no2.isSelected()){
            sexistingaccount = "No";
        }
        String span = panTextField.getText();
        String saadhar = aadharTextField.getText();

        try {
            Conn c = new Conn();
            String query2 = "insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+seducation+"','"+soccupation+"','"+seniorcitizen+"','"+sexistingaccount+"','"+span+"','"+saadhar+"')";
            c.s.executeUpdate(query2);

            //signup3 object
            setVisible(false);
            new SignupThree(formno).setVisible(true);

        }catch (Exception e){
            System.out.println(e);
        }

    }


    public static void main(String[] args) {
        new SignupTwo("");
    }
}
