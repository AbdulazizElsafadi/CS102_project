
import java.io.*;
import java.util.*;

public class App {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
       ArrayList<Students> std_arr = new ArrayList<>();
       Scanner input = new Scanner(System.in);
       Scanner scan = new Scanner(new File("Students_Records 2.txt"));
       
           System.out.println("Welcome to CS102 Lab Project \n");
          
           while(true){
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("To read students data from a file, please enter: 1");
        System.out.println("To search for a students record, please enter:   2");
        System.out.println("To sort the students data, please enter:         3");
        System.out.println("To update a students record, please enter:       4");
        System.out.println("To delete a students record, please enter:       5");
        System.out.println("To save the students date, please enter:         6");
        System.out.println("To exit the program, please enter:               7");
        System.out.println("--------------------------------------------------------------------------");
        
        System.out.print("Please enter your choice: ");
       int choice = input.nextInt();
      if(choice > 0 && choice < 8){
          
    //---------------------------------------------- 1st choice-------------------------------------------//
    
       if(choice == 1){
         
         while(scan.hasNext()){
        
  std_arr.add(new Students(scan.nextInt(), new Name(scan.next(),scan.next(),scan.next(),scan.next(),scan.next(),scan.next()),scan.next(),
          scan.nextDouble() , scan.nextInt()));
       }
           System.out.println("Do you want to see the File(Yes , No)");
           String print = input.next();
           if(print.equalsIgnoreCase("yes")){
               
      System.out.println("\n-----------------------------------  The File -------------------------------------- \n");
      
      System.out.println("  ID              Name                      Major                 GPA      Credit Hours");
      for(Students std: std_arr)
      System.out.println(std);
           
           } else System.out.println("That's Fine");
           
        } 
    
    //---------------------------------------------- 2nd choice-------------------------------------------//
       boolean found = false; // to make else out of the For each loop.
       if(choice == 2){
           
System.out.println("How do you want to find the Student by:\n 1 for ID\n 2 for Name\n 3 for Major\n 4 for GPA\n 5 for Credit Hours\n Make your choice: ");
int choice1 = input.nextInt();
           
    if(choice1 == 1){
        System.out.println("--------------------- Record based on ID ------------------------");
       System.out.print("Enter the student ID: ");
        int id = input.nextInt();
           
    for(Students std: std_arr){
        if(id == std.getId()){
            found = true;
                 System.out.println("  ID              Name                      Major                 GPA      Credit Hours");
                 System.out.println(std);
               }
      } if(found == false) System.out.println("The ID is wrong");
           
      
}else if(choice1 == 2){
    System.out.println("----------------------- Record based on Name --------------------------");
    System.out.print("Enter the student Full Name: ");
      Name name = new Name(input.next() , input.next() , input.next(),scan.next(),scan.next(),scan.next());
           
    for(Students std: std_arr){
        if(name.equals(std.getName())){
            found = true;
                 System.out.println("  ID              Name                      Major                 GPA      Credit Hours");
                 System.out.println(std);
               }
      } if(found == false) System.out.println("The Name is wrong (Make sure to write correct spelling)");
    
}else if(choice1 == 3){
    System.out.println("----------------------- Record based on Major --------------------------");
    System.out.print("Enter the student Major: ");
      String major = input.next();
           
    for(Students std: std_arr){
        if(major.equals(std.getMajor())){
            found = true;
                 System.out.println("  ID              Name                      Major                 GPA      Credit Hours");
                 System.out.println(std);
               }
      } if(found == false) System.out.println("The Major is wrong");

 }else if(choice1 == 4){
    System.out.println("----------------------- Record based on GPA --------------------------");
    System.out.print("Enter the student GPA: ");
      double gpa = input.nextDouble();
           
    for(Students std: std_arr){
        if(gpa == std.getGpa()){
            found = true;
                 System.out.println("  ID              Name                      Major                 GPA      Credit Hours");
                 System.out.println(std);
               }
      } if(found == false) System.out.println("No Student with this GPA");
}else if(choice1 == 5){
    System.out.println("----------------------- Record based on Credit Hours --------------------------");
    System.out.print("Enter the student Credit Hours: ");
      int CreditHours = input.nextInt();
           
    for(Students std: std_arr){
        if(CreditHours == std.getCreditHours()){
            found = true;
                 System.out.println("  ID              Name                      Major                 GPA      Credit Hours");
                 System.out.println(std);
               }
      } if(found == false) System.out.println("No Credti Hours like this");
          } else System.out.println("Choose between 1 to 5 ONLY");
    }
       //---------------------------------------------- 3rd choice-------------------------------------------//
       if(choice == 3){
           
           System.out.print("How do you want to sort? (ID , Name , Major , GPA , Credit Hours(CH): ");
           String choiceToSort = input.next();
           
           if(choiceToSort.equalsIgnoreCase("ID")){
               Collections.sort(std_arr ,new ComparatorOfID());
               System.out.println("\n------------------------------- Stored Based On ID -------------------------------------\n\n");
               System.out.println("  ID              Name                      Major                 GPA      Credit Hours");
               for(Students std: std_arr)
               System.out.println(std);
           }
      else if(choiceToSort.equalsIgnoreCase("name")){
               Collections.sort(std_arr ,new ComparatorOfName());
               System.out.println("\n------------------------------- Stored Based On Name -------------------------------------\n\n");
               System.out.println("  ID              Name                      Major                 GPA      Credit Hours");
               for(Students std: std_arr)
               System.out.println(std);
           }
           
      else if(choiceToSort.equalsIgnoreCase("Major")){
               Collections.sort(std_arr ,new ComparatorOfMajor());
               System.out.println("\n------------------------------- Stored Based On Major -------------------------------------\n\n");
               System.out.println("  ID              Name                      Major                 GPA      Credit Hours");
               for(Students std: std_arr)
               System.out.println(std);
           }
      
      else if(choiceToSort.equalsIgnoreCase("GPA")){
               System.out.print("Do you want the GPA by\n 1 for Increasingn Order\n 2 for Decreasing Order\n Make your choice:");
               int gpa_order = input.nextInt();
               
               if(gpa_order == 1){
               Collections.sort(std_arr ,new ComparatorOfGpaInc());
               System.out.println("\n----------------------------- Stored Based On GPA Increasing Order -------------------------------\n\n");
               System.out.println("  ID              Name                      Major                 GPA      Credit Hours");
               for(Students std: std_arr)
               System.out.println(std);
           }else if(gpa_order == 2) {
               Collections.sort(std_arr ,new ComparatorOfGpaDec());
               System.out.println("\n----------------------------- Stored Based On GPA Decreasing Order -------------------------------\n\n");
               System.out.println("  ID              Name                      Major                 GPA      Credit Hours");
               for(Students std: std_arr)
               System.out.println(std);
           }
      }
      else if(choiceToSort.equalsIgnoreCase("CH")){
               Collections.sort(std_arr ,new ComparatorOfCreditHours());
               System.out.println("\n------------------------------- Stored Based On Credit Hours -------------------------------------\n\n");
               System.out.println("  ID              Name                      Major                 GPA      Credit Hours");
               for(Students std: std_arr)
               System.out.println(std);
           }   else System.out.println("You should choose between one of the given options!"); 
       }
        //---------------------------------------------- 4th choice-------------------------------------------//
        found = false;
       if(choice == 4){
           
           System.out.print("Enter the ID of the Student you want to update: ");
           int id = input.nextInt();
          
           for(Students std: std_arr){
           if(id == std.getId()){
               found = true;
           System.out.print("Choose the field you want to upduate (ID , name , mojor , gpa , credit hours): ");
           String updateChoice = input.next();
           
           if(updateChoice.equalsIgnoreCase("ID")){
                       System.out.print("Enter the New ID: ");
                   std.setId(input.nextInt());
                   System.out.println("ID has been chnaged succefully");
                   System.out.print("Do you wnat to see the new Record(Yes , No)? ");
                   String ans = input.next();
                   
           if(ans.equalsIgnoreCase("Yes")){
               System.out.println("  ID              Name                      Major                 GPA      Credit Hours");
               System.out.println(std);
           } else System.out.println("That is fine");
           
           } else if(updateChoice.equalsIgnoreCase("Name")){
               
               System.out.print("Enter the New Name: ");
                   std.setName(new Name(input.next() , input.next() , input.next(),scan.next(),scan.next(),scan.next()));
                   System.out.println("Name has been chnaged succefully");
                   System.out.print("Do you wnat to see the new Record(Yes , No)? ");
                   String ans = input.next();
                   
           if(ans.equalsIgnoreCase("Yes")){
               System.out.println("  ID              Name                      Major                 GPA      Credit Hours");
               System.out.println(std);
           } else System.out.println("That is fine");
           
           } else if(updateChoice.equalsIgnoreCase("Major")){
               
               System.out.print("Enter the New Major: ");
                   std.setMajor(input.next());
                   System.out.println("Major has been chnaged succefully"); 
                   System.out.print("Do you wnat to see the new Record(Yes , No)? ");
                   String ans = input.next();
                   
           if(ans.equalsIgnoreCase("Yes")){
               System.out.println("  ID              Name                      Major                 GPA      Credit Hours");
               System.out.println(std);
           } else System.out.println("That is fine");
           
           } else if(updateChoice.equalsIgnoreCase("GPA")){
               
               System.out.print("Enter the New GPA: ");
                   std.setGpa(input.nextDouble());
                   System.out.println("GPA has been chnaged succefully"); 
                   System.out.print("Do you wnat to see the new Record(Yes , No)? ");
                   String ans = input.next();
                   
           if(ans.equalsIgnoreCase("Yes")){
               System.out.println("  ID              Name                      Major                 GPA      Credit Hours");
               System.out.println(std);
           } else System.out.println("That is fine");
           
           } else if(updateChoice.equalsIgnoreCase("CH")){
               
               System.out.print("Enter the New Credit Hours: ");
                   std.setCreditHours(input.nextInt());
                   System.out.println("Credit Hours has been chnaged succefully"); 
                   System.out.print("Do you wnat to see the new Record(Yes , No)? ");
                   String ans = input.next();
                   
           if(ans.equalsIgnoreCase("Yes")){
               System.out.println("  ID              Name                      Major                 GPA      Credit Hours");
               System.out.println(std);
           } else System.out.println("That is fine");
           
           
           } else System.out.println("You should choose between ID , name , major , gpa or Credit Hours");
           
           }  
           } if(found == false)System.out.println("The ID is wrong");
       }
       //---------------------------------------------- 5th choice-------------------------------------------//
       found = false;
       if(choice == 5){
           
           System.out.print("Enter the ID of the student you want to delete: ");
           int id = input.nextInt();
           
           for (int i = 0; i < std_arr.size(); i++) {
               if(id == std_arr.get(i).getId()){
                   found = true;
                   std_arr.remove(std_arr.get(i));
                   System.out.println("The Stduents has been removed");
                   //if condition to see the list.
           }  
           } if(found = false) System.out.println("The ID is Incorrect");
       }
       //---------------------------------------------- 6th choice-------------------------------------------//
       if(choice == 6){
           
           System.out.print("Enter the Name of the new file: ");
           FileWriter fw = new FileWriter(new File(input.next()));
           for(Students std: std_arr)
           fw.write(""+std);
           
           fw.close();
           
           System.out.println("The file has been writtne succefully");
           
       }
        //---------------------------------------------- 7th choice-------------------------------------------//
       
       if(choice == 7){
           System.out.println("See You");
           System.exit(0);
       } 
               
       } else System.out.println("You should Stick to the list");
       
           } 
       }
      

static class ComparatorOfID implements Comparator<Students>{
 @Override
    public int compare(Students other1, Students other2) {
        return other1.getId() - other2.getId() ;
    }
}

static class ComparatorOfName implements Comparator<Students>{
 @Override
    public int compare(Students other1, Students other2) {
        return other1.getName().getFirstName().compareTo(other2.getName().getFirstName());
    } 
}
 
static class ComparatorOfMajor implements Comparator<Students>{
  @Override
    public int compare(Students other1, Students other2){ 
        return other1.getMajor().compareTo(other2.getMajor());
    }
}

static class ComparatorOfGpaInc implements Comparator<Students>{
 @Override
    public int compare(Students other1, Students other2) {
        return other1.getGpa().compareTo(other2.getGpa());
    }
}

static class ComparatorOfGpaDec implements Comparator<Students>{
 @Override
    public int compare(Students other1, Students other2) {
        return (other2.getGpa().compareTo(other1.getGpa()));
    }
}

static class ComparatorOfCreditHours implements Comparator<Students>{
 @Override
    public int compare(Students other1, Students other2) {
        return other1.getCreditHours() - other2.getCreditHours() ;
    }
}
   
}
