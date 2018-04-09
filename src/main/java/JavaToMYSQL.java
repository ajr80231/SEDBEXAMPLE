import java.sql.*;
import java.util.*;

public class JavaToMYSQL {
    // JDBC URL, userName, and password for MySQL SERVER
    private static final String url = "jdbc:mysql://genghiscinemas.me:3306/SE_Example?useSSL=false";
    private static final String user = "genghis";
    private static final String password = "SE2018uga!";

    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    public JavaToMYSQL() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver"); // Loading Driver Class for JDBC
        con = DriverManager.getConnection(url,user,password);
        stmt = con.createStatement(); // creating Statement's Class Object which is responsible for performing all DB
    }

    public static void main(String args[]){
        String query = "select name, email, city, occupation, age  from customer";
        List<Customer> list = new ArrayList<Customer>();

        try{
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url,user,password);

            // getting Statement object to execute query
            stmt = con.createStatement();

            // executing SELECT query
            rs = stmt.executeQuery(query);

            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                Customer temp = new Customer(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
                list.add(temp);
            }


            String query1 = " insert into customer (name, email, city, occupation, age)" + " values (?, ?, ?, ?, ?)";
            PreparedStatement preparedStmt = con.prepareStatement(query1);
            preparedStmt.setString (1, "Daniel");
            preparedStmt.setString (2, "daniel@uga.edu");
            preparedStmt.setString  (3, "athens");
            preparedStmt.setString  (4, "student");
            preparedStmt.setInt    (5, 1);
            preparedStmt.execute();


        }
        catch (SQLException sqlEX){
            sqlEX.printStackTrace();
        }finally {
            // close connect, stmt, and result set here
            try { con.close(); } catch(SQLException se) { /*can't do anything */ }
            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
            try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
        }

        Customer[] temp2 = list.toArray(new Customer[0]);
        for (int i=0; i<temp2.length; i++){
            temp2[i].print();
            System.out.println("\n");
        }



    }

//    String query = "delete from customer where id = ?";
//    PreparedStatement preparedStmt = conn.prepareStatement(query);
//    preparedStmt.setInt(1, 3);
//    execute the preparedstatement
//    preparedStmt.execute();











}
