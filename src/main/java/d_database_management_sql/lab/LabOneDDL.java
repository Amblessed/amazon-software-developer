package d_database_management_sql.lab;



/*
 * @Project Name: amazon-software-developer
 * @Author: Okechukwu Bright Onwumere
 * @Created: 09-Nov-24
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class LabOne {

    private static Connection getDatabaseConnection() {
        String url = "jdbc:mysql://localhost:33061/db_restaurant";
        String user = "root";
        String password = System.getenv("MYSQL_WSL_PASSWORD");
        try{
            return DriverManager.getConnection(url, user, password);
        }
        catch(SQLException e){
            System.out.println("Connection Failed! Check output console: " + e.getMessage());
            return null;
        }
        catch(Exception e){
            System.out.println("Unexpected error occurred while trying to connect to database: " + e.getMessage());
            return null;
        }
    }

    public static void createDatabase(Connection conn) throws SQLException {
        String createDatabase = "CREATE DATABASE IF NOT EXISTS db_lab";
        Statement statement = conn.createStatement();
        statement.execute(createDatabase);
        System.out.println("Database 'db_lab' created successfully (if it didn't exist before)");

    }

    public static void main(String[] args) {

    }
}
