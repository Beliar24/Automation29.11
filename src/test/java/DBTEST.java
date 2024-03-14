import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static java.lang.String.format;

public class DBTEST {

    static final String DB_URL = "jdbc:postgresql://localhost:5432/habrdb";
    static final String USERNAME = "postgres";
    static final String PASSWORD = "postgres";

    static Statement statement = null;

    public static void main(String[] args) {
        System.out.println("Testing connection to DB");

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException exception) {
            System.out.println("PostgreSql jdbc driver is not found");
            exception.printStackTrace();
        }

        System.out.println("PostgreSQL JDBC driver successfully connected");
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        } catch (SQLException ex) {
            System.out.println("Connection failed");
            ex.printStackTrace();
        }

        if (connection != null) {
            System.out.println("Connection to database was successfully");
        } else {
            System.out.println("Failed to connection to data base");
        }

        //SELECT
        try {
            statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT * FROM USERS");

            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String email = rs.getString("email");

                System.out.println(format("The user - %s, %d, %s", name, age, email));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // one to one
        // singer -> <- instrument


        // one to many
        // singer -> albums


        // many to many
        // singer -> <- notes
    }
}
