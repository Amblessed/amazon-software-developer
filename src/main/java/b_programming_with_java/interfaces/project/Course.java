package b_programming_with_java.interfaces.project;



/*
 * @Project Name: amazon-software-developer
 * @Author: Okechukwu Bright Onwumere
 * @Created: 01-Nov-24
 */


abstract class Course {

    protected Subject subject;
    protected String instructor;
    protected int fee;
    protected int assignmentMarks;
    protected int quizMarks;

    Course(Subject subject, String instructor, int fee) {
        this.subject = subject;
        this.instructor = instructor;
        this.fee = fee;
    }

}
