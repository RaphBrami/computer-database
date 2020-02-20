package com.Excilys.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Connexion {
	private  Connection conn; 
	
    public void connect() {
        String user = "admincdb";
        String mdp = "mot_de_passe";
        String BddName = "computer-database-db";
        String url = "jdbc:mysql://localhost:3306/computer-database-db?useSSL=false";
        try{
            conn = DriverManager.getConnection(url, user, mdp);
            System.out.println("Connexion ok");
        }catch(SQLException e){
            e.printStackTrace();
        } 
        
    }
    public  Connection getConn() {
        return conn;
        } 
    
    public void  closeConn(){
    
    	try {
    		conn.close();
    	} catch(SQLException e ){
    		
    		e.printStackTrace();
    	}   
    }
}
