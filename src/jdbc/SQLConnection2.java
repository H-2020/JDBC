package jdbc;

import java.sql.*;

public class SQLConnection2 {


    public static void main(String[] args) {

        try {
            // STAP 01: de paketten importeren
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("STEP 1 -> SUCCESS: " + "Driver is configured.");

            // STAP 02: een verbinding openen
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/thebelgianbrewerydb", "justin", "justin");
            System.out.println("STEP 2 -> SUCCESS: " + "Connection is made between MYSQL and JAVA");

            // STAP 03: Een / Meerdere queries uitvoeren | Statement uitvoeren

            // STAP 03.01: SELECT STATEMENT
            Statement selectStatement = connection.createStatement();
            String selectQuery = "SELECT Id, Name, BrewerId, CategoryId, Price, Stock, Alcohol FROM beers";
            ResultSet selectResult = selectStatement.executeQuery(selectQuery);

            while (selectResult.next()) {

                System.out.println(
                        selectResult.getRow() + " | "
                                + selectResult.getInt("Id") + " | " +
                                selectResult.getString("Name") + " | " +
                                selectResult.getInt("BrewerId") + " | " +
                                selectResult.getInt("CategoryId") + " | " +
                                selectResult.getFloat("Price") + " | " +
                                selectResult.getInt("Stock") + " | " +
                                selectResult.getFloat("Alcohol")

                );

            }

            Statement insertStatement = connection.createStatement();

            Statement updateStatement = connection.createStatement();

            Statement deleteStatement = connection.createStatement();

        } catch (ClassNotFoundException notFoundException) {
            System.err.println("STEP 1- > CLASS NOT FOUND EXCEPTION: " + notFoundException.getMessage());

        } catch (SQLException sqlException) {
            System.err.println("STEP 2 -> SQL EXCEPTION: " + sqlException.getMessage());
        }

    }


}
