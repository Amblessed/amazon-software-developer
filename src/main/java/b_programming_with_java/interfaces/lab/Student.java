package b_programming_with_java.interfaces.lab;



/*
 * @Project Name: amazon-software-developer
 * @Author: Okechukwu Bright Onwumere
 * @Created: 01-Nov-24
 */

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student extends Person implements StudentInterface{

    private String subject;
    private int marks;

    public Student(String name, int age, String subject, int marks) {
        this.name = name;
        this.age = age;
        this.subject = subject;
        this.marks = marks;
    }

    @Override
    void getDetails() {
        super.getDetails();
    }


    @Override
    public void result() {

        if(this.marks > 50){
            System.out.printf("Subject: %s%nMarks: %s%nResult: Pass%n", subject, marks);
        }
        else{
            System.out.printf("Subject: %s%nMarks: %s%nResult: Failed%n", subject, marks);
        }
    }

    @Override
    public void fee(int amount) {
        System.out.printf("Student pays the fee: %d%n", amount);
    }

}
