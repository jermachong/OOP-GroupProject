/*
 * Project 1
 * Jeremy Achong, Jaime Chea, and Grace Maroon
 */

 public class Project1 {
    public static void main(String[] args){

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
    
}

