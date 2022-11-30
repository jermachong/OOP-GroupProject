
/*
 * Project 2
 * Jeremy Achong, Jaime Chea, and Grace Maroon
 */

import java.lang.Math;
import java.util.*; 
import java.io.*; 

 public class Project2 {
    public static void main(String[] args){
        Scanner myScan = new Scanner(System.in);

        Personnel personArr = new Personnel();  //Array of people

        ArrayList<Student> sList = new ArrayList<>(); //ArrayList of students used for selection 7


        System.out.println("\t\t\t\t\t\tWelcome to my Personnel Management Program");

        char selection;
        do{
            //display statements
            System.out.println("\n\nChoose one of the options:");

            System.out.println("1 - Enter the information a faculty");
            System.out.println("2 - Enter the information of a student");
            System.out.println("3 - Print tuition invoice for a student");
            System.out.println("4 - Print faculty information");
            System.out.println("5 - Enter the information of a staff member");
            System.out.println("6 - Print the information of a staff member");
            System.out.println("7 - Exit Program");
            System.out.print("\n    Enter your selection: ");
            selection = myScan.next().charAt(0);//scan in a single character
            System.out.print("\n");

            //Create Faculty
            if(selection == '1'){//entering faculty info

                String newName, newID, newDepartment, newRank;//declare all local variables
                
                System.out.println("Enter the faculty info:");//display message
                
                //Get Name
                do{
                    System.out.print("\tName of the faculty member: ");
                    
                    newName = myScan.nextLine();//scan in line input
                    if (newName.equals(""))//check to make sure nextLine did not take an empty space
                    {
                    newName= myScan.nextLine();
                    }
                    
                    if(newName.equals(null) || newName.length() == 1) //check to make sure name is not blank or too short
                    {
                        System.out.println("\tPlease enter a name");
                        continue; 
                    }
                    
                    else 
                        break;//if input it valid, break the do while
                }while(true);
                
                // Get ID
                do{
                    System.out.print("\tID: ");//display statement
                    
                    newID = myScan.nextLine();//scan in line to newID
                    if (newID.equals(""))//check to make sure nextLine did not take an empty space
                    {
                        newID= myScan.nextLine();
                    }
                    
                    newID = newID.toLowerCase(); // make string all lowercase
                    
                    if(newID.equals(null))//check to make sure newID is not blank
                    {
                        System.out.println("\tID is invalid");
                        continue;
                    }
                    
                    else if(Student.findPerson(personArr, newID)!=null)//check to make sure ID is not a duplicate of one already in the system
                    {
                        System.out.println(newID+ " is already in the system.");
                        continue;
                    }
                    else 
                        break; //if id is valid, exit the do while

                }while(true); 
                
            // Get Rank
                do{
                    System.out.print("\tRank: ");
                    newRank = myScan.nextLine(); //scan in line to newRank
                    
                    if (newRank.equals(""))//check to make sure nextLine did not take an empty space
                    {
                        newRank= myScan.nextLine();
                    }

                //checks to see if newRank is a valid input
                    if(newRank.equalsIgnoreCase("professor") || newRank.equalsIgnoreCase("adjunct")) {
                        //input was valid, format rank, break out of the do while loop and move onto retrieving department.
                        newRank= newRank.substring(0, 1).toUpperCase() + newRank.substring(1).toLowerCase();
                        break;
                    }
                    else{
                        //newRank was not valid, continue the loop
                        System.out.println("\t"+ newRank + " is invalid"); 
                        continue;
                    }
                }
                while(true);

                // Get Department
                do{
                    System.out.print("\tDepartment: ");
                    newDepartment = myScan.nextLine();//scan in line to newDepartment
                    
                    if (newDepartment.equals(""))//check to make sure nextLine did not take an empty space
                    {
                        newDepartment= myScan.nextLine();
                    }
                    
                    //check if the newDepartment is a valid option
                    if(newDepartment.equalsIgnoreCase("mathematics") || newDepartment.equalsIgnoreCase("sciences") || newDepartment.equalsIgnoreCase("engineering") ){
                        //input was valid. format newDepartment and break the do while
                        newDepartment= newDepartment.substring(0, 1).toUpperCase() + newDepartment.substring(1).toLowerCase();
                        break;
                    }
                    else{
                        //input was invalid, continue the loop
                        System.out.println("\t"+newDepartment + " is invalid"); 

                    }

                }while(true);

                //Create Faculty with given info
                Faculty f = new Faculty(newName, newID, newDepartment, newRank); 
                personArr.addTo(personArr, f); //add new faculty to personArr
                System.out.println("Faculty Added!");//display statement

            }
            //Create Student
            else if(selection == '2'){ // Get Student info

                System.out.println("Enter the student info:");
            //declare all local variables
                String newName, newID;
                double newGPA;
                int newHours;
                // Get Name

                do{
                    System.out.print("\tName of the Student: ");
                    
                    newName = myScan.nextLine();//scan in line input
                    if (newName.equals(""))//check to make sure nextLine did not take an empty space
                    {
                    newName= myScan.nextLine();
                    }
                    
                    if(newName.equals(null) || newName.length() == 1) //check to make sure name is not blank or too short
                    {
                        System.out.println("\tPlease enter a name");
                        continue; 
                    }
                    
                    else 
                        break;//if input it valid, break the do while
                }while(true);

                // Get ID
                do{
                    System.out.print("\tID: ");
                    newID = myScan.nextLine();//scan in line as newID
                    
                    if (newID.equals(""))//check to make sure nextLine did not take an empty space
                    {
                        newID= myScan.nextLine();
                    }
                    newID = newID.toLowerCase(); // make string all lowercase
                    
                    if(newID.equals(null))//check to make sure that id is not blank
                    {
                        System.out.println("\tID is invalid");
                        continue;
                    }
                    else if(Student.findPerson(personArr, newID)!=null)//check to make sure ID is not a duplicate to an ID already in personArr
                    {
                        System.out.println("\t"+newID+ " is already in the system.");
                        continue;
                    }
                    else 
                        break; //if input is valid, break the do while

                }while(true);
                
                
                
                // Get GPA
                do {
                System.out.print("\tGPA: ");
                newGPA = myScan.nextDouble();//scan in double to newGPA
                
                if(newGPA>4.0||newGPA<0.0) {//make sure newGPA isnt less than 0 or more than 4.0
                    System.out.println("\tGPA input invalid. Please try again.");
                    continue;
                }
                else
                    break;//if input is valid, break the do while
                
                }while(true);

                
                // Get Credit Hours
                do {
                System.out.print("\tCredit Hours: ");
                newHours = myScan.nextInt();//scan in int to newHours
                
                if(newHours<0) {//check to make sure newHours is not less than 0
                    System.out.println("\tCredit Hours input invalid. Please try again.");
                    continue;
                }
                else//if input is valid, break the do while
                    break;
                }while(true);

                // Create Student 's', add info. 

                Student s = new Student(newName, newID, newGPA, newHours); //create student obj with given information
            
                personArr.addTo(personArr, s); //add to personnel 
                sList.add(s); //add to student arraylist 'sList'

                System.out.println("Student added!");
            }

            // Print tuition invoice for a student
            else if(selection == '3'){
                System.out.print("\tEnter the Student's ID: ");
                String inputID = myScan.nextLine();//take in line to inputID
                
                if (inputID.equals(""))//check to make sure nextLine did not take an empty space
                {
                    inputID= myScan.nextLine();
                }
                
                inputID = inputID.toLowerCase();//make inputID lowercase
                
                if(Student.findPerson(personArr, inputID)!=null)//if the id entered is found in the personArr list
                {
                    if(Student.findPerson(personArr, inputID) instanceof Student) {//makes sure person found is a student
                        System.out.println("\tHere is the tuition invoice for "+ Student.findPerson(personArr, inputID).getFullName());
                        System.out.println(Student.findPerson(personArr, inputID).print()); 
                    }
                    else
                        System.out.println(inputID+ " is not a student! Please select a different option.");//if input is not a student, do not print
                }
                else
                {
                    System.out.println("Student not found!");//display if person is not found
                }

            }
            //print faculty info
            else if(selection == '4'){
                // Enter Info
                System.out.print("\tEnter the Faculty ID: ");
                String inputID = myScan.nextLine();//take in line to inputID
                
                if (inputID.equals(""))//check to make sure nextLine did not take an empty space
                {
                    inputID= myScan.nextLine();
                }
                
                inputID = inputID.toLowerCase();//make inputID lowercase


                if(Person.findPerson(personArr, inputID) != null)//check if the id entered is found in the personArr list
                {
                    if(Person.findPerson(personArr, inputID) instanceof Faculty)//check if person found is Faculty
                    {
                    System.out.print("\n");
                    System.out.println(Person.findPerson(personArr, inputID).print());//if person is in list and faculty, print infor
                    }
                    else
                        System.out.println(inputID+ " is not a member of Faculty! Please select a different option.");//display statement if not faculty
                }
                else {
                    System.out.println("No Faculty member matched!");//display statement if id not found in personArr
                }

            }

            // Add staff member to personArr
            else if(selection == '5'){
                String newName, newID, newDepartment, newStatus;//declare local variables

                System.out.println("Enter the staff info:");

                //Get Name
                do{
                    System.out.print("\tName of the faculty member: ");
                    newName = myScan.nextLine();//scan in line as newName
                    
                    if (newName.equals(""))//check to make sure nextLine did not take an empty space
                    {
                        newName= myScan.nextLine();
                    }
                    
                    if(newName.equals(null) || newName.length() == 1) //makes sure name isnt null and is a proper length
                    {
                        System.out.println("\tPlease enter a name");//display if name is not valid
                        continue; 
                    }
                    else 
                        break;//if name is valid, exit do while

                }while(true);
                
                // Get ID
                do{
                    System.out.print("\tID: ");
                    newID = myScan.nextLine();
                    if (newID.equals(""))//check to make sure nextLine did not take an empty space
                    {
                        newID= myScan.nextLine();
                    }
                    newID = newID.toLowerCase(); // make string all lowercase
                    
                    if(newID.equals(null)||newID.equals(""))//check to make sure newID is not null or blank
                    {
                        System.out.println("\tID is invalid");//display if id is null
                        continue;
                    }
                    
                    else if(Student.findPerson(personArr, newID)!=null)//check to make sure ID is not already in the personArr
                    {
                        System.out.println("\n"+newID+ " is already in the system.");//display if id is a duplicate
                        continue;
                    }
                    else
                        break; //if newID is valid, exit the do while


                }while(true);
                
                // Get Department
                do{
                    System.out.print("\tDepartment: ");
                    newDepartment = myScan.nextLine();//scan in new line to newDepartment
                    
                    if (newDepartment.equals(""))//check to make sure nextLine did not take an empty space
                    {
                        newDepartment= myScan.nextLine();
                    }
                    
                    //look for math, engineering, and science
                    if(newDepartment.equalsIgnoreCase("mathematics") || newDepartment.equalsIgnoreCase("sciences") || newDepartment.equalsIgnoreCase("engineering") ){
                        //if newDepartment is a valid subject, format newDepartment and exit the do while
                        newDepartment= newDepartment.substring(0, 1).toUpperCase() + newDepartment.substring(1).toLowerCase();
                        break;
                    }
                    else{
                        System.out.println("\t"+newDepartment + " is invalid"); //display if newDepartnent is not valid

                        continue; 
                    }

                }while(true);

                // Get Status
                do{
                    System.out.print("\tStatus, Enter P for Part Time, or Enter F for Full Time: ");
                    newStatus = myScan.nextLine();//scan in line to newStatus
                    
                    if (newStatus.equals(""))//check to make sure nextLine did not take an empty space
                    {
                        newStatus= myScan.nextLine();
                    }
                    
                    if(newStatus.equalsIgnoreCase("f") || newStatus.equalsIgnoreCase("p")){//check if newStatus is one of the 2 valid options
                        if (newStatus.equalsIgnoreCase("f"))//assign Full Time if newStatus is "f"
                            newStatus= "Full Time";
                        else if (newStatus.equalsIgnoreCase("p"))//assign Part Time if newStatus is "p"
                            newStatus="Part Time";
                        break;//exit for loop
                    }
                    else{
                        System.out.println(newStatus + "is invalid, enter a valid Status");//display statement if newStatus is not 'p' or 'f'
                        continue;
                    }
                }while(true);
                
                Staff s = new Staff(newName, newID, newDepartment, newStatus);// assign info to new object
                personArr.addTo(personArr, s);// add to personArr
                System.out.println("Staff member added!");
            }

            // Print Staff Information
            else if(selection == '6'){
                System.out.print("\tEnter the Staff ID: ");
                String inputID = myScan.nextLine();
                do {
                if (inputID.equals(""))//check to make sure nextLine did not take an empty space
                {
                    inputID= myScan.nextLine();
                }
                inputID = inputID.toLowerCase(); // make string all lowercase
                
                if(inputID.equals(null)||inputID.equals(""))//check to make sure inputID is not null or blank
                {
                    System.out.println("\tID is invalid");//display if id is null
                    continue;
                }
                else
                    break; //if inputID is valid, exit the do while

            }while(true);
            

            if(Person.findPerson(personArr, inputID)!=null)//check if the ID belongs to a person in personArr
                {
                    if(Person.findPerson(personArr, inputID) instanceof Staff)//checks if the person found is a member of Staff
                    {
                        // Print Info if person is found and is a member of Staff
                        System.out.print("\n");
                        System.out.println(Person.findPerson(personArr, inputID).print());
                    }
                    else
                        System.out.println(inputID+" is not a member of Staff! Please select a different option.");//display if found Person is not Staff

                }
                else
                    System.out.println("No Staff member matched!");//display if no matching id is found
            }

            else if(selection == '7'){
                System.out.println("Would you like to create a report?");
                myScan.nextLine();
                String report = myScan.nextLine();
                if(report.equalsIgnoreCase("Yes"))
                {
                    PrintWriter writer = null; //create printwriter pointer

                    Collections.sort(sList, new SortByCreditHour()); //sort students by credit hours

                    //make sure report.txt is built
                    try{
                        writer = new PrintWriter("report.txt"); 
                    }catch (FileNotFoundException e){
                        e.printStackTrace();
                    }

                    // write faculty and staff to .txt
                    writer.println("Faculty Members");
                    for(Person p:personArr.getList()){
                        if(p instanceof Faculty == true){
                            String toPrint = p.print();
                            writer.print(toPrint + "\n\n");
                        }
                    }
                    
                    writer.println("Staff Members");
                    for(Person p:personArr.getList()){
                        if(p instanceof Staff == true){
                            String toPrint = p.print();
                            writer.print(toPrint + "\n\n");
                        }
                    }

                    writer.println("Students sorted by Credit Hour"); //header
                    
                    for(Student s: sList){
                        //loop prints out all students
                        String toPrint = s.print();
                        writer.print(toPrint); 
                    } 

                    writer.close(); //close writer pointer


                }
                else if(report.equalsIgnoreCase("no")){
                    break;//exit do while
                }
            }
            else
                System.out.println("Invalid entry- please try again ");//display statement if input is invalid
        }while(selection != 7);

        myScan.close(); //close scanner pointer
        System.out.println("\n\n\n\nGoodbye!");//display at end of main run
    }
    
}
 
