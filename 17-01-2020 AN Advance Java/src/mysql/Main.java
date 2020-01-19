package mysql;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/accolite", "root", "root");

            CallableStatement stmt = (CallableStatement)con.prepareCall("call emp_details(?)");
            stmt.setInt(1, 1);     // deptId = 1

            ResultSet rs = stmt.executeQuery();

            List<Employee> empList = new ArrayList<>();
            System.out.println("Id\tName\tDept\tDname");
            while (rs.next()) {
                Employee emp = new Employee();
                emp.setId(rs.getInt(1));
                emp.setName(rs.getString(2));
                emp.setDept(rs.getInt(3));
                emp.setDid(rs.getInt(4));
                emp.setDname(rs.getString(5));
                empList.add(emp);

                System.out.println(emp);
            }
            con.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}