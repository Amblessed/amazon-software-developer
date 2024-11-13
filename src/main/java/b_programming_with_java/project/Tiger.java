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
 * TODO 1.a: Implement serializable interface for class Tiger
 */

@Getter
@Setter
@ToString
public class Tiger extends Animal implements Walk, Serializable {
    private static final long serialVersionUID = 1L;

    // property for stripes on tiger
    int numberOfStripes;

    // property for speed of tiger during walking or running
    int speed;

    // property for sound level when tiger roars
    int soundLevel;

    public Tiger() {
        super("Tiger");
    }


    @Override
    public void eatingCompleted() {
        System.out.println("Tiger: I have eaten meat.");
    }

    @Override
    public void walking() {
        System.out.println("Tiger: I am moving at the speed " + speed);
    }

}
