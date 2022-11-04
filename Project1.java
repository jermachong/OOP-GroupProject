/*
 * Project 1
 * Jeremy Achong, Jaime Chea, and Grace Maroon
 */

import java.util.Scanner;

 public class Project1 {
    public static void main(String[] args){
        Scanner myScan = new Scanner(System.in);

        Personnel personArr = new Personnel();  //Array of people

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

        //Create Faculty
        if(selection == 1){
            String newName, newId, newRank, newDepartment; 
            System.out.println("Enter the faculty info:");
            // Get Name
            System.out.println("    Name of the faculty member: ");
            newName = myScan.nextLine();
            // make newName lowercase, create method to Capitalize first letter of first and last name to use when printing
            
            // Get ID
            
            System.out.println("    ID: ");
            String newID = myScan.nextLine();
            newID = newID.toLowerCase(); // make string all lowercase
            

            // Get Department
            do{
                System.out.println("    Department: ");
                newDepartment = myScan.nextLine(); 
                if(!newDepartment.toLowerCase().equals("mathematics") || !newDepartment.toLowerCase().equals("engineering") || !newDepartment.toLowerCase().equals("sciences"))
                {
                    System.out.println(newDepartment + " is invalid"); 
                    continue; 
                }
                else break; 

            }while(true);
            
            // Get Rank
            do{
                System.out.println("    Rank: ");
                newRank = myScan.nextLine(); //if the input is not equal to the two cases, then it repeats the loop. 
                if(!newRank.toLowerCase().equals("profressor") || !newRank.toLowerCase().equals("adjunt"))
                {
                    System.out.println(newRank + " is invalid"); 
                    continue; 
                }
                else break;  //input was valid, break out of the do while loop and move onto retrieving department.
            }
            while(true);
            

            //Create Faculty with given info
            Faculty f = new Faculty(newName, newID, newDepartment, newRank); 
            personArr.addTo(personArr, f); //takes the person array and faculty object as parameters

        }
        //Create Student
        else if(selection == 2){
            System.out.println("Enter the student info:");
            // Get Name
            System.out.println("    Name of the student: ");
            String newName = myScan.nextLine();
            
            // Get ID
            System.out.println("    ID: ");
            String newID = myScan.nextLine();
            
            // Get GPA
            System.out.println("    GPA: ");
            double newGPA = myScan.nextDouble();
            
            // Get Credit Hours
            System.out.println("    Credit Hours: ");
            int newHours = myScan.nextInt();

            // Create Student 's', add info. to 's', add to List[], 
            Student s = new Student(newName, newID, newGPA, newHours);
            // add s to List[]
            System.out.println("Student added!");
        }
        else if(selection == 3){
            System.out.println("    Enter the Student's ID: ");
            String inputID = myScan.nextLine();
            System.out.println("    Here is the Student's tuition invoice");
            //tuitionInvoice(inputID); //waiting on this to be built
        }
        else if(selection == 4){
            System.out.println("    Enter the Faculty ID: ");
            String inputID = myScan.nextLine();
            inputID = inputID.toLowerCase();
            System.out.println("    Here is the Faculty information");
            // printInformation(inputID)
        }
        else if(selection == 5){
            System.out.println("Enter the staff info:");
            // Get Name
            System.out.println("    Name of the staff member: ");
            String newName = myScan.nextLine();
            // make newName lowercase, create method to Capitalize first letter of first and last name to use when printing
            
            // Get ID
            System.out.println("    ID: ");
            String newID = myScan.nextLine();
            newID = newID.toLowerCase(); // make string all lowercase
            
            // Get department
            do{
                System.out.println("    Department: ");
                String newDepartment = myScan.nextLine(); 
                if(!newDepartment.toLowerCase().equals("mathematics") || !newDepartment.toLowerCase().equals("engineering") || !newDepartment.toLowerCase().equals("sciences"))
                {
                    System.out.println(newDepartment + " is invalid"); 
                    continue; 
                }
                else break; 
    
            }while(true);

            // Get Status
            System.out.println("Status, Enter P for Part Time, or Enter F for Full Time: ");
            String inputStatus = myScan.nextLine();
            inputStatus = inputStatus.toLowerCase();

            // assign info to new object, add to List[]
            // Staff s = new Staff(newName, newID, newDepartment, inputStatus);
        }
        else if(selection == 6){
            System.out.println("    Enter the Staff ID: ");
            String inputID = myScan.nextLine();
            inputID = inputID.toLowerCase();
            System.out.println("    Here is the Staff information");
            // printInformation(inputID)
        }
        else if(selection == 7){

        }

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


