package com.Excilys.modeles;

import java.sql.Date;

import com.Excilys.DAO.ComputerDAO;
import com.Excilys.DAO.Connexion;

public class Test {

	public static void main(String[] args) {

		ComputerDAO cdao = new ComputerDAO();
		Computer comp = new Computer()
				.setId(575)
				.setName("Iphone_X")
				.setIntroduced(Date.valueOf("2018-09-12"))
				.setDiscontinuited(Date.valueOf("2022-09-12"))
				.setCompagnyId(10);		
		
		System.out.println(comp.toString());
		
		cdao.insert(comp);
		
		
	}
}
