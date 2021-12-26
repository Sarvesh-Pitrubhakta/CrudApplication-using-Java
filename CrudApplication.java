//This is a CrudApplication
// Case 1- create the table.
// Case 2- Insert the data into table.
// Case 3- Read the data 
// Case 4- Update the data into
// Case 5- delete the data 

import java.sql.*;
import java.text.SimpleDateFormat;  
import java.util.Date;
import java.util.*;

public class CrudApplication
{
   public static void main(String args[]) throws Exception
   {
      Scanner sobj=new Scanner(System.in);
      Scanner str=new Scanner(System.in);
       System.out.println("Welcome To Our DataBase");
       String cd;
      do{

        
         System.out.println("Select Your Option");
         System.out.println("-[1.Create table0]-\n-[2.insert into Database]-\n-[3.Read Database]-\n-[4.Update Record]-\n-[5.Delete Record]-");
         var iChoice=sobj.nextLine();

         switch(iChoice)
         {

         case "1":

      try
      {
         
         Class.forName("com.mysql.cj.jdbc.Driver");
          Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sarvesh","root","root");
          Statement stmt = conn.createStatement();
        // PreparedStatement stmt1 = conn.prepareStatement("Create table student(Student_No,Student_Name,Student_DOB,Student_DOJ)");
          stmt.executeUpdate("CREATE TABLE Data"+
                              "(id INTEGER NOT NULL,"+
                              "Name VARCHAR(255),"+
                            "DOB DATE NOT NULL,"  +
                            "DOJ DATE NOT NULL)");

         System.out.println("Table Created Sucessfully");

      } 
      catch (Exception e) 
      {
         e.printStackTrace();
      } 
      break;

   case "2":

      try{
          Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sarvesh","root","root");



          System.out.print("Enter Number:");
          int no=sobj.nextInt();
          sobj.nextLine();

          System.out.print("Enter Name:");
          String name=sobj.next();

          System.out.println("Enter DOB");
         String dob=sobj.next();
        

         System.out.println("Enter DOJ");
         String doj=sobj.next();
      



          PreparedStatement stmt=conn.prepareStatement("insert into student (id,Name,DOB,DOJ) values(?,?,?,?)");
          //insert into student (varchar2 name(20), int rollnumber, varchar2 course(50));
          stmt.setInt(1,no);
          stmt.setString(2,name);
          stmt.setDate(3,dob);
          stmt.setDate(4,doj);
          stmt.executeUpdate();

          System.out.println("Sucess");

      }
      catch (Exception e) 
      {
         e.printStackTrace();
      } 
      break;

   case "3":

      try{
         Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sarvesh","root","root");

         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT * FROM Student");
      
         while (rs.next()) 
         {
            System.out.print("Student_No: " + rs.getInt("id"));
            System.out.print(", Name: " + rs.getString("Name"));
            System.out.print(", DOB: " + rs.getDate("DOB"));
            System.out.println(", DOJ: " + rs.getDate("DOJ"));
         }
      } 
      catch (Exception e) 
      {
         e.printStackTrace();
      }

   break;

   case "4":

      try{
         Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sarvesh","root","root");

         System.out.println("Enter name that you want to change :");
         String nm=sobj.next();

         System.out.println("Enter the unique id to update the Record :");
         int id=sobj.next();



        PreparedStatement stmt = conn.prepareStatement("update employee set name=? where emp_id=?");

        stmt.setString(1,nm);
        stmt.setInt(2,id);

        stmt.executeUpdate();

        System.out.println("Sucessful updated");
     }

        catch (Exception e) 
      {
         e.printStackTrace();
      }
      break;

   case "5":

      try{
         Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sarvesh","root","root");

         System.out.println("Enter id to delete Record:");
         int id=sobj.nextInt();

         PreparedStatement stmt = conn.prepareStatement("delete from student where id=?");

         stmt.setInt(1,id);

         System.out.println("Record Deleted Sucessfully");

         catch (Exception e) 
      {
         e.printStackTrace();
      }
      break;
   default :

      System.out.println("Invalid input");
      break;

   }

   System.out.println("Enter Y to continue else press another key");
  cd=sobj.nextLine();

   if(cd.equals("Y"))
   {
      System.out.println("You select to continue");
   }
      }
      while(cd.equals("Y"));

      System.out.println("Thank you for using the crud application");
   }
}






























