import java.sql.*;

public class MySQLAccess {

    // PIVs
    private Connection connection = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    // connects to database
    public void connect() {

        try {

            String url = "jdbc:mysql://localhost:3006";
            String username = "root";
            String password = "chicken";

            // connecting to database
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(url, username, password);

        } catch (ClassNotFoundException e) {

            e.printStackTrace();

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

    public static void main(String[] args) throws Exception {

        MySQLAccess test = new MySQLAccess();
        test.connect();

    }

}
