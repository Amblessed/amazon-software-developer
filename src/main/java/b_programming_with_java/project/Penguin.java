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
 * TODO 1.b: Implement serializable interface for class Penguin
 */
@Getter
@Setter
@ToString
public class Penguin extends Animal implements Walk, Swim, Serializable {
    private static final long serialVersionUID = 1L;

    boolean isSwimming;
    int walkSpeed;
    int swimSpeed;

    public boolean isSwimming() {
        return isSwimming;
    }

    public void setSwimming(boolean swimming) {
        isSwimming = swimming;
    }

    public Penguin() {
        super("Penguin");
    }

    @Override
    public void eatingFood() {
        System.out.println("Penguin: I am eating delicious fish.");
    }

    @Override
    public void eatingCompleted() {
        System.out.println("Penguin: I have eaten fish.");
    }

    @Override
    public void swimming() {
        System.out.println("Penguin: I am swimming at the speed " + swimSpeed + " nautical miles per hour");
    }

    @Override
    public void walking() {
        System.out.println("Penguin: I am walking at the speed " + walkSpeed + " mph");
    }

}
