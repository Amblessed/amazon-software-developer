package b_programming_with_java.interfaces.project;



/*
 * @Project Name: amazon-software-developer
 * @Author: Okechukwu Bright Onwumere
 * @Created: 01-Nov-24
 */


public class Subject {

    private String title;
    private double credits;

    Subject(String title, double credits) {
        this.title = title;
        this.credits = credits;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "title='" + title + '\'' +
                ", credits=" + credits +
                '}';
    }
}
