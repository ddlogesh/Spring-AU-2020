package mysql;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/accolite", "root", "root");

            CallableStatement stmt = (CallableStatement)con.prepareCall("call emp_details(?)");
            stmt.setInt(1, 1);     // deptId = 1

            ResultSet rs = stmt.executeQuery();

            System.out.println("Id\tName\tDept\tDname");
            while (rs.next())
                System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t\t" + rs.getString(5));
            con.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}