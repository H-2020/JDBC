package be.intecbrussel.javajuni21.hilal.jdbc.repositories;

import be.intecbrussel.javajuni21.hilal.jdbc.models.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepository {

    // CRUD operations:
    // Create (Insert), Read (Select), Update, and Delete

    public void create(){

    }

    public List<Category> read(){

        // Polymorphism .
        List<Category> results = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/thebelgianbrewerydb",
                    "chef",
                    "P@ssw0rd"
            );
            System.out.println("CONNECTION TO DB IS MADE");
            Statement statement = connection.createStatement();
            // if this query returns multiple results, then read() method must return
            // either an array or a list.
            String query  = "SELECT  Id, Category FROM categories";
            // CTRL + ALT + V  then ENTER
            ResultSet resultSet = statement.executeQuery(query);
            // STEP 03: make binding between Java Objects and Tables

            while(resultSet.next()){
                // System.out.println("ID: " + resultSet.getInt("Id"));
            }

        } catch (SQLException sqlException) {
            System.err.println("SQL EXCEPTION: " + sqlException.getMessage());
        }



        return results;

    }

    public void update(){

    }

    public void delete(){

    }

}
