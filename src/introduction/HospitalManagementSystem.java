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
                        String sql = "insert into patient(patient_id,patient_names) values(null,'Kevin Iradukunda')";
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
                    try{
                        Connection con = DriverManager.getConnection(dbUrl ,username ,password);
                        Statement st = con.createStatement();
                        System.out.println(" Record a patient ");
                        String name = sc.next();
                        int rowAffected = st.executeUpdate(InsertFunction(name));
                        if(rowAffected >= 1){
                            System.out.println("The patient "+name+" recorded successfully");
                        }else{
                            System.out.println("Patient not created !!");
                        }
                        con.close();
                        System.out.println("Enter Yes or NO to continue or to exit:");
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
                case 3:
                    try{
                        Connection con = DriverManager.getConnection(dbUrl, username, password);
                        Statement st = con.createStatement();
                        String query = "UPDATE patient SET patient_names = 'Safari Samuel'";
                        int rowAffected = st.executeUpdate(query);
                        if(rowAffected >= 1){
                            System.out.println("All Patients names updated succefully");
                        }else{
                            System.out.println("Sorry update failed!!");
                        }
                        con.close();
                        System.out.println("Enter Yes or No to Continue or to Exit !!");
                        String answer = sc.next();
                        if(answer.equalsIgnoreCase("yes")){
                            condition = true;
                        }else{
                            System.out.println("Thank for you using the system");
                            condition = false;
                        }
                        
                    }catch(Exception ex){
                        ex.printStackTrace();
                    }
                    break;
                case 4:
                    try{
                    Connection con = DriverManager.getConnection(dbUrl ,username ,password);
                    Statement st = con.createStatement();
                    System.out.println("Update all patient names: ");
                    String name = sc.next();
                    int rowAffected = st.executeUpdate(updateFunction(name));
                    if(rowAffected >= 1){
                        System.out.println("All patient names are updated to only name which is :"+name);
                    }else{
                        System.out.println("Update failed sorry");
                    }
                    con.close();
                    System.out.println("Enter Yes or No to Continue or to Exit");
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
                case 5:
                    try{
                        Connection con =DriverManager.getConnection(dbUrl, username, password);
                        Statement st = con.createStatement();
                        String query = "DELETE FROM patient WHERE patient_names = 'Ingabire'";
                        int rowAffected = st.executeUpdate(query);
                        if(rowAffected >= 1){
                        System.out.println("Patient deleted succefully !!!");
                    }else{
                        System.out.println("Delete failed sorry the proposed patient is not recorded");
                    }
                    con.close();
                    System.out.println("Enter Yes or No to Continue or to Exit :");
                    String answer = sc.next();
                    if(answer.equalsIgnoreCase("yes")){
                        condition = true;
                    }else{
                        System.out.println("Thank you for using the system!!");
                        condition = false;
                    }
                    }catch(Exception ex){
                        ex.printStackTrace();
                    }
                    break;
                case 6:
                    try{
                        Connection con = DriverManager.getConnection(dbUrl ,username ,password);
                        Statement st = con.createStatement();
                        String name = sc.next();
                        int rowAffected = st.executeUpdate(deleteFunction(name));
                        
                        if(rowAffected >=1){
                            System.out.println("The patient named "+name+" deleted successfully!!");
                        }else{
                            System.out.println("The propesed patient is not recorded !!");
                        }
                        con.close();
                        System.out.println("Enter Yes or No to Continue or to Exit :");
                        String answer = sc.next();
                        if(answer.equalsIgnoreCase("yes")){
                            condition = true;                        
                        }else{
                            System.out.println("Thank you for Using the system!!");
                            condition = false;
                        }                       
                        
                    }catch(Exception ex){
                        ex.printStackTrace();
                    }
                    break;
                case 7:
                    try{
                        ResultSet rst= null;
                        Connection con = DriverManager.getConnection(dbUrl, username, password);
                        Statement st = con.createStatement();
                        String query  = "SELECT * FROM patient";
                        rst = st.executeQuery(query);
                        System.out.println("==================================================");
                        System.out.println("        ========RECORDED STUDENTS=========");
                        System.out.println("==================================================");
                        while(rst.next()){
                            System.out.println("Patient ID :"+rst.getInt("patient_id")+" Name :"+rst.getString("patient_names"));
                        }
                        System.out.println("==================================================");
                        con.close();
                        System.out.println("Enter Yes or No to Continue or to Exit :");
                        String answer = sc.next();
                        if(answer.equalsIgnoreCase("yes")){
                            condition = true;                        
                        }else{
                            System.out.println("Thank you for Using the system!!");
                            condition = false;
                        }                       
                        
                    }catch(Exception ex){
                        ex.printStackTrace();
                    }
                    break;
                    
                case 8:
                    try{
                        ResultSet rst = null;
                        Connection con = DriverManager.getConnection(dbUrl, username, password);
                        Statement st = con.createStatement();
                        System.out.println("Search patient by ID :");
                        int id = sc.nextInt();
                        rst = st.executeQuery(searchByIdFunction(id));
                        System.out.println("==================================================");
                        System.out.println("        ========SEARCHED STUDENT=========");
                        System.out.println("==================================================");
                        while(rst.next()){
                            System.out.println("The search students is :"+rst.getString("patient_names"));
                        }
                        System.out.println("==================================================");

                        con.close();
                        System.out.println("Enter Yes or No to Continue or to Exit :");
                        String answer = sc.next();
                        if(answer.equalsIgnoreCase("yes")){
                            condition = true;                        
                        }else{
                            System.out.println("Thank you for Using the system!!");
                            condition = false;
                        }       
                    
                    }catch(Exception ex){
                        ex.printStackTrace();
                    }
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
    public static String InsertFunction(String name){
        String query = "INSERT INTO patient(patient_id,patient_names) VALUES(null,'"+name+"')";
        return query;
    }
    
    public static String updateFunction(String name){
        String query = "UPDATE patient SET patient_names = '"+name+"'";
        return query;
    }
    
    public static String deleteFunction(String name){
        String query = "DELETE FROM patient WHERE patient_names = '"+name+"'";
        return query;
    }
    
    public static String searchByIdFunction(int id){
        String query = "SELECT * FROM patient WHERE patient_id = '"+id+"'";
        return query;
    }
}
