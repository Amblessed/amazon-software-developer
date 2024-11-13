package d_database_management_sql.basics;



/*
 * @Project Name: amazon-software-developer
 * @Author: Okechukwu Bright Onwumere
 * @Created: 03-Nov-24
 */


import org.apache.commons.lang3.StringUtils;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseConnection {

    public static void main(String[] args) {
        // Connection details for the Chinook MySQL database
        String url = "jdbc:mysql://localhost:33061/db_restaurant";
        String user = "root";
        String password = System.getenv("MYSQL_WSL_PASSWORD");
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            // Check if the connection was successful
            if (connection != null) {
                System.out.println("Connected to the db_restaurant database!");
                Statement stmt = connection.createStatement();
                // Execute the query to fetch artist names
                ResultSet rs = stmt.executeQuery("SELECT * FROM tbl_menu_items LIMIT 5");
                ResultSetMetaData rsmd = rs.getMetaData();

                ArrayList<String> columnNames = new ArrayList<>();
                ArrayList<Integer> columnNamesLength = new ArrayList<>();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    columnNames.add(rsmd.getColumnName(i));
                }

                for (String columnName : columnNames) {
                    columnNamesLength.add(columnName.length());
                }

                StringBuilder plusDashes = new StringBuilder();
                for (Integer integer : columnNamesLength) {
                    String repeated = "-".repeat(integer+2);
                    plusDashes.append("+").append(repeated);
                }
                plusDashes.append("+");
                System.out.println(plusDashes);

                StringBuilder tableHeaders = new StringBuilder();
                for (int i = 0; i < columnNames.size(); i++) {
                    tableHeaders.append(StringUtils.center(String.format("| %s ", columnNames.get(i)), columnNamesLength.get(i) + 2));
                }
                tableHeaders.append("|");
                System.out.println(tableHeaders);

                System.out.println(plusDashes);

                String tableRow = "";

                while (rs.next()) {
                    int menuItemId = rs.getInt("menu_item_id");
                    String itemName = rs.getString("item_name");
                    String category = rs.getString("category");
                    double price = rs.getDouble("price");
                    System.out.println("menuItemId: " + menuItemId);
                    System.out.println("itemName: " + itemName);
                    System.out.println("category: " + category);
                    System.out.println("price: " + price);
                }
                rs.close();
                stmt.close();
            }

        } catch (SQLException e) {
            // Handle SQL errors during connection
            System.out.println("Connection failed: " + e.getMessage());
        }finally {

        }
    }
}
