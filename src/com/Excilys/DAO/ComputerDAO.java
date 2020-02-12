package com.Excilys.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.Excilys.modeles.Computer;

public class ComputerDAO {

	public Computer getComputer(int id) {
		Connexion conn = new Connexion();
		Computer computer = new Computer();
		conn.connect();
		String affichage = "SELECT * FROM Computer where id=?";

		try {

			PreparedStatement preparedStatement = conn.getConn().prepareStatement(affichage);
			preparedStatement.setInt(1, id);
			ResultSet generateComputer = preparedStatement.executeQuery();

			generateComputer.next();
			computer.setId(generateComputer.getInt(1));
			computer.setName(generateComputer.getString(2));
			computer.setIntroduced(generateComputer.getDate(3));
			computer.setDiscontinuited(generateComputer.getDate(4));
			computer.setCompagnyId(generateComputer.getInt(5));
			conn.closeConn();

		} catch (SQLException e) {
			conn.closeConn();

		}
		return computer;
	}

	public boolean delete(int id) {
		Connexion conn = new Connexion();
		Computer computer = new Computer();
		conn.connect();
		String delete = "DELETE FROM Computer WHERE id = ?";
		try {
			PreparedStatement preparedStatement = conn.getConn().prepareStatement(delete);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			conn.closeConn();
			return true;
		} catch (SQLException e) {

			return false;
		}
	}

	public boolean update(int id, String Name, Date introduced, Date discontinued, int company_id) {
		Connexion conn = new Connexion();
		Computer computer = new Computer();
		conn.connect();
		String update = "UPDATE Computer SET name=? , introduced =? ,discontinued =? ,company_id=? WHERE id = ?";
		try {

			PreparedStatement preparedStatement = conn.getConn().prepareStatement(update);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, Name);
			preparedStatement.setDate(3, introduced);
			preparedStatement.setDate(4, discontinued);
			preparedStatement.setInt(5, company_id);
			preparedStatement.executeUpdate();
			conn.closeConn();
			return true;

		} catch (SQLException e) {

			return false;
		}

	}

	public boolean insert(Computer computer) {
		Connexion conn = new Connexion();
		String insert = "INSERT INTO computer (name,introduced,discontinued,company_id) VALUES (? ,?,?,?)";
		conn.connect();
		try {
			PreparedStatement preparedStatement = conn.getConn().prepareStatement(insert);

			preparedStatement.setString(1, computer.getname());
			preparedStatement.setDate(2, computer.getIntroduce());
			preparedStatement.setDate(3, computer.getDiscontinuited());
			preparedStatement.setInt(4,computer.getCompagnyId());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
			conn.closeConn();
			return true;
		} catch (SQLException e) {

			return false;

		}
	}

	public boolean select_All() {
		Connexion conn = new Connexion();
		List<Computer> listcomp = new ArrayList<Computer>();
		String select_All = "SELECT * FROM computer";
		conn.connect();
		try {
			PreparedStatement preparedStatement = conn.getConn().prepareStatement(select_All);
			ResultSet generateComputer = preparedStatement.executeQuery();
			while (generateComputer.next()) {
				Computer computer = new Computer();
				computer.setId(generateComputer.getInt(1));
				computer.setName(generateComputer.getString(2));
				computer.setIntroduced(generateComputer.getDate(3));
				computer.setDiscontinuited(generateComputer.getDate(4));
				computer.setCompagnyId(generateComputer.getInt(5));
				listcomp.add(computer);
				conn.closeConn();
			}
			return true;
		} catch (SQLException e) {

			return false;

		}
	}
}
