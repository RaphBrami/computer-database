package com.Excilys.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
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
		System.out.println("\n \t Veuillez saisir une action : delete , create , select_all ");
		System.out.println();
		Scanner scan = new Scanner(System.in);
		sc= scan.nextLine();
		switch(sc) {
		case "delete" :
			
		break ;
		}
		
		
		
	}
}