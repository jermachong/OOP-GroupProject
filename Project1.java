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
            System.out.println("    ID: ");
            String newID = myScan.nextLine();
            // Get Rank
            do{
                System.out.println("    Rank: ")
                String newRank = myScan.nextLine();
                newRank = newRank.toLowerCase(); // make the string all lowercase to compare to accepted ranks

                if(newRank.compareTo("professor") == 1 || newRank.compareTo("adjunct") == 1)
                    System.out.println(newRank + " is invalid");
            } while(newRank.compareTo("professor") == 1 || newRank.compareTo("adjunct") == 1)

            do{
                System.out.println("    Department: ")
                String newDepartment = myScan.nextLine();
                newRank = newDepartment.toLowerCase(); // make the string all lowercase to compare to accepted ranks

                if(newDepartment.compareTo("mathematics") == 1 || newDepartment.compareTo("engineering") == 1 || newDepartment.compareTo("sciences") == 1)
                    System.out.println(newDepartment + " is invalid");
            } while(newDepartment.compareTo("mathematics") == 1 || newDepartment.compareTo("engineering") == 1 || newDepartment.compareTo("sciences") == 1)
            // create new Faculty object and add this info to it/add to Person array
            // create new Faculty 'f' with constructor?
            // Faculty f = new Faculty() 

            System.out.println("Faculty added!");
            }
        }
        else if(selection == 2){
            System.out.println("Enter the student info:");
            // Get Name
            System.out.println("    Name of the student: ");
            String newName = myScan.nextLine();
            // Get ID
            System.out.println("    ID: ");
            String newID = myScan.nextLine();
            // Get GPA
            System.out.println("    GPA: ")
            double newGPA = myScan.nextDouble();
            // Get Credit Hours
            System.out.println("    Credit Hours: ");
            int newHours = myScan.nextInt();

            // Create Student 's', add info. to 's', add to Person[], 
            System.println.out("Student added!")
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

abstract class Person{
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
    
    //Abstract function to be overriden in Student, Fac, and Staff
    public abstract void print();


    //Print out full name and ID, useful for all print()
    public void printPersonInfo(){
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

    //prints the student's tution invoice NOT FINISHED
    public void print(){
        super.printPersonInfo(); //Prints seperating line + Student's info.
    }
}

abstract class Employee extends Person{
    private String department; //mathematics, engineering or sciences

    //Setters
    public void setDepartment(String department){
        this.department = department; 
    }

    //Getters
    public String getDepartment(){
        return department; 
    }

    //Constructors
    public Employee(String fullName, String id, String department){
        super(fullName,id);
        this.department = department; 
    }

}

class Faculty extends Employee{
    private String rank; //professor or adjunct

    //Setters
    public void setRank(String rank){
        this.rank = rank; 
    }

    //Getters
    public String getRank(){
        return rank;
    }

    //Constructors
    public Faculty(String fullName, String id, String department, String rank){
        super(fullName, id, department);
        this.rank = rank;
    }

    //print info for faculty (department + rank)
    public void print(){

    }

}

class Staff extends Employee{
    private String status; //part time or full time

    //Setters
    public void setStatus(String status){
        this.status = status; 
    }

    //Getters 
    public String getStatus(){
        return status; 
    }

    //Constructors
    public Staff(String fullName, String id, String department, String status){
        super(fullName, id, department);
        this.status = status; 
    }

    //print info for staff (department + status)
    public void print(){

    }
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

