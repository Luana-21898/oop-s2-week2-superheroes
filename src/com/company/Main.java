package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/titanicmanifest", "LuanaHF", "12232321");

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from titanic");

            System.out.println("before while");

            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getInt(2) + " " + rs.getInt(3)
                        + " " + rs.getString(4) + " " + rs.getString(5) + " " + rs.getInt(6)
                        + " " + rs.getInt(7) + " " + rs.getInt(8));
            }
            System.out.println("after while");

            con.close();

        }catch (Exception e) {

            System.out.println(e.toString());

        }finally {
            System.out.println("finally");

        }

    }
}
