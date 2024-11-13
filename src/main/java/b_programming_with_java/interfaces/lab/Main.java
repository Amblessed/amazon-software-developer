package b_programming_with_java.interfaces.lab;



/*
 * @Project Name: amazon-software-developer
 * @Author: Okechukwu Bright Onwumere
 * @Created: 01-Nov-24
 */


public class Main {

    public static void main(String[] args) {
        Student student = new Student("John", 25, "Intro to Java", 67);
        student.getDetails();
        student.result();
        student.fee(48000);

        Employee employee = new Employee("Peter", 45, 75000);
        employee.getDetails();
        employee.computeSalary();
        employee.computeTax();
    }
}
