package com.advancia.homebanking.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.advancia.homebanking.editdto.ContoEDTO;
import com.advancia.homebanking.editdto.UtenteEDTO;
import com.advancia.homebanking.entity.Conto;
import com.advancia.homebanking.entity.Utente;
import com.advancia.homebanking.util.JPAUtil;

public class UtenteDAO {
	

	
	static Utente utenteFromDTO(UtenteEDTO u) {
		Utente userDaAggiungere = new Utente();
		userDaAggiungere.setCognome(u.getCognome());
		userDaAggiungere.setNome(u.getNome());
		userDaAggiungere.setPassword(u.getPassword());
		return userDaAggiungere;
	}
	static Conto contoFromDTO(ContoEDTO c) {
		Conto contoDaAggiungere = new Conto();
		contoDaAggiungere.setSaldoResiduo(c.getSaldoResiduo());
		return contoDaAggiungere;
		
	}
	public void addUtente(UtenteEDTO u) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		try {
			Utente utenteDaAggiungere = UtenteDAO.utenteFromDTO(u);
			Conto contoDaAggiungere = new Conto();
			contoDaAggiungere.setSaldoResiduo(u.getSaldoIniziale());
			utenteDaAggiungere.setConto(contoDaAggiungere);
			entityManager.persist(contoDaAggiungere);
			entityManager.persist(utenteDaAggiungere);
			transaction.commit();
			System.out.println("Utente aggiunto: " + utenteDaAggiungere);

		}catch(Throwable ex) {
			ex.printStackTrace();
			System.err.println("Errore aggiunta user: " + ex);
		}finally {
			entityManager.close();
		}
	}
}
