package com.Excilys.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import com.Excilys.modeles.Computer;

public final class UI { 
	
	private static volatile UI instance = null;
	
	private UI() {
		
	}
	public static UI getInstance() {
   
        if (UI.instance == null) {
     
           synchronized(UI.class) {
             if (UI.instance == null) {
            	 UI.instance = new UI();
             }
           }
        }
     return UI.instance;
    }
	
	
	public void options() {
		Connexion conn = new Connexion();
		conn. connect();
		ComputerDAO.getInstance();
		
		System.out.println("Bonjour vous etes connectés à la base de donnée ");
		System.out.println("\n \t Veuillez saisir une action : delete , insert , select_allComputer, update , select_ordinateur,select_allCompany");
		
		System.out.println();
		Scanner scan = new Scanner(System.in);
		String sc;
		sc= scan.nextLine();
		
		switch(sc) {
		case "delete" :
			interfacedelete();
			retourMenu();
		break;
		case "insert" :
			System.out.println("Création d'un ordinateur daans la base de donnée");
			interfaceInsertComputer();
			retourMenu();		
			
		break ;
		
		case "select_allComputer" :
			System.out.println("Affichage de tout les Ordinateurs");
			interfaceSelectAllPaginate();
			retourMenu();
	
		break;
		
		case "update" :
			
			System.out.println("Update d'un ordinateur de la base de donnée");
			interfaceUpdate();
			retourMenu();
		break;
		
		case "select_ordinateur" :
			
			System.out.println("Selection d'un ordinateur de la base de donnée");
			interfaceSelectOrdinateur();
			retourMenu();
		break;
		case "select_allCompany":
			
			System.out.println("Affichage de toutes les Company");
			interfaceAllCompany();
			retourMenu();
		
		default :
			System.out.println("veuilez ressaisir un choix");
		
		}
	}	
	private void interfaceInsertComputer() {
		Computer computer = new Computer();
		System.out.println("Veuillez entrer le nom de de l'ordinateur");
		Scanner sci = new Scanner(System.in);
		String name = sci.nextLine();
		computer.setName(name);
		System.out.println("Veuillez entrer une date d'introduction (format dd/MM/AAAA)");
		Scanner scdi = new Scanner(System.in);
		String dateintro = scdi.nextLine();
		computer.setIntroduced(scannerDate(dateintro));
		System.out.println("Veuillez entrer une date de fin d'exploitation (format dd/MM/AAAA)");
		Scanner scdd = new Scanner(System.in);
		String datefinal = scdd.nextLine();
		computer.setDiscontinuited(scannerDate(datefinal));
		System.out.println("Veuillez saisir l'id de la company de 1 à 43");
		Scanner scdic = new Scanner(System.in);
		int id_company = scdic.nextInt();
		computer.setCompagnyId(id_company);
		System.out.println("Récupération de l'ordinateur");
		Services.getInstance().ServiceInsert(computer);
		
	
	}
	private void interfacedelete() {
			System.out.println("Veuillez entrer la valeur de l'id de l'ordinateur à éffacer");
			Scanner de = new Scanner(System.in);
			int id  = Integer.parseInt(de.nextLine());
			Services.getInstance().ServiceDelete(id);
		}
	
	private void interfaceSelectAllPaginate() {
		int i = 0;
		
		while(i*20 < Services.getInstance().ServiceCountAllComputer()) {
			Services.getInstance().ServiceSelectAll(Optional.of(20),Optional.of(i));
			i++;
		}
		
	}
	
	private void interfaceSelect_all() {
	
		Services.getInstance().ServiceSelectAll(Optional.empty(),Optional.empty());
		
				
	}
	
	private void interfaceUpdate() {
		Computer computer = new Computer();
		System.out.println("Veuillez selectionner l'Id de l'ordinateur");
		Scanner sid = new Scanner(System.in);
		int  sids = sid.nextInt();
		computer.setId(sids);
		System.out.println("Veuillez entrer le nom de du téléphone");
		Scanner sci = new Scanner(System.in);
		String name = sci.nextLine();
		computer.setName(name);
		System.out.println("Veuillez entrer une date d'introduction (format dd/MM/AAAA)");
		Scanner scdi = new Scanner(System.in);
		String dateintro = scdi.nextLine();
		computer.setIntroduced(scannerDate(dateintro));
		System.out.println("Veuillez entrer une date de fin d'exploitation (format dd/MM/AAAA)");
		Scanner scdd = new Scanner(System.in);
		String datefinal = scdd.nextLine();
		computer.setDiscontinuited(scannerDate(datefinal));
		System.out.println("Veuillez saisir l'id de la company de 1 à 43");
		Scanner scdic = new Scanner(System.in);
		int id_company = scdic.nextInt();
		computer.setCompagnyId(id_company);
		System.out.println(computer.toString());
		System.out.println("Update de l'ordinateur");
		Services.getInstance().ServiceUpdate(computer);		
		
	}
	
	private void interfaceSelectOrdinateur() {
		System.out.println("Veillez selectionner un Id");
		Scanner id = new Scanner(System.in);
		int idOrdi = id.nextInt();
		Services.getInstance().ServiceGetComputer(idOrdi);
	}
	
	private LocalDate scannerDate(String scanner) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			LocalDate date = null ;
			try {
			date = LocalDate.parse(scanner, formatter);	
			
			}catch(DateTimeParseException e) {				
			e.printStackTrace();	
			}
	return date;
	
	    }
	
	private void interfaceAllCompany() {
		
		Services.getInstance().ServiceCompanySelect();
		retourMenu();
	}
	private void  retourMenu() {
		
		System.out.println("\n \t Voulez vous revenir au menu  (Y/N)?");
		Scanner exit = new Scanner(System.in);
		char choix= exit.nextLine().charAt(0);
		if (choix=='Y') {
			
			options();
		}
		else if(choix == 'N'){
			
			System.out.println("au revoir");
			
		}
		else {
			
			System.out.println("erreur de saisie , veuillez recommencer");
			retourMenu();
		}	
	} 
	
}