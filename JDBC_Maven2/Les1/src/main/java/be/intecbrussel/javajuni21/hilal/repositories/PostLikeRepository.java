package be.intecbrussel.javajuni21.hilal.repositories;

import be.intecbrussel.javajuni21.hilal.models.PostLike;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.List;

public class PostLikeRepository {

private static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/blogdb",
                "blogger",
                "P@ssw0rd"
        );
        System.out.println("CONNECTION TO DB IS MADE");

        return connection;
    }

    public long create(PostLike newPostLike) throws SQLException {

        Statement createStatement = getConnection().createStatement();

        // add create statements here..

        // if fails return -1
        return -1;
    }

    public PostLike read(long id) throws SQLException {

        Statement selectStatement = getConnection().createStatement();


        // return null if fails
        return null;
    }

    public List<PostLike> read(PostLike example) throws SQLException {

        Statement selectStatement = getConnection().createStatement();

        // add read statements here..

        // return empty collection if fails
        return Collections.emptyList();
    }

    public List<PostLike> read() throws SQLException {

        Statement selectStatement = getConnection().createStatement();

        // return empty collection if fails
        return Collections.emptyList();
    }

    public boolean update(long id, PostLike existingPostLike) throws SQLException {

        Statement updateStatement = getConnection().createStatement();

        // return false if fails
        return false;
    }

    public boolean delete(long id) throws SQLException {

        Statement deleteStatement = getConnection().createStatement();

        // return false if fails
        return false;
    }

}
