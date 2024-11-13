package b_programming_with_java.serialization;



/*
 * @Project Name: amazon-software-developer
 * @Author: Okechukwu Bright Onwumere
 * @Created: 13-Nov-24
 */

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

@Getter
@AllArgsConstructor
@Setter
@ToString
public class Player implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String name;
    private int level;
    private int score;
    private transient String password;   //this would not be serialized
}
