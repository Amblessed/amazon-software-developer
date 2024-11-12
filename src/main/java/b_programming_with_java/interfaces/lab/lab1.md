A local college has asked you to develop an application that manages fee collection from students and pays the salaries of the institute’s staff. The application mainly involves Student and Employee classes. Their common attributes and functionality can be defined in an abstract Person class.

Each class has a different set of methods to implement. For example, the Employee class should have methods for calculating salary and tax. On the other hand, the Student class will need to collect a fee.

Note that when a subclass implements an interface, it must implement all its abstract methods. But what if a class needs to utilize only some abstract methods in a given interface?

To address this problem, you can declare separate interfaces:

One to be implemented by the Student class.

And the other to be implemented by the Employee class.

In addition, if any other class needs both sets of methods, it may implement both interfaces (for example, in a TeachingAssistant class, the object is a teacher and a student).