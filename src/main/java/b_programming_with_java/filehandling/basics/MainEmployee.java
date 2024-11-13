package b_programming_with_java.filehandling.basics;



/*
 * @Project Name: amazon-software-developer
 * @Author: Okechukwu Bright Onwumere
 * @Created: 12-Nov-24
 */


import java.io.*;
import java.nio.charset.StandardCharsets;

public class MainEmployee {

    public static void main(String[] args) {
        try {
            FileOutputStream outputStream = new FileOutputStream("EmployeeList.txt");
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, StandardCharsets.UTF_16);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

            Employee employee = new Employee("John", 23, 50000);
            bufferedWriter.write(employee.toString());
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {

            System.out.println("Exception:" + e.getMessage());
        }


        try {
            Employee employee = new Employee("John", 23, 50000);
            FileWriter fileWriter = new FileWriter("Employee.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(employee);
            printWriter.close();
        } catch (IOException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        try {
            Employee employee = new Employee("John", 23, 50000);
            FileWriter fileWriter = new FileWriter("EmployeeFormat.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.printf("Name: %s, Age: %d, Salary: %.2f%n",employee.getName(), employee.getAge(), employee.getSalary());
            printWriter.close();
        } catch (IOException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
