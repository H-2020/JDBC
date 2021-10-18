package jdbc;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MyFirstSQLConnection {

    public static void main(String[] args) {

        // DRIVER
        // Step 01: Configure the JDBC Driver

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println( "SUCCESS: " +  "Driver is configured.");

        } catch (ClassNotFoundException notFoundException) {

            System.err.println("CLASS NOT FOUND EXCEPTION: " + notFoundException.getMessage());
        }

        Connection connection = null;

        // Step 02: Make a connection
        // ALT + ENTER -> kies 2de optie 'surround with try/catch'
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/thebelgianbrewerydb", "chef", "ch€f");

            System.out.println("SUCCESS: " + "Connection is made between MYSQL and JAVA" );


        } catch (SQLException sqlException) {

            System.err.println("SQL EXCEPTION:" + sqlException.getMessage());
        }

//         instantie connection niet null !
        if(connection != null){ // if connection is made run the statement
            System.out.println("My statements will be here ..");
            System.out.println(connection);
        }


    }

}
