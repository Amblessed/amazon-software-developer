package b_programming_with_java.interfaces.lab;



/*
 * @Project Name: amazon-software-developer
 * @Author: Okechukwu Bright Onwumere
 * @Created: 01-Nov-24
 */


public class Employee extends Person implements EmployeeInterface{

    int basicPay;

    Employee(String name, int age, int basic) {
        this.name = name;
        this.age = age;
        this.basicPay = basic;
    }

    @Override
    public double computeSalary() {
        // Implement the computeSalary() method. The salary is the basicPay+50 percent of basicPay.
        return this.basicPay + (0.5 * this.basicPay);
    }

    @Override
    public double computeTax() {
        //Implement the computeTax() method. It is 10% of the basicPay.
        return 0.1 * this.basicPay;
    }

    @Override
    void getDetails() {
        super.getDetails();
        System.out.printf("Basic Pay: %d%nSalary: %.2f%nTax: %.2f%n", this.basicPay, this.computeSalary(), this.computeTax());
    }
}
