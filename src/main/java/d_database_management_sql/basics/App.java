package d_database_management_sql.basics;



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


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Enumeration<Driver> classDrivers = DriverManager.getDrivers();
            while (classDrivers.hasMoreElements()) {
                System.out.println(classDrivers.nextElement().getClass().getName());
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Driver Class not found");
        }
    }
}
