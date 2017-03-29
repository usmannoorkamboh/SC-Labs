import java.sql.*;  // for standard JDBC programs
import java.math.*; // for BigDecimal and BigInteger support
import java.util.Scanner;

/**
 * Created by usmannoor on 01/03/2017.
 */

public class lab4 {

    public int small_availability = 4;
    public int medium_availability = 8;
    public int xl_availability = 1;
    public int l_availability = 3;
    public int opening_time = 1100;
    public int closing_time = 2200;
    public int[] t = new int[12];

    public int reserve(int people, int timeslot) {

        //for booking small table
        if (people <= 2) {
            if (small_availability == 0) {
                System.out.print("No table is available\n");
            } else {
                for (int i = 0; i < 12; i++) {
                    t[i] = 4;
                }
                if (timeslot < opening_time || timeslot > closing_time) {
                    System.out.print("No bookings in this time.\n");
                } else {
                    int slot = (timeslot / 100) - 11;
                    if (t[slot] == 0) {
                        System.out.print("No slot available at that time.\n");
                    } else {
                        small_availability--;
                        t[slot]--;
                        System.out.print("Successful at time: " + timeslot + "\n");
                        return 1;
                    }
                }
            }
            //Booking for medium table
        } else if (people <= 4) {
            if (medium_availability == 0) {
                System.out.print("No table is available\n");
            } else {
                for (int i = 0; i < 12; i++) {
                    t[i] = 8;
                }
                if (timeslot < opening_time || timeslot > closing_time) {
                    System.out.print("No bookings in this time.\n");
                } else {
                    int slot = (timeslot / 100) - 11;
                    if (t[slot] == 0) {
                        System.out.print("No slot available at that time.\n");
                    } else {
                        medium_availability--;
                        t[slot]--;
                        System.out.print("Successful at time: " + timeslot + "\n");
                        return 1;
                    }
                }
            }
            //Booking for large table
        } else if (people <= 6) {
            if (l_availability == 0) {
                System.out.print("No table is available\n");
            } else {
                for (int i = 0; i < 12; i++) {
                    t[i] = 3;
                }
                if (timeslot < opening_time || timeslot > closing_time) {
                    System.out.print("No bookings in this time.\n");
                } else {
                    int slot = (timeslot / 100) - 11;
                    if (t[slot] == 0) {
                        System.out.print("No slot available at that time.\n");
                    } else {
                        l_availability--;
                        t[slot]--;
                        System.out.print("Successful at time: " + timeslot + "\n");
                        return 1;
                    }
                }
            }
            //Booking for extra largetable
        } else if (people <= 12) {
            if (xl_availability == 0) {
                System.out.print("No table is available\n");
            } else {
                for (int i = 0; i < 12; i++) {
                    t[i] = 1;
                }
                if (timeslot < opening_time || timeslot > closing_time) {
                    System.out.print("No bookings in this time.\n");
                } else {
                    int slot = (timeslot / 100) - 11;
                    if (t[slot] == 0) {
                        System.out.print("No slot available at that time.\n");
                    } else {
                        xl_availability--;
                        t[slot]--;
                        System.out.print("Successful at time: " + timeslot + "\n");
                        return 1;
                    }
                }
            }
        }
        return 0;
    }


    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/moseequi";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "root";

    public static void main(String[] args) {
        Scanner scanner = new Scanner();
        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            System.out.print("Enter your username:");
            String usr = scanner.nextLine();
            System.out.print("Enter your Password:");
            String pswrd = scanner.nextLine();
            sql = "select * from admin where username='"+usr+"'";
            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name

            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
    }//end main
}//end FirstExample

