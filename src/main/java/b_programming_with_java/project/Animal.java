package b_programming_with_java.project;



/*
 * @Project Name: amazon-software-developer
 * @Author: Okechukwu Bright Onwumere
 * @Created: 13-Nov-24
 */


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
abstract public class Animal implements Eat {
    private static final long serialVersionUID = 1L;

    // property representing name of the animal
    private String nameOfAnimal;

    // property representing weight
    private int weight;

    // property representing the height
    private int height;

    // property representing the age
    private int age;

    public Animal() {
        nameOfAnimal = "Unknown Animal";
    }

    public Animal(String nameOfAnimal) {
        this.nameOfAnimal = nameOfAnimal;

        // set default weight 200 and height 2 feet and age to 5 years
        this.weight = 200;
        this.height = 2;
        this.age = 5;
    }

    @Override
    public void eatingFood() {
        System.out.println("The animal: " + nameOfAnimal + " is eating.");
    }
}