abstract class Person{
	//declare private variables
    private String fullName; 
    private String id;

    //Setters
    public void setFullName(String fullName){
        this.fullName = fullName; //set Person's fullName to new fullName
    }
    public void setID(String id){
        this.id = id; //set Person's id to new id
    }

    //Getters
    public String getFullName(){
        return fullName; //return Person's fullName
    }
    public String getID(){
        return id; //return Person's id
    }

    //Constructor
    public Person(){//default constructor for person
    	//set variables to default values
        fullName = "None"; 
        id = "00"; 
    }
    public Person(String fullName, String id){//default constructor for person
    	//set variables to given values
        this.fullName = fullName;  
        this.id = id; 
    }

    //toString
    
    @Override
    public String toString(){
        return "[" + "Full Name: " + fullName + "\n" + "ID: " + id; //return formatted string
    }

public void validateId() throws idException//ensures id is properly formatted
    {
      //checks to make sure id is proper length
       if(this.id.length()>6){  
   
        throw new idException("ID is too long");    
      }  
      if(this.id.length()<6)
      {
        throw new idException("ID is too short"); 
      }
      for(int i=0; i<6; i++)
        {
          if(i<2&&id.charAt(i)<97||id.charAt(i)>122)//checks to make sure first two characters are lowercase letters
            throw new idException("ID is not formatted correctly. ID format should be [letter letter digit digit digit digit]"); 
            
          else if(i>=2&&id.charAt(i)<48||id.charAt(i)>57)//checks to make sure remaining characters are digits
            throw new idException("ID is not formatted correctly. ID format should be [letter letter digit digit digit digit]"); 
        }
    }
    
