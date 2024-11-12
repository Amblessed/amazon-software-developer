An abstract class is a class that cannot be instantiated. 
An abstract class may have instance variables and abstract and concrete method
An abstract class must be subclassed
```java
abstract class AbstractButtonClass{
    //class body
}
```
## Abstract Method
- Defined with the abstract keyword
- Doesn't have a method body
- Must be overridden by its subclass

```java
abstract class AbstractButtonClass{
    String caption;
    public abstract void buttonPress(){
        
    }
}
```
**You can't declare an object of an abstract class**
**A concrete method in the abstract class may or may not be overridden by the subclass**

```java
class SendButton extends AbstractButtonClass{
    String sendTo;
    String message;
}
```

## Override
Informs the compiler that the method overrides an element declared in a superclass

## Interface
An interface in Java is a collection of abstract methods that a class must implement. Since the methods are abstract, 
you need to provide only their method signatures (like names, parameters, and return types) without any implementation (in other words, there’s no method body inside curly braces). An interface defines what an implementing class should do without specifying how it should do it.

Java uses the interface keyword to declare an interface and the implements keyword in the declaration of a subclass.

```java
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class SendButtonClass extends AbstractButtonClass implements ButtonPress {
    String sendTo;
    String message;

    @Override
    public void buttonPress() {
        System.out.println("Sending " + this.message
                + " to " + this.sendTo);
    }

}
```
## Interface
An interface is a collection of abstract methods. They don't provide the implementation details.
Declare a concrete method with a default keyword
