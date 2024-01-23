package com.advancia.homebanking.session;

import javax.ejb.Stateless;

import com.advancia.homebanking.dao.UtenteDAO;
import com.edvancia.homebanking.editdto.UtenteEDTO;

/**
 * Session Bean implementation class ManagerUtenti
 */
@Stateless
public class ManagerUtenti implements ManagerUtentiLocal {

    /**
     * Default constructor. 
     */
	UtenteDAO ud = new UtenteDAO();
    public ManagerUtenti() {
        // TODO Auto-generated constructor stub
    }

    public String benvenuto(String nome, String cognome) {
    	
    	return "Ciao, " + nome + " " + cognome + " , benvenuto!";
    }
    
    public void aggiungiUtente(UtenteEDTO u) {
    	ud.addUtente(u);
    }
}
