package c_data_structures_and_algorithms.arrays;



/*
 * @Project Name: amazon-software-developer
 * @Author: Okechukwu Bright Onwumere
 * @Created: 07-Oct-24
 */


import java.util.Arrays;

public class Main {

    public static void removeElement(int indexToDelete, Student[] originalArray){
        Student[] arrays = new Student[originalArray.length - 1];

        for (int i = 0; i < originalArray.length; i++) {
                if (i != indexToDelete) {
                    arrays[i] = originalArray[i];
                }
        }
        System.out.println("Remove element at index " + indexToDelete);
        printArray("Remove", arrays);
    }
    public static void addElement(Student newStudent,Student[] originalArray){
        Student[] arrays = Arrays.copyOf(originalArray, originalArray.length + 1);
        arrays[arrays.length - 1] = newStudent;
        System.out.println("Add new Student: " + newStudent);
        printArray("Add", arrays);
    }
    public static void updateElement(int indexToUpdate, Student[] originalArray){
        // TODO 11: locate the element you need to update. Use the element's index of the array.
        //TODO 12: once you have the index, access the element and update its properties.
        // Use the ‘setter’ method in the Student class to change values like name, age, or ID.
        printArray("Update",originalArray);
    }
    public static void printArray(String message, Student[] students){
        System.out.println("Operation: " + message);
        for (Student student : students) {
            System.out.println("Student Name: " + student.getName());
        }
    }

    public static void main(String[] args) {
        String[] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        System.out.println(Arrays.toString(daysOfWeek));

        for (String s : daysOfWeek) {
            System.out.println(s);
        }

        // created array object of Student class
        Student[] students = new Student[5];
        // set the values through the constructor
        students[0] = new Student(1,"John", 19);

        students[1] = new Student(2,"Mary", 21);
        students[2] = new Student(3,"Sandra", 23);
        students[3] = new Student(4,"Peter", 20);
        students[4] = new Student(5,"Paul", 20);

        int indexToDelete = 4;
        removeElement(indexToDelete, students);

        Student addStudent = new Student(6,"Chioma", 21);
        addElement(addStudent, students);

        //int IndexToUpdate = "PASS_HERE_INDEX_TO_BE_UPDATED";
        //updateElement(IndexToUpdate, students);


    }
}
