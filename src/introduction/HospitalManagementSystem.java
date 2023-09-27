/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package introduction;

import java.util.*;
import java.sql.*;

/**
 *
 * @author A.M
 */
public class HospitalManagementSystem {
    public static void main(String []arg){
        boolean condition = true;
        String dbUrl = "jdbc:mysql://localhost:3306/thursday_db";
        String username = "root";
        String password = "";
        while(condition){
            System.out.println("===================");
            System.out.println("1. Create a Patient Manual");
            System.out.println("2. Create a Patient Dynamically");
            System.out.println("3. Update a Patient Manuel");
            System.out.println("4. Update a Patient Dynamically");
            System.out.println("5. Delete a Patient Manual");
            System.out.println("6. Delete a Patient Dynamically");
            System.out.println("7. Retrieve all Parient");
            System.out.println("8. Search Patient by ID");
            System.out.println("0. Exit");
            System.out.print("Choice: ");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            
            switch(choice){
                case 1:
                    try{
                        Connection con = DriverManager.getConnection(dbUrl ,username ,password);
                        Statement st = con.createStatement();
                        String sql = "insert into patient(patient_id,patient_names) values(1,'Kevin Iradukunda')";
                        int rowAffected = st.executeUpdate(sql);
                        if(rowAffected >= 1){
                            System.out.println("Patient Created");
                        }else{
                            System.out.println("Patient not created");
                        }
                        con.close();
                        System.out.println("Enter Yes or No to continue or to exit: ");
                        String answer = sc.next();
                        if(answer.equalsIgnoreCase("yes")){
                            condition = true;
                        }else{
                            System.out.println("Thank you for using the system");
                            condition = false;
                        }
                        
                    }catch(Exception ex){
                        ex.printStackTrace();
                    }
                    break;
                case 2:
                    System.out.println("Second Option");
                    break;
                case 3:
                    System.out.println("Third Option");
                    break;
                case 0:
                    System.out.println("Wrong Choice!!");
                    System.out.println("Enter Yes or No to continue or to exit");
                    String answer = sc.next();
                    if(answer.equalsIgnoreCase("yes")){
                        condition = true;
                    }else{
                        System.out.println("Thank you for using the system");
                        condition = false;
                    }
                    
            }
            
            
        }
    }
}
