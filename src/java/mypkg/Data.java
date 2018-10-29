package mypkg;

import java.sql.Connection;
import java.sql.DriverManager;

public class Data {

public static Connection connect(){
    Connection con=null;
    try{
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shopdata","root","root");
    }catch(Exception e){
        e.printStackTrace();
    }
    return con;
}

public static void main(String args[]){
    Connection con=connect();
    System.out.println(con);
}
    
}