    //Abstract function to be overridden in Student, Faculty, and Staff
    public abstract String print();

    // Parse through the Person Array and find a target Person using an input ID
    public static Person findPerson(Personnel array, String inputID){
        //Person targetPerson
        //Person targetPerson = new Person(); 
        int i=0; 
        while(array.getList()[i]!=null) {//loop through valid members of the list
            if(array.getList()[i].getID().equals(inputID)){
            	return array.getList()[i];//if the matched Id is found, return the matching Person
            }
            i++;//increment i
        }
        return null;//return null if matching person is not found
    }

    //Print out full name and ID, useful for all print()
    public String printPersonInfo(){
        String toString;
        toString = "---------------------------\n\t"+fullName + "\t\t" + id;
        return toString; 
    } 
}

class Student extends Person{ 
	//declare private variables
    private double gpa; 
    private int creditHours; 

    //Setters
    public void setGPA(double gpa){
        this.gpa = gpa; //set Student's gpa to new gpa
    }
    public void setCreditHours(int creditHours){
        this.creditHours = creditHours; //set Student's creditHours to new creditHours
    }

    //Getters
    public double getGPA(){
        return gpa; //return Student's gpa
    }
    public int getCreditHours(){
        return creditHours; //return Student's creditHours
    }

    //Constructors
    public Student()//default constructor
    {
    	//assigns blank values to all variables
    	super("", "");
        this.gpa = 0.0; 
        this.creditHours = 0; 
    }
    public Student(String fullName, String id, double gpa, int creditHours){
    	//assigns given values to all variables
        super(fullName, id);
        this.gpa = gpa; 
        this.creditHours = creditHours; 
    }

