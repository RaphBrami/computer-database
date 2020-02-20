package com.excilys.dao;

import java.util.Optional;

import com.Excilys.modeles.*;

public class Services {

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
	
	public void ServiceGetComputer(int id) {
	System.out.println(ComputerDAO.getInstance().getComputer(id));
	
	}
	
	public boolean ServiceDelete(int id) {
	 return ComputerDAO.getInstance().delete(id);
		
	}
	
	public void ServiceUpdate(Computer computer) {
	ComputerDAO.getInstance().update(computer);
	}
	
	public boolean ServiceInsert(Computer computer) {
	return ComputerDAO.getInstance().insert(computer);
	}
	
	public void ServiceSelectAll(Optional<Integer> taille, Optional<Integer> page) {
	 ComputerDAO.getInstance().select_All(taille, page);
	}
	public void ServiceCompanySelect() {
	CompanyDAO.getInstance().select_All();
	 
	}
	public int ServiceCountAllComputer() {
		
	return	ComputerDAO.getInstance().count();
		
	}
	
}

