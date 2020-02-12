package com.Excilys.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Excilys.modeles.*;
import com.Excilys.modeles.Computer;

public class CompagnieDAO {
	
	public boolean	select_All()	{
		Connexion conn = new Connexion();
		List <Compagnie> listcomp = new ArrayList<Compagnie>();
		String select_All = "SELECT * FROM company";
		conn.connect();
	try {
			PreparedStatement preparedStatement = conn.getConn().prepareStatement(select_All);
			ResultSet generateComputer = preparedStatement.executeQuery();
			while(generateComputer.next()) {
				  Compagnie company = new Compagnie();
				  company.setId(generateComputer.getInt(1));
				  company.setName(generateComputer.getString(2));	
				  listcomp.add(company);
				  conn.closeConn();
			}
		return true ;
		}catch(SQLException e) {
			
		return false;
	}
  }
}
