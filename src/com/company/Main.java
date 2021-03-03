package com.company;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        //   final String DB_URL = "jdbc:mysql://localhost:3306/sakila";
        final String DB_URL = "jdbc:mysql://localhost:3306/titanicmanifest";
        final String DB_USER = "LuanaHF";
        final String DB_PASSWORD = "12232321";

        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD);

            Statement stmt = con.createStatement();

            String insertSQL = "insert into superheroes (id, firstName, lastName, heroName)\n" +
                    "values (2, 'Peter', 'Parker', 'Spiderman')";

            String insertNewSQL = "insert into superheroes (id, firstName, lastName, heroName)\n" +
                    "values (3, 'Clark', 'Kent', 'Superman')";

            stmt.executeUpdate(insertNewSQL);




            String sqlQuery = "select * from superheroes";

            ResultSet rs = stmt.executeQuery(sqlQuery);


            ResultSetMetaData metaData = rs.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            for (int i = 1; i <= numberOfColumns; i++) {
                System.out.printf("%-8s\t", metaData.getColumnName(i));
            }
            System.out.println();


            while (rs.next()) {
                // System.out.println(rs.getInt(1) + "\t  " + rs.getString(2) + " \t " + rs.getString(3));
                System.out.println(rs.getString(4));
            }


        } catch (SQLException e) {
            System.out.println(e.toString());

        } catch (Exception e) {

        } finally {
            // System.out.println("finally");
        }


    }
}
