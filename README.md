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

# Note:   
You have to run the MainApp.java file and the output you get is like below.
you can not change values if use Di with constructor like this. If you want to modify the values then go with another approach of using setter/getter methods of DI

# Ouput in console: 
Inside SpellCheker Constructor..
Inside checkSpelling.

----------------------------------
# Concept Explanation:
Suppose you have a class 'MainApp' and you want to initilize a bean 'textEditor' [on initlizing call some other class objects] like below, 

public class MainApp {
 public static void main(String[] args) {
      ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
      TextEditor te = (TextEditor) context.getBean("textEditor");  //This will initilize 'textEditor' bean [on inilization calls the constructor method]
   }
} 
   
Then in Beans.xml you just need to add below line of code
	<bean id = "textEditor" class = "com.tpoint.TextEditor">    

If suppose on 'textEditor' Initilization you want to call other class methods like below then,

public class TextEditor {
   public TextEditor(SpellChecker spellChecker) {  //constructor with arguemtns of required class's objects
	   SpellChecker spellchkr = spellChecker;  
     //here the object of class 'SpellChecker' will be passed as arg by spring container and we are stroing that to a class type var 'spellchkr'
	   spellChecker.checkSpelling();
   }	   
}	   

As the object creation of 	'spellChecker' is needed to call its method in 'TextEditor' class during only Initilization then the Beans.xml should be like below:
	<bean id = "textEditor" class = "com.tpoint.TextEditor">
	  	<constructor-arg index="0">
	  		<bean id="spellCheker" class="com.tpoint.SpellChecker"/>
	  	</constructor-arg>
    </bean>

