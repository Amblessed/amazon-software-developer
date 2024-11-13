package c_data_structures_and_algorithms.arraylist;



/*
 * @Project Name: amazon-software-developer
 * @Author: Okechukwu Bright Onwumere
 * @Created: 08-Oct-24
 */


import java.util.ArrayList;

public class ExerciseMain {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.set(2, 30);
        System.out.println(list);
    }
}
