package d_database_management_sql.datasource;



/*
 * @Project Name: amazon-software-developer
 * @Author: Okechukwu Bright Onwumere
 * @Created: 05-Nov-24
 */


import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        System.out.println(System.getenv("MYSQL_WSL_PASSWORD"));
        DataSourceConnection dataSourceConnection = new DataSourceConnection();
        try {
            dataSourceConnection.connect("jdbc:mysql://localhost:33061/sakila", "root", System.getenv("MYSQL_WSL_PASSWORD"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
