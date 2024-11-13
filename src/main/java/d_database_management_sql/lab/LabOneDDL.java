package d_database_management_sql.lab;



/*
 * @Project Name: amazon-software-developer
 * @Author: Okechukwu Bright Onwumere
 * @Created: 09-Nov-24
 */


import java.sql.*;

public class LabOneDDL {

    private static Connection getDatabaseConnection() {
        String url = "jdbc:mysql://localhost:33061/";
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
        String createDatabaseQuery = "CREATE DATABASE IF NOT EXISTS db_labDDL";
        Statement statement = conn.createStatement();
        statement.execute(createDatabaseQuery);
        System.out.println("Database 'db_labDDL' created successfully (if it didn't exist before)");
        String useDBQuery = "USE db_labDDL;";
        statement.execute(useDBQuery);
        System.out.println("Database 'db_labDDL' set for Use");
    }

    public static void createTable(Connection conn) throws SQLException {

        String createTableQuery = """
                CREATE TABLE IF NOT EXISTS tbl_housing_property(property_id INT PRIMARY KEY AUTO_INCREMENT, address VARCHAR(255), type VARCHAR(255), rent_price DECIMAL(10, 2));
                """;
        Statement statement = conn.createStatement();
        boolean result = statement.execute(createTableQuery);
        if (!result){
            System.out.println("Table 'housing_property' created successfully");
        }
    }

    public static void showColumnsInTable(Connection conn) throws SQLException {

        String showColumnsQuery = """
                SHOW COLUMNS FROM tbl_housing_property;
                """;
        //Statement statement = conn.createStatement();
        PreparedStatement preparedStatement = conn.prepareStatement(showColumnsQuery);
        ResultSet resultSet = preparedStatement.executeQuery();
        ResultSetMetaData metaData = resultSet.getMetaData();
        for (int i = 1; i <= metaData.getColumnCount(); i++) {
            System.out.print(metaData.getColumnName(i) + "\t");
        }
        System.out.println();
    }

    public static void addParkingSpacesColumn(Connection conn) throws SQLException {
        String alterTableQuery = """
                ALTER TABLE tbl_housing_property ADD COLUMN parking_spaces INT
                """;
        Statement statement = conn.createStatement();
        boolean result = statement.execute(alterTableQuery);
        if (!result){
            System.out.println("Column 'parking_spaces' added successfully");
        }
    }

    public static void dropPropertiesTable(Connection conn) throws SQLException {
        String alterTableQuery = """
                DROP TABLE IF EXISTS tbl_housing_property
                """;
        Statement statement = conn.createStatement();
        boolean result = statement.execute(alterTableQuery);
        if (!result){
            System.out.println("Table 'tbl_housing_property' dropped successfully");
        }
    }

    public static void main(String[] args) throws SQLException {
        Connection conn = getDatabaseConnection();
        createDatabase(conn);
        createTable(conn);
        showColumnsInTable(conn);
        addParkingSpacesColumn(conn);
        showColumnsInTable(conn);
        dropPropertiesTable(conn);
    }
}
