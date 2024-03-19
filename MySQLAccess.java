import java.sql.*;

public class MySQLAccess {

    // PIVs
    private static Connection connection = null;
    private static Statement statement = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;

    // select
    public static void select(String columns, String table, String where) throws SQLException {

        String statement = "SELECT " + columns + " from countries." + table + " WHERE " + where + ";";
        preparedStatement = connection.prepareStatement(statement);
        resultSet = preparedStatement.executeQuery();

    }

    // update
    public static void update(String table, String set, String where) throws SQLException {

        String statement = "UPDATE countries." + table + " SET " + set + " WHERE " + where + ";";
        preparedStatement = connection.prepareStatement(statement);
        preparedStatement.executeUpdate();

    }

    // delete
    public static void delete(String table, String where) throws SQLException {

        String stmt = "DELETE countries." + table + " WHERE " + where + ";";
        preparedStatement = connection.prepareStatement(stmt);
        preparedStatement.execute();

    }

    public static void main(String[] args) throws Exception {

        // connecting to database
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

        // print top 20 countries
        select("*", "world_happiness_2019", "overall_rank < 21");
        System.out.println("Top 20 Countries");
        System.out.println();
        System.out.println("Rank          Country");
        while(resultSet.next()) {
            int rank = resultSet.getInt("overall_rank");
            String country = resultSet.getString("Country");
            System.out.println(rank + "          " + country);
        }
        System.out.println();


        // update Australia ranking
        System.out.println();
        update("world_happiness_2019", "overall_rank = 1", "Country = \"Australia\"");
        select("*", "world_happiness_2019", "Country = \"Australia\"");
        System.out.println("Australia #1?");
        System.out.println();
        while(resultSet.next()) {
            int rank = resultSet.getInt("overall_rank");
            String country = resultSet.getString("Country");
            System.out.println(country + " is rank " + rank);
        }
        System.out.println();


        // fix Australia ranking
        System.out.println();
        update("world_happiness_2019", "overall_rank = 11", "Country = \"Australia\"");
        select("*", "world_happiness_2019", "Country = \"Australia\"");
        System.out.println("Australia #11?");
        System.out.println();
        while(resultSet.next()) {
            int rank = resultSet.getInt("overall_rank");
            String country = resultSet.getString("Country");
            System.out.println(country + " is rank " + rank);
        }
        System.out.println();

        // delete Australia because I hate them
        System.out.println();
        delete("world_happiness_2019", "Country = \"Australia\"");
        select("*", "world_happiness_2019", "overall_rank < 21");
        System.out.println("Does Australia exist?");
        System.out.println("Top 20 Countries");
        System.out.println();
        System.out.println("Rank          Country");
        while(resultSet.next()) {
            int rank = resultSet.getInt("overall_rank");
            String country = resultSet.getString("Country");
            System.out.println(rank + "          " + country);
        }
        System.out.println();


//
//        System.out.println();
//        System.out.println();
//        System.out.println("Number of countries in list:");
//
//        // count number of countries in database
//        statement = connection.createStatement();
//        resultSet = statement.executeQuery("select count(*) from countries.world_happiness_2019");
//        resultSet.next();
//        int count = resultSet.getInt(1);
//        System.out.println(count);
//
//        System.out.println();
//        System.out.println();
//
//        // print last 20 countries
//
//        int last = count - 20;
//
//        preparedStatement = connection.prepareStatement("select * from countries.world_happiness_2019 where overall_rank > " + last);
//        resultSet = preparedStatement.executeQuery();
//
//        System.out.println("Bottom 20 Countries");
//
//        System.out.println();
//
//        System.out.println("Rank          Country");
//
//        while(resultSet.next()) {
//            int rank = resultSet.getInt("overall_rank");
//            String country = resultSet.getString("Country");
//            System.out.println(rank + "          " + country);
//        }
//
//        System.out.println();
//        System.out.println();
//
//
//        // update rank of Australia
//
//        preparedStatement = connection.prepareStatement("update countries.world_happiness_2019 set overall_rank = 1 where Country = Australia;");
//        resultSet = preparedStatement.executeQuery();
//
//        System.out.println("If Australia was #1");
//        System.out.println();
//        System.out.println("Rank          Country");
//
//        while(resultSet.next()) {
//            int rank = resultSet.getInt("overall_rank");
//            String country = resultSet.getString("Country");
//            System.out.println(rank + "          " + country);
//        }
//
//        System.out.println();
//        System.out.println();
//
//
//
//        // update rank of Australia
//
//
//
//
//        // update rank of Belgium and undo









        connection.close();

    }

}