    //prints the student's tution invoice
    public String print(){
        // local variable to return string
        String toPrint;
        //declare local variables to store the payment total and discount
        double discount = 0.0;
        double total = 52 + (this.getCreditHours() * 236.45);
        
        total= total*100;//round to 2 decimal places
        total= Math.round(total);
        total= total/100;

     
        // super.printPersonInfo(); //Prints seperating line + Student's info.


      
      if(this.getGPA()>=3.85)//calculate discount if applicable 
      {
        discount=total*0.25;
        discount= discount*100;//round to 2 decimal places
        discount= Math.round(discount);
        discount= discount/100;
        
        total= total-discount;
        total= total*100;//round to 2 decimal places
        total= Math.round(total);
        total= total/100;
     
        
     
      }
      //print for remaining invoice information
      toPrint = super.printPersonInfo() +  "\n\tCredit Hours: "+ this.getCreditHours()+ 
      " ($236.45/credit hour)\n\tFees: $52\n\n\tTotal payment: "+ total+"\t\t ($"+discount+" discount applied)\n---------------------------";
      return toPrint;
    }
}

abstract class Employee extends Person{
    private String department; //mathematics, engineering or sciences

    //Setters
    public void setDepartment(String department){
        this.department = department; //set Employee's department to new department
    }

