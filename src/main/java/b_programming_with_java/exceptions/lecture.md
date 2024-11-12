Exceptions that occur during compile time are known as checked exceptions or non-runtime exceptions.
Exceptions that occur during runtime are known as unchecked exceptions or runtime exceptions. 
An Error is always Unchecked, meaning that it occurs at runtime. Division by Zero

Throwable: Represents any unexpected behaviour or an exceptional event that occurs during program execution. It can be
Error or Exception. 

**Checked Exceptions**: The compiler checks the code and signals that something is not right and that it needs to be 
handled. Caught, declared, or thrown from code using the `throws` keyword
**Unchecked Exceptions**: Not checked by the compiler. Anything that is not correct will pass on to the runtime. Avoided with mindful coding
and thorough testing

All Exceptions are recoverable including Unchecked Exceptions. However, the compiler doesn’t check for the existence of them 
in the code and therefore, the developer isn’t forced to handle them. These Exceptions are also known as Runtime Exceptions, 
as they fire up during runtime  

**Handling Checked Exceptions**  
Java primarily provides two ways of handling exceptions in your code.
- Adding the exception to the method signature. 
- Surrounding the code with a try-catch block.

**Throwable Class**: The parent of all exception and error classes