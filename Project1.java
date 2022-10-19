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
        System.out.println("\n    Enter your selection: ");
        int selection = myScan.nextInt();

        if(selection == 1){
            System.out.println("Enter the faculty info:");
            // Get Name
            System.out.println("    Name of the faculty member: ");
            String newName = myScan.nextLine();
            // Get ID
            System.out.println("ID: ");
            String newID = myScan.nextLine();
            // Get Rank
            do{
                System.out.println("Rank: ")
                String newRank = myScan.nextLine();
                newRank = newRank.toLowerCase(); // make the string all lowercase to compare to accepted ranks

                if(newRank.compareTo("professor") == 1 || newRank.compareTo("adjunct") == 1)
                    System.out.println(newRank + " is invalid");
            } while(newRank.compareTo("professor") == 1 || newRank.compareTo("adjunct") == 1)

             
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
    String fullName; 
    int id;
    private String fullName; 
    private String id;

    //Setters
    public void setFullName(String fullName){
        this.fullName = fullName; 
    }
    public void setID(String id){
        this.id = id; 
    }

    //Getters
    public String getFullName(){
        return fullName; 
    }
    public String getID(){
        return id; 
    }

    //Constructor
    public Person(){
        fullName = "None"; 
        id = "00"; 
    }
    public Person(String fullName, String id){
        this.fullName = fullName;  
        this.id = id; 
    }

    //toString
    public String toString(){
        return "[" + "Full Name: " + fullName + "\n" + "ID: " + id; 
    }

    //Other functions

    //Print out full name and ID
    public void printPersonInfo(){
        System.out.println("---------------------------------------------------------------------------\n\n");
        System.out.println(fullName + "\t\t" + id); 
    }
}

class Student extends Person{ 
    private double gpa; 
    private int creditHours; 

    //Setters
    public void setGPA(double gpa){
        this.gpa = gpa; 
    }
    public void setCreditHours(int creditHours){
        this.creditHours = creditHours; 
    }

    //Getters
    public double getGPA(){
        return gpa; 
    }
    public int getCreditHours(){
        return creditHours; 
    }

    //Constructor
    public Student(String fullName, String id, double gpa, int creditHours){
        super(fullName, id);
        this.gpa = gpa; 
        this.creditHours = creditHours; 
    }
    
    //Other functions

    //prints the student's tution invoice
    public void tuitionInvoice(String id){
        printPersonInfo(); //Prints seperating line + Student's info. 
    }
}
class Employee extends Person{

}

class Faculty extends Employee{

}

class Staff extends Employee{

}

//Creates array of Person
class Personnel{
    private Person[] list; 
    public Personnel() {
        list = new Person[100]; 
    }

    //retrieve array of Persons
    public Person[] getList(){
        return list; 
    }
    
}

