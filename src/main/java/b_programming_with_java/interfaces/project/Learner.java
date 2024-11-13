package b_programming_with_java.interfaces.project;



/*
 * @Project Name: amazon-software-developer
 * @Author: Okechukwu Bright Onwumere
 * @Created: 01-Nov-24
 */


public class Learner {

    private String name;
    private double grade;
    private Course course;
    private double gradeSource;

    public Learner(String name, Course course) {
        this.name = name;
        this.course = course;
    }
}
