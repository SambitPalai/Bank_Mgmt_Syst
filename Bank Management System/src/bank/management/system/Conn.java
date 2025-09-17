package bank.management.system;

import com.mysql.cj.jdbc.Driver;

import java.sql.*; // imported sql library

public class Conn {

/*Here Conn is known as connection , we will be establishing JDBC here to SQL
   --> Register the drivers
   --> Create Connection
   --> Create Statement
   --> Execute Query
   --> Close Connection */

    Connection c ;
    Statement s;
    public Conn() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmgmtsyst","root","OmKanha@2005");
            s = c.createStatement();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
