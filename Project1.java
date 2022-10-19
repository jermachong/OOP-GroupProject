/*
 * Project 1
 * Jeremy Achong, Jaime Chea, and Grace Maroon
 */

import java.util.Scanner;

 public class Project1 {
    public static void main(String[] args){
        Scanner myScan = new Scanner(System.in);

        System.out.println("Choose one of the options:");
        System.out.println("1 - Enter the information a faculty");
        System.out.println("2 - Enter the information of a student");
        System.out.println("3 - Print tuition invoice for a student");
        System.out.println("4 - Print faculty information");
        System.out.println("5 - Enter the information of a staff member");
        System.out.println("6 - Print the information of a staff member");
        System.out.println("7 - Exit Program");
        System.out.println("        \nEnter your selection: ");
        int selection = myScan.nextInt();

        if(selection == 1){
            System.out.println("");
        }
        else if(selection == 2){

        }
        else if(selection == 3){

        }
        else if(selection == 4){

        }
        else if(selection == 5){

        }
        else if(selection == 6){

        }
        else if(selection == 7){

        }
    }
 }

class Person{
    private String fullName; 
    private int id;

    //Setters
    public void setFullName(String fullName){
        this.fullName = fullName; 
    }
    public void setID(int id){
        this.id = id; 
    }

    //Getters
    public String getFullName(){
        return fullName; 
    }
    public int getID(){
        return id; 
    }
}

class Student extends Person{
    Super(fullName, id); 
}
class Employee extends Person{
    Super(fullName, id); 
    private String department; 
}

class Faculty extends Employee{
    Super(fullName, id); 

}

class Staff extends Employee{
    Super(fullName, id); 
}
<<<<<<< HEAD

class Personnel extends Person{
=======

//Creates array of Person
class Personnel{
    private Person[] list; 
    public PersonList() {
        list = new Book[100]; 
    }

    //retrieve array of Persons
    public Person[] getList(){
        return list; 
    }
>>>>>>> c101fcfd7ce46b82b5cfa307de3c2b7b544eb167
    
}

