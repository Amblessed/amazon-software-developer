package d_database_management_sql;



/*
 * @Project Name: amazon-software-developer
 * @Author: Okechukwu Bright Onwumere
 * @Created: 04-Nov-24
 */


import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

public class App {

    public static void main(String[] args) {
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()) {
            System.out.println(drivers.nextElement().getClass().getName());
        }
    }
}