    //Getters
    public String getDepartment(){
        return department; //return Employee's department
    }

    //Constructors
    public Employee()//default constructor
    {
    	//assign blank values to all variables
    	super("","");
    	this.department= "";
    }
    public Employee(String fullName, String id, String department){
    	//assign given values to all variables
        super(fullName,id);
        this.department = department; 
    }

}

class Faculty extends Employee{
    private String rank; //professor or adjunct

    //Setters
    public void setRank(String rank){
        this.rank = rank; //set Employee's rank to new rank
    }

    //Getters
    public String getRank(){
        return rank; //return Employee's rank 
    }

    //Constructors
    public Faculty()
    {
    	//assign blank values to all variables
    	super("","", "");
    	this.rank="";
    }
    public Faculty(String fullName, String id, String department, String rank){
    	//assign given values to all variables
        super(fullName, id, department);
        this.rank = rank;
    }

    //print info for faculty (department + rank)
    public String print(){
        String toPrint;
        toPrint = super.printPersonInfo() + "\n\t"+ this.getDepartment()+" Department, "+ this.getRank()+"\n---------------------------";//display statement
        return toPrint;
    }

}

class Staff extends Employee{
    private String status; //part time or full time

    //Setters
    public void setStatus(String status){
        this.status = status; //set Staff status to new Status
    }

