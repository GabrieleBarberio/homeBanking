package com.advancia.homebanking.service;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.advancia.homebanking.session.ManagerUtentiLocal;
import com.edvancia.homebanking.editdto.UtenteEDTO;

@Path("/utente")
public class UtenteServiceImpl implements UtenteService {

	@EJB
	ManagerUtentiLocal mu;

	@POST
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public void addUtente(UtenteEDTO u) {

		UtenteEDTO utente = new UtenteEDTO();
		utente.setCognome(u.getCognome());
		utente.setNome(u.getNome());
		utente.setPassword(u.getPassword());
		utente.setSaldoIniziale(u.getSaldoIniziale());
		mu.aggiungiUtente(utente);
	}

}
