package com.util;

import java.sql.*;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Created by usmannoor on 28/03/2017.
 */
public class Database {

    public Database() {
    }

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/ramada";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "root";
    Scanner scanner = new Scanner(System.in);
    Connection conn = null;
    Statement stmt = null;


    public boolean authenticate() {

        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connection Successful!");
            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            System.out.print("Enter your username:");
            String usr = scanner.nextLine();
            System.out.print("Enter your Password:");
            String pswrd = scanner.nextLine();

            sql = "select count(*) as n from admin where username='" + usr + "'and password='" + pswrd + "';";
            ResultSet rs = stmt.executeQuery(sql);

            int temp = 0;
            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name

                temp = rs.getInt("n");

            }

            if (temp > 0) {
                System.out.print("User logged in!\n");
                return true;

            } else {
                System.out.print("Invalid User!\n");
                rs.close();
                stmt.close();
                conn.close();
                System.exit(0);
                return false;
            }


            //STEP 6: Clean-up environment

        } catch (
                SQLException se)

        {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (
                Exception e)

        {
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        //end finally try
        return true;
    }//end try


    public boolean reserve(String name, int people, int time) {


        String sql2;
        String sql3;
        String sql4;
        String sql5;
        String sql6;
        String sql7;
        String sql8;
        String sql9;

        if (people <= 2) {

            try {
                stmt = conn.createStatement();
                sql2 = "select count(*) as a from small_tables";
                ResultSet reserve = stmt.executeQuery(sql2);

                int s_capacity = 0;
                //STEP 5: Extract data from result set
                while (reserve.next()) {
                    //Retrieve by column name

                    s_capacity = reserve.getInt("a");
                }
                if (s_capacity >= 4) {
                    System.out.print("Not available, Sorry!\n");
                    return false;
                } else {
                    sql3 = "insert into small_tables(customer_name,people) values('" + name + "'," + people + ");";
                    int booking_s = stmt.executeUpdate(sql3);
                    System.out.print("Reservation Done at :" + time + "\n");
                    return true;
                }


            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else if (people <= 4) {

            try {
                stmt = conn.createStatement();
                sql4 = "select count(*) as b from medium_tables";
                ResultSet reserve = stmt.executeQuery(sql4);

                int m_capacity = 0;
                //STEP 5: Extract data from result set
                while (reserve.next()) {
                    //Retrieve by column name

                    m_capacity = reserve.getInt("b");
                }
                if (m_capacity >= 8) {
                    System.out.print("Not available, Sorry!\n");
                    return false;
                } else {
                    sql5 = "insert into medium_tables(customer_name,people) values('" + name + "'," + people + ");";
                    int booking_m = stmt.executeUpdate(sql5);
                    System.out.print("Reservation Done at :" + time + "\n");
                    return true;
                }


            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else if (people <= 6) {


            try {
                stmt = conn.createStatement();
                sql6 = "select count(*) as c from large_tables";
                ResultSet reserve = stmt.executeQuery(sql6);

                int l_capacity = 0;
                //STEP 5: Extract data from result set
                while (reserve.next()) {
                    //Retrieve by column name

                    l_capacity = reserve.getInt("c");
                }
                if (l_capacity >= 3) {
                    System.out.print("Not available, Sorry!\n");
                    return false;
                } else {
                    sql7 = "insert into large_tables(customer_name,people) values('" + name + "'," + people + ");";
                    int booking_l = stmt.executeUpdate(sql7);
                    System.out.print("Reservation Done at :" + time + "\n");
                    return true;
                }


            } catch (SQLException e) {
                e.printStackTrace();
            }


        } else if (people <= 12) {


            try {
                sql8 = "select count(*) as d from extralarge_tables";
                ResultSet reserve = stmt.executeQuery(sql8);

                int xl_capacity = 0;
                //STEP 5: Extract data from result set
                while (reserve.next()) {
                    //Retrieve by column name

                    xl_capacity = reserve.getInt("d");
                }
                if (xl_capacity >= 1) {
                    System.out.print("Not available, Sorry!\n");
                    return false;
                } else {
                    sql9 = "insert into extralarge_tables(customer_name,people) values('" + name + "'," + people + ");";
                    int booking_xl = stmt.executeUpdate(sql9);
                    System.out.print("Reservation Done at :" + time + "\n");
                    return true;
                }


            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else {
            System.out.print("No table is available for that number of people!\n");
        }

        return false;
    }

    public void display() {
        String sql10;
        String sql11;


        try {
            stmt = conn.createStatement();
            sql10 = "select m.customer_name as na,m.people as pp, s.customer_name as nb,s.people as pq from medium_tables as m,small_tables as s";
            ResultSet reserve = stmt.executeQuery(sql10);


            //STEP 5: Extract data from result set
            while (reserve.next()) {
                //Retrieve by column name

                System.out.println("Reservation at Medium Table:");
                System.out.print("Customer: ");
                System.out.print(reserve.getString("na"));
                System.out.print("   People: ");
                System.out.println(reserve.getString("pp"));


                System.out.println("Reservation at Small Table:");
                System.out.print("Customer: ");
                System.out.print(reserve.getString("nb"));
                System.out.print("   People: ");
                System.out.println(reserve.getString("pq"));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
