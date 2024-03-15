package db.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StatementInit {

    private StatementInit() {}
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/habrdb";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "postgres";
    private static Connection connection = null;

    public static Connection getConnection() {
        checkDriver();
        if (connection == null) {
            synchronized (StatementInit.class) {
                if (connection == null) {
                    try {
                        connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
                    } catch (SQLException ex) {
                        System.out.println("Connection failed");
                        ex.printStackTrace();
                    }
                }
            }
        }

        if (connection != null) {
            System.out.println("Connection to database was successfully");
        } else {
            System.out.println("Failed to connection to data base");
        }
        return connection;
    }

    private static void checkDriver() {
        System.out.println("Testing connection to DB");

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException exception) {
            System.out.println("PostgreSql jdbc driver is not found");
            exception.printStackTrace();
        }

        System.out.println("PostgreSQL JDBC driver successfully connected");
    }

    public static void closeJDBCDriver() {
        try {
            connection.close();
            System.out.println("Connection was closed");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
