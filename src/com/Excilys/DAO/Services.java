package com.Excilys.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.Excilys.modeles.Computer;

public final class Services { 
	
	private static volatile Services instance = null;
	
	private Services() {
		
		
		
	}
	public static Services getInstance() {
   
        if (Services.instance == null) {
     
           synchronized(Services.class) {
             if (Services.instance == null) {
            	 Services.instance = new Services();
             }
           }
        }
     return Services.instance;
    }
	
	
	public void options() {
		Connexion conn = new Connexion();
		conn. connect();
		ComputerDAO dao = new ComputerDAO();
		String sc;
		System.out.println("Bonjour vous etes connectés à la base de donnée");
		System.out.println("\n \t Veuillez saisir une action : delete , insert , select_all ");
		System.out.println();
		Scanner scan = new Scanner(System.in);
		sc= scan.nextLine();
		switch(sc) {
		case "delete" :
			System.out.println("Selectionner un iD du l'ordinateur à éffacer");
			Scanner de = new Scanner(System.in);
			int id  = Integer.parseInt(de.nextLine());
			ComputerDAO.getComputer(id);
		case "insert" :
			System.out.println("Création d'un ordinateur");
			Computer computer = new Computer();
			
			
		
		break ;
		}
		
		
		
	}	
	public void insertComputer() {
		Computer computer = new Computer();
		System.out.println("Veuillez entrer la valeur de l'id");
		Scanner scn = new Scanner(System.in);
		int id  = Integer.parseInt(scn.nextLine());
		computer.setId(id);
		System.out.println("Veuillez entrer le nom de du téléphone");
		Scanner sci = new Scanner(System.in);
		String name = sci.nextLine();
		computer.setName(name);
		System.out.println("Veuillez entrer une date d'introduction (format dd/MM/AAAA)");
		Scanner scdi = new Scanner(System.in);
		computer.setIntroduced(LocalDate.parse(scdi, DateTimeFormatter.ofPattern("dd/MM/YYYY")));
		
		
		
		
		
	 }
	}