# Spring-DI
spring DI constructor proj:
=====================================

This project describes the concept of dependency injection.

Let's take we have Class A, Class B and we want to call methods of Class B in Class A.
So normal method is to create an object for Class B in Class A and then with the object reference we call the methods of Class B.
But instead creating an object, calling the methods of Class B leaving the object creation to Spring framework is called Dependency Injection.
This is achieved with the help of two ways.
1. Using Setter & Getter methods
2. Using Constructor.

In this project we discuss about DI using Constructor.
In Class A we create a constructor with parameters as object of Class B.
Using that object in the constructor itself calling methods of ClassB.

So when ever a Class A bean is initialized, its constructor is called and the methods of Class B are executed which are defined in constructor class.

Note:   You have to run the MainApp.java file and the output you get is like below.
Ouput in console: 
Inside SpellCheker Constructor..
Inside checkSpelling.
