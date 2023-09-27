/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package introduction;

import java.sql.*;
/**
 *
 * @author A.M
 */
public class TestConnection {
    public static void main(String[] args) {
        //Variables
String dbUrl = "jdbc:mysql://localhost:3306/thursday_db";
String username = "root";
String password = "";
try{
    //Step 1:Load and  Register
    //Class.forName("com.mysql.cj.jdnc.driver");
    //Step 2: create and get connection
        Connection con = DriverManager.getConnection(dbUrl,username,password);
    // Create Statement
    Statement st = con.createStatement();
    String sql = "CREATE TABLE patient(patient_id int,patient_names varchar(30),primary key(patient_id))";
    boolean isCreated = st.execute(sql);
    if(!isCreated){
        System.out.println("Table created !!");
    }else{
        System.out.println("Table not created");
    }
}catch(Exception ex){
    ex.printStackTrace();
}
      
    }
}
