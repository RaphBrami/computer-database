package com.Excilys.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.Excilys.modeles.Computer;

public class Mapper {

	public Computer getCompterMapper(Connexion conn, String affichage,int id )	{	
	
	Computer computer = new Computer();
	try {	

	PreparedStatement preparedStatement = conn.getConn().prepareStatement(affichage);
	preparedStatement.setInt(1, id);
	ResultSet generateComputer = preparedStatement.executeQuery();

	computer.setId(generateComputer.getInt(1));
	computer.setName(generateComputer.getString(2));
	computer.setIntroduced(generateComputer.getTimestamp(3).toLocalDateTime().toLocalDate());
	computer.setDiscontinuited(generateComputer.getTimestamp(4).toLocalDateTime().toLocalDate());
	computer.setCompagnyId(generateComputer.getInt(5));	
	
	
	} catch(SQLException e) {
		
		conn.closeConn();
	}
		return computer;
  }
	
	public boolean deleteMapper(String delete,Connexion conn,int id) {
		try {
			PreparedStatement preparedStatement = conn.getConn().prepareStatement(delete);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			preparedStatement.close();
			conn.closeConn();
			return true;
		} catch (SQLException e) {

			conn.closeConn();
			return false;
			
		}	
	}
	
	public boolean updateMapper(Connexion conn,String update,Computer computer) {
		
		try {
			
			PreparedStatement preparedStatement = conn.getConn().prepareStatement(update);
			preparedStatement.setInt(1, computer.getid());
			preparedStatement.setString(2, computer.getname());
			preparedStatement.setTimestamp(3, computer.getIntroduce()!=null?Timestamp.valueOf( computer.getIntroduce().atTime(LocalTime.MIDNIGHT)):null);
			preparedStatement.setTimestamp(4, computer.getDiscontinuited()!=null?Timestamp.valueOf( computer.getDiscontinuited().atTime(LocalTime.MIDNIGHT)):null);
			preparedStatement.setInt(5, computer.getCompagnyId());
			preparedStatement.executeUpdate();
			preparedStatement.close();
			conn.closeConn();
			return true;

		} catch (SQLException e) {
			
			conn.closeConn();
			return false;
	   }		
	}
	
	public boolean insertMapper(Connexion conn, String insert ,Computer computer) {
		
		try {
			PreparedStatement preparedStatement = conn.getConn().prepareStatement(insert);
			preparedStatement.setString(1, computer.getname());
			preparedStatement.setTimestamp(2,computer.getIntroduce()!=null?Timestamp.valueOf(computer.getIntroduce().atTime(LocalTime.MIDNIGHT)):null);			
			preparedStatement.setTimestamp(3,computer.getDiscontinuited()!=null?Timestamp.valueOf(computer.getDiscontinuited().atTime(LocalTime.MIDNIGHT)):null);		
			preparedStatement.setInt(4,computer.getCompagnyId());			
			System.out.println(preparedStatement);			
			preparedStatement.executeUpdate();	
			preparedStatement.close();
			conn.closeConn();
			return true;
		}catch (SQLException e) {
			
			conn.closeConn();
			return false;

       }
    }
	
	public boolean select_allMapper(Connexion conn , String select_All) {
		List<Computer> listcomp = new ArrayList<Computer>();
	try {
			
			PreparedStatement preparedStatement = conn.getConn().prepareStatement(select_All);
			ResultSet generateComputer = preparedStatement.executeQuery();
			while (generateComputer.next()) {
				Computer computer = new Computer();
				computer.setId(generateComputer.getInt(1));
				computer.setName(generateComputer.getString(2));
				computer.setIntroduced(generateComputer.getTimestamp(3).toLocalDateTime().toLocalDate());
				computer.setDiscontinuited(generateComputer.getTimestamp(4).toLocalDateTime().toLocalDate());
				computer.setCompagnyId(generateComputer.getInt(5));
				listcomp.add(computer);
			}
				for(Computer comp : listcomp ) {
					System.out.println(comp.toString());
				}
				conn.closeConn();

		  return true;
		  
		} catch (SQLException e) {

		  conn.closeConn();
	      return false;	   
		}	
	}
}

