package b_programming_with_java.project;



/*
 * @Project Name: amazon-software-developer
 * @Author: Okechukwu Bright Onwumere
 * @Created: 13-Nov-24
 */


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * TODO 1.c: Implement serializable interface for class Dolphin
 */
@Getter
@Setter
@ToString
public class Dolphin extends Animal implements Swim, Serializable {
    private static final long serialVersionUID = 1L;

    // property for color of dolphin
    String color;

    // property for speed of dolphin
    int swimmingSpeed;

    public Dolphin() {
        super("Dolphin");
    }

    @Override
    public void eatingFood() {
        System.out.println("Dolphin: I am eating delicious fish.");
    }

    @Override
    public void eatingCompleted() {
        System.out.println("Dolphin: I have eaten fish.");
    }

    @Override
    public void swimming() {
        System.out.println("Dolphin: I am swimming at the speed " + swimmingSpeed);
    }



}

