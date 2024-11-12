package programming_with_java.interfaces.lab;



/*
 * @Project Name: amazon-software-developer
 * @Author: Okechukwu Bright Onwumere
 * @Created: 01-Nov-24
 */

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
abstract class Person {
    String name;
    int age;

    void getDetails() {
        System.out.printf("Name: %s%nAge: %d%n", name, age);
    }
}
