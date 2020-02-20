package com.Excilys.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.Excilys.modeles.Computer;

public final class ComputerDAO { 
	
	private static volatile ComputerDAO instance = null;
	
	ComputerDAO() {

		
	}
	public static ComputerDAO getInstance() {
   
        if (ComputerDAO.instance == null) {
     
           synchronized(ComputerDAO.class) {
             if (ComputerDAO.instance == null) {
            	 ComputerDAO.instance = new ComputerDAO();
             }
           }
        }
     return ComputerDAO.instance;
    }
	public Computer getComputer(int id) {
		String affichage = "SELECT computer.id , computer.name , computer.introduced , computer.discontinued , computer.company_id FROM computer WHERE id=?;";
		Connexion conn = new Connexion();
		Computer computer = new Computer();
		Mapper map = new Mapper();
		conn.connect();
		return map.getCompterMapper(conn, affichage, id);
	}

	public boolean delete(int id) {
		Connexion conn = new Connexion();
		Computer computer = new Computer();
		Mapper map = new Mapper();
		conn.connect();
		String delete = "DELETE FROM computer WHERE id = ?";
		return map.deleteMapper(delete, conn, id);
		
	}

	public void update(Computer computer) {
		Connexion conn = new Connexion();
		Mapper mapper = new Mapper();
		conn.connect();
		String update = "UPDATE computer SET name = ? , introduced = ?  ,discontinued = ? ,company_id = ? WHERE id = ?";
		mapper.updateMapper(conn, update, computer);
		
	}

	public boolean insert(Computer computer) {
		Connexion conn = new Connexion();
		Mapper mapper = new Mapper();
		conn.connect();
		String insert = "INSERT INTO computer (name,introduced,discontinued,company_id) VALUES (?,?,?,?)";
		return mapper.insertMapper(conn, insert, computer);
		
		
		
	}

	public void select_All() {
		Connexion conn = new Connexion();
		Mapper mapper = new Mapper();
		String select_All = "SELECT * FROM computer";
		conn.connect();
		mapper.select_allMapper(conn, select_All);
		
   }
}
