package com.advancia.homebanking.session;

import javax.ejb.Local;

import com.advancia.homebanking.editdto.UtenteEDTO;

@Local
public interface ManagerUtentiLocal {

	public String benvenuto(String nome, String cognome);
	
	public void aggiungiUtente(UtenteEDTO u);
}
