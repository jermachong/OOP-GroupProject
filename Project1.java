/*
 * Project 1
 * Jeremy Achong, Jaime Chea, and Grace Maroon
 */

import java.util.Scanner;

import javax.swing.plaf.synth.SynthScrollBarUI;

 public class Project1 {
    public static void main(String[] args){
        Scanner myScan = new Scanner(System.in);

        Personnel personArr = new Personnel();  //Array of people

        int selection;
        do{
        System.out.println("Choose one of the options:");
        System.out.println("1 - Enter the information a faculty");
        System.out.println("2 - Enter the information of a student");
        System.out.println("3 - Print tuition invoice for a student");
        System.out.println("4 - Print faculty information");
        System.out.println("5 - Enter the information of a staff member");
        System.out.println("6 - Print the information of a staff member");
        System.out.println("7 - Exit Program");
        System.out.println("\n    Enter your selection: ");
        selection = myScan.nextInt();

        //Create Faculty
        if(selection == 1){

            String newName, newID, newDepartment, newRank;
            System.out.println("Enter the faculty info:");
            
            //Get Name
            do{
                System.out.println("    Name of the faculty member: ");
                newName = myScan.next();
                if(newName.equals(null) || newName.length() == 1) //need a proper name
                {
                    System.out.println("Please enter a name");
                    continue; 
                }
                else break;
            }while(true);
            
            // Get ID
            do{
                System.out.println("    ID: ");
                newID = myScan.next();
                newID = newID.toLowerCase(); // make string all lowercase
                if(newID.length() > 6 || newID.equals(null))
                {
                    System.out.println(newID + " is invalid");
                    continue;
                }
                else break; 

            }while(true); 

            // Get Department
            do{
                System.out.println("    Department: ");
                newDepartment = myScan.next();
                newDepartment = newDepartment.toLowerCase(); 
                //look for math, eng, and science
                if(newDepartment.equalsIgnoreCase("mathematics") || newDepartment.equalsIgnoreCase("sciences") || newDepartment.equalsIgnoreCase("engineering") ){
                    System.out.println("CORRECT INPUT");//input was valid, testing
                    break;
                }
                else{
                    System.out.println(newDepartment + " is invalid"); 
                    continue; 
                }

            }while(true);
            
            // Get Rank
            do{
                System.out.println("    Rank: ");
                newRank = myScan.next(); //if the input is not equal to the two cases, then it repeats the loop. 
                if(newRank.equalsIgnoreCase("professor") || newRank.equalsIgnoreCase("adjunct"))
                    //input was valid, break out of the do while loop and move onto retrieving department.
                    break;
                else{
                    System.out.println(newRank + " is invalid"); 
                    continue;
                }
            }
            while(true);
            

            //Create Faculty with given info
            Faculty f = new Faculty(newName, newID, newDepartment, newRank); 
            personArr.addTo(personArr, f); //takes the person array and faculty object as parameters


        }
        // Add Student person thing
        else if(selection == 2){ // Get Student info
            System.out.println("Enter the student info:");
            // Get Name
            System.out.println("    Name of the student: ");
            String newName = myScan.next();
            
            // Get ID
            System.out.println("    ID: ");
            String newID = myScan.next();
            
            // Get GPA
            System.out.println("    GPA: ");
            double newGPA = myScan.nextDouble();
            
            // Get Credit Hours
            System.out.println("    Credit Hours: ");
            int newHours = myScan.nextInt();

            // Create Student 's', add info. to 's', add to List[], 
            Student s = new Student(newName, newID, newGPA, newHours);
            // add s to List[]
            personArr.addTo(personArr, s);
            System.out.println("Student added!");
        }

        // Print tuition invoice for a student
        else if(selection == 3){
            System.out.println("    Enter the Student's ID: ");
            String inputID = myScan.next();
            System.out.println("    Here is the Student's tuition invoice");
            Student.findPerson(personArr, inputID).print();

        }
        else if(selection == 4){
            // Enter Info
            System.out.println("    Enter the Faculty ID: ");
            String inputID = myScan.next();
            inputID = inputID.toLowerCase();

            // Print Info
            System.out.println("    Here is the Faculty information");
            Person.findPerson(personArr, inputID).print();
        }

        // Get Staff info, add Person to personArr
        else if(selection == 5){
            String newName, newID, newDepartment, newStatus;
            System.out.println("Enter the staff info:");

            //Get Name
            do{
                System.out.println("    Name of the faculty member: ");
                newName = myScan.next();
                if(newName.equals(null) || newName.length() == 1) //need a proper name
                {
                    System.out.println("Please enter a name");
                    continue; 
                }
                else break;
            }while(true);
            
            // Get ID
            do{
                System.out.println("    ID: ");
                newID = myScan.next();
                newID = newID.toLowerCase(); // make string all lowercase
                if(newID.length() > 6 || newID.equals(null))
                {
                    System.out.println(newID + " is invalid");
                    continue;
                }
                else break; 

            }while(true);
            
            // Get Department
            do{
                System.out.println("    Department: ");
                newDepartment = myScan.next();
                newDepartment = newDepartment.toLowerCase(); 
                //look for math, eng, and science
                if(newDepartment.equalsIgnoreCase("mathematics") || newDepartment.equalsIgnoreCase("sciences") || newDepartment.equalsIgnoreCase("engineering") ){
                    System.out.println("CORRECT INPUT");//input was valid, testing
                    break;
                }
                else{
                    System.out.println(newDepartment + " is invalid"); 
                    continue; 
                }

            }while(true);

            // Get Status
            do{
                System.out.println("Status, Enter P for Part Time, or Enter F for Full Time: ");
                newStatus = myScan.next();
                newStatus = newStatus.toLowerCase();
                if(newStatus.equals("f") || newStatus.equals("p")){
                    break;
                }
                else{
                    System.out.println(newStatus + "is invalid, enter a valid Status");
                    continue;
                }
            }while(true);

            // assign info to new object, add to personArr
            Staff s = new Staff(newName, newID, newDepartment, newStatus);
            personArr.addTo(personArr, s);
        }

        // Print Staff Information
        else if(selection == 6){
            System.out.println("    Enter the Staff ID: ");
            String inputID = myScan.next();
            inputID = inputID.toLowerCase();

            // Print Info
            System.out.println("    Here is the Staff information");
            Person.findPerson(personArr, inputID).print();
        }

        else if(selection == 7){
            break;
        }
    }while(selection != 7);

        myScan.close(); //close scanner pointer
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

    // Parse through the Person Array and find a target Person using an input ID
    public static Person findPerson(Personnel array, String inputID){
        //Person targetPerson
        //Person targetPerson = new Person(); 
        int i; 
        for(i = 0; i < array.getList().length; i++){
            // System.out.println("i = " + i); // testing
            if(array.getList()[i].getID().equals(inputID)){
                //targetPerson = array.getList()[i];
                break;
            }
        }
        return array.getList()[i];
    }

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

    //prints the student's tution invoice
    public void print(){
        //declare local variables to store the payment total and discount
        double discount = 0.0;
        double total = 52 + (this.getCreditHours() * 236.45);
     
        super.printPersonInfo(); //Prints seperating line + Student's info.


      
      if(this.getGPA()>=3.85)//calculate discount if applicable 
      {
        discount=total*0.25;
      }
      //print for remaining invoice information
      System.out.println("---------------------------\nCredit Hours: "+ this.getCreditHours()+ 
      " ($236.45/credit hour)\nFees: $52\n\nTotal payment: "+ (total-discount)+"\t\t ($"+discount+" discount applied)\n---------------------------");


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
       System.out.println("---------------------------");//display statement
      super.printPersonInfo();
       System.out.println(this.getDepartment()+", "+ this.getRank()+"\n---------------------------");//display statement

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
      System.out.println("---------------------------");//display statement
      super.printPersonInfo();
      System.out.println(this.getDepartment()+", "+ this.getStatus()+"\n---------------------------");//display statement
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

    //find next empty spot in array and add person object to array.
    public void addTo(Personnel list, Person p){
        for(int i = 0; i < list.getList().length; i++)
        {
            if(list.getList()[i] == null)
            {
                list.getList()[i] = p;
                break; 
            }
        }
    }
    
}