    //Getters 
    public String getStatus(){
        return status; //return Staff status 
    }

    //Constructors
    public Staff()//default constructor
    {
    	//assign blank values to all variables
        super("", "", "");
        this.status = ""; 
    }
    public Staff(String fullName, String id, String department, String status){
    	//assign given values to all variables
        super(fullName, id, department);
        this.status = status; 
    }

    //print info for staff (department + status)
    public String print(){
        String toPrint;
        toPrint = super.printPersonInfo() + "\n\t"+this.getDepartment()+" Department, "+ this.getStatus()+"\n---------------------------";//display statement
        return toPrint;
    }
}

//Creates array of Person
class Personnel{
    private Person[] list; //declare private variable
    
    //constructors
    public Personnel() {
    	//define Personnel's list
        list = new Person[100]; 
    }
    public Personnel(int listSize)
    {
    	//define Personnel's list with custom size
        list = new Person[listSize]; 
    }

    //retrieve array of Persons
    public Person[] getList(){
        return list; 
    }

    //find next empty spot in array and add person object to array.
    public void addTo(Personnel list, Person p){
    	int i;
        for(i = 0; i < list.getList().length; i++)
        {
            if(list.getList()[i] == null)//find first available space in list

            {
                list.getList()[i] = p;
                break; 
            }
        }

        if(i>list.getList().length)
        	System.out.println("List is full!");//display if no spot is found for person p

    }
    
}

//Sorts array list of students by credit hour
class SortByCreditHour implements Comparator<Student>
{
    public int compare(Student a, Student b)
    {
        if(a.getCreditHours() == b.getCreditHours())
            return 0;
        else if(a.getCreditHours() > b.getCreditHours())
            return 1; 
        else
            return -1; 
    }
}
class idException extends Exception { 
    public idException(String errorMessage) {
        super(errorMessage);
    }
}

