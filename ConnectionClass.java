package SMS;
import java.sql.*;
public class ConnectionClass
{
    Connection con;
    Statement st;
    ConnectionClass(){
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","200305");
            st = con.createStatement();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new ConnectionClass();
    }
}