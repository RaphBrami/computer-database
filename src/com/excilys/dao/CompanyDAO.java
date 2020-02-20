package com.excilys.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.Excilys.modeles.*;
import com.Excilys.modeles.Computer;

	public final class CompanyDAO { 
		
		private static volatile CompanyDAO instance = null;
		
		CompanyDAO() {

			
		}
		public static CompanyDAO getInstance() {
	   
	        if (CompanyDAO.instance == null) {
	     
	           synchronized(CompanyDAO.class) {
	             if (CompanyDAO.instance == null) {
	            	 CompanyDAO.instance = new CompanyDAO();
	             }
	           }
	        }
	     return CompanyDAO.instance;
	    }
	
	public boolean select_All()	{
		Connexion conn = new Connexion();
		List <Compagnie> listcomp = new ArrayList<Compagnie>();
		String select_All = "SELECT company.id , company.name FROM company";
		conn.connect();
		Compagnie company = new Compagnie();
	try {
			PreparedStatement preparedStatement = conn.getConn().prepareStatement(select_All);
			ResultSet generateComputer = preparedStatement.executeQuery();
			while(generateComputer.next()) {
						
			int id = generateComputer.getInt(1);
				  String name = generateComputer.getString(2);
				  company.setId(id);
				  company.setName(name);	
				  listcomp.add(company);
				  System.out.println(company);
			}
			  preparedStatement.close();
			  conn.closeConn();
		return true;
		}catch(SQLException e) {
			System.out.println(e);
		return false;
	}
  }
}
