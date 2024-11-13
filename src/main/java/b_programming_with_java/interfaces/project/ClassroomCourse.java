package b_programming_with_java.interfaces.project;



/*
 * @Project Name: amazon-software-developer
 * @Author: Okechukwu Bright Onwumere
 * @Created: 02-Nov-24
 */


public class ClassroomCourse extends Course {

    String school;
    String session;
    ClassroomCourse(Subject subject, String instructor, int fee,
                    String school, String session) {
        super(subject, instructor, fee);
        this.school = school;
        this.session = session;
    }

}
