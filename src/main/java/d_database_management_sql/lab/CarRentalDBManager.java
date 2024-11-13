package d_database_management_sql.lab;



/*
 * @Project Name: amazon-software-developer
 * @Author: Okechukwu Bright Onwumere
 * @Created: 09-Nov-24
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class CarRentalDBManager {

    // Task 1: Adding a new car and customer
    public static void addCarAndCustomer(Connection conn) {

        PreparedStatement pstmt = null;
        PreparedStatement customerPstmt = null;
        ResultSet generatedKeys = null;

        try {
            // TODO 1: write the SQL query to insert a new car into the cars table.
            /* TODO 2: use a PreparedStatement to execute the customerQuery
             * set the model : "Toyota Camry"
             * set the year: 2021
             * set the availability : false
             * execute the query using the executeUpdate() method
             */
             String insertCarQuery = "INSERT INTO cars (model, year, availability) VALUES (?, ?, ?)";
             pstmt = conn.prepareStatement(insertCarQuery, Statement.RETURN_GENERATED_KEYS);
             pstmt.setString(1, "Toyota Camry");
             pstmt.setInt(2, 2021);
             pstmt.setBoolean(3, false);
             pstmt.executeUpdate();

            // retrieve the generated car_id from the ResultSet after executing the update
            generatedKeys = pstmt.getGeneratedKeys();
            int carId = 0;
            if (generatedKeys.next()) {
                // retrieve the car_id
                carId = generatedKeys.getInt(1);
            }
            // TODO 3: write the SQL query to insert a new customer into the customers table
            String insertCustomerQuery = "INSERT INTO customers (name, car_id) VALUES (?, ?)";
            /* TODO 4: create a PreparedStatement using the customerQuery
             * set the customer name : John Doe
             * set car_id:retrieved from the generated keys
             * execute the query using the executeUpdate() method
             */
            customerPstmt = conn.prepareStatement(insertCustomerQuery);
            customerPstmt.setString(1, "John Doe");
            customerPstmt.setInt(2, carId);
            // print success messages confirming that the car and customer were successfully added
            System.out.println("Car added successfully: Toyota Camry (2021)");
            System.out.println("Customer 'John Doe' associated with car ID: " + carId);

        } catch (SQLException e) {
            // handle SQL exception
            System.out.println("Error occurred while adding car or customer: " + e.getMessage());
        } finally {
            // close resources in the finally block to avoid resource leaks
            try {
                if (generatedKeys != null) {
                    generatedKeys.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (customerPstmt != null) {
                    customerPstmt.close();
                }
            } catch (SQLException e) {
                System.out.println("Error occurred while closing resources: " + e.getMessage());
            }
        }
    }

    // Task2: Updating a car's availability and removing the customer
    public static void updateCarAndRemoveCustomer(Connection conn) throws SQLException {
        // TODO 5: write the SQL query to update the availability of the car
        String updateQuery = "UPDATE cars SET availability = ? WHERE car_id = ?";

        /* TODO 6: use a PreparedStatement to execute the query to update the car's availability
         * set the availability: true
         * car id (1 for Toyota Camry)
         * execute the query
         */
        PreparedStatement pstmt = conn.prepareStatement(updateQuery);
        pstmt.setBoolean(1, false);
        pstmt.setInt(2, 1);
        pstmt.executeUpdate();

        // TODO 7: write the SQL query to delete the customer entry from the 'customers' table
        String deleteQuery = "DELETE FROM customers WHERE car_id = ?";

        /* TODO 8: use a PreparedStatement to execute the query to remove the customer
         * set car_id : 1
         * execute the query
         */
        pstmt = conn.prepareStatement(deleteQuery);
        pstmt.setInt(1, 1);
        pstmt.executeUpdate();

        // print success messages
        System.out.println("Car availability updated: Toyota Camry is now available.");
        System.out.println("Customer 'John Doe' removed from the system.");
    }

    // Task 3: Fetching all available cars and status
    public static void fetchAllCarsAndStatus(Connection conn) {
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // TODO 9: write the SQL query to fetch all available cars and their associated customers
            // TODO 11: use a Statement object to execute the query and retrieve the result set
            /* TODO 12: iterate over the result set and print the details of each available car
             * loop through each row in the ResultSet
             *  retrieve the car model
             *  retrieve the customer name, if any
             *      print the car model
             *  check if the car is rented by a customer
             *      print the customer name if the car is rented
             *      print that the car is available if no customer is associated
             */
            // print a separator for clarity
          System.out.println("----------------------");
          String selectQuery = "SELECT model, name FROM cars LEFT JOIN customers USING(car_id)";
          stmt = conn.createStatement();
          rs = stmt.executeQuery(selectQuery);
          while (rs.next()) {
              String model = rs.getString("model");
              String customerName = rs.getString("name");
              System.out.printf("Car Model: %s%n", model);
              if(customerName != null) {
                  System.out.printf("Rented By: %s%n", customerName);
              }
              else{
                  System.out.println("Available for rent");
              }
          }
        } catch (SQLException e) {
            // Handle SQL exception
            System.out.println("Error occurred while fetching available cars and customers: " + e.getMessage());
        } finally {
            // Close resources in the finally block to avoid resource leaks
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                System.out.println("Error occurred while closing resources: " + e.getMessage());
            }
        }
    }

    // Method to create the CarRentalDB database
    public static void createDatabase(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();
        String dropQuery = "DROP DATABASE IF EXISTS CarRentalDB";
        stmt.executeUpdate(dropQuery);
        String query = "CREATE DATABASE IF NOT EXISTS CarRentalDB";
        stmt.executeUpdate(query);
        System.out.println("Database 'CarRentalDB' created successfully (if it didn’t exist).");
    }

    // Method to create the 'cars' and 'customers' tables
    public static void createTables(Connection conn) throws SQLException {
        // switch to the CarRentalDB database
        String useDBQuery = "USE CarRentalDB";
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(useDBQuery);

        // create 'cars' table
        String createCarsTable = "CREATE TABLE IF NOT EXISTS cars ("
                + "car_id INT AUTO_INCREMENT PRIMARY KEY, "
                + "model VARCHAR(100), "
                + "year INT, "
                + "availability BOOLEAN)";
        stmt.executeUpdate(createCarsTable);
        System.out.println("Table 'cars' created successfully.");

        // create 'customers' table with a foreign key referencing 'car_id'
        String createCustomersTable = "CREATE TABLE IF NOT EXISTS customers ("
                + "customer_id INT AUTO_INCREMENT PRIMARY KEY, "
                + "name VARCHAR(100), "
                + "car_id INT, "
                + "FOREIGN KEY (car_id) REFERENCES cars(car_id))";
        stmt.executeUpdate(createCustomersTable);
        System.out.println("Table 'customers' created successfully.");
    }

    // Establishing Connection:
    private static Connection getDatabaseConnection() {
        String url = "jdbc:mysql://localhost:33061/";
        String user = "root";
        String password = System.getenv("MYSQL_WSL_PASSWORD");

        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Connection failed SQLException: " + e.getMessage());
            return null;
        } catch (Exception e) {
            System.out.println("Connection failed Exception: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        Connection conn = null;
        try {
            // establish the connection to MySQL
            conn = getDatabaseConnection();
            // check connection is not null before using it
            if (conn != null) {

                // create the database and tables
                CarRentalDBManager.createDatabase(conn);
                CarRentalDBManager.createTables(conn);

                // add a new car and associate a customer with it
                CarRentalDBManager.addCarAndCustomer(conn);

                // update the car's availability and remove the customer
                CarRentalDBManager.updateCarAndRemoveCustomer(conn);

                // fetch all available cars and display their details
                CarRentalDBManager.fetchAllCarsAndStatus(conn);

            } else {
                System.err.println("Failed to establish a connection to the database.");
            }
        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
        } finally {
            // close the connection if it was successfully opened
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Database connection closed.");
                } catch (SQLException e) {
                    System.err.println("Error closing the database connection: " + e.getMessage());
                }
            }
        }
    }


}

