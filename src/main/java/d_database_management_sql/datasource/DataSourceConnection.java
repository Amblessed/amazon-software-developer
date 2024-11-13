package d_database_management_sql.datasource;



/*
 * @Project Name: amazon-software-developer
 * @Author: Okechukwu Bright Onwumere
 * @Created: 05-Nov-24
 */


import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataSourceConnection {

    public void connect(String databaseUrl, String username, String password) throws SQLException {
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setURL(databaseUrl);
        mysqlDataSource.setUser(username);
        mysqlDataSource.setPassword(password);
        mysqlDataSource.setLoginTimeout(15);

        try (Connection dataSourceConnection = mysqlDataSource.getConnection();
             Statement statement = dataSourceConnection.createStatement();
             ResultSet resultSet = statement.executeQuery("select first_name from actor");)
        {
            System.out.println("Connected to database");
            while (resultSet.next()) {
                System.out.printf("First Name: %s%n", resultSet.getString("first_name"));
            }
        }
        catch (SQLException sqlException) {
            System.err.println("Connection Error: Check connection parameters");
            sqlException.printStackTrace();
        }
        catch (Exception exception) {
            System.err.println("Connection Error: Check connection parameters");
        }
    }

}
