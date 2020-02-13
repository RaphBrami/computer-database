package com.Excilys.modeles;

import java.sql.Date;

import com.Excilys.DAO.ComputerDAO;
import com.Excilys.DAO.Connexion;

public class Test {

	public static void main(String[] args) {
		
		Connexion conn = new Connexion();
		conn.connect();
		ComputerDAO.getInstance();	
	} 
}
