package be.intec.repositories.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private static ConnectionFactory connectionFactory = null;
	String connectionUrl = "jdbc:mysql://localhost:3306/messagedb_jdbc";
	String dbUser = "root";
	String dbPwd = "pass";


	private ConnectionFactory() {

	}


	public static ConnectionFactory getInstance() {

		if ( connectionFactory == null ) {
			connectionFactory = new ConnectionFactory();
		}
		return connectionFactory;
	}


	public Connection getConnection() throws SQLException {

		Connection conn = null;
		conn = DriverManager.getConnection( connectionUrl, dbUser, dbPwd );
		return conn;
	}

}
