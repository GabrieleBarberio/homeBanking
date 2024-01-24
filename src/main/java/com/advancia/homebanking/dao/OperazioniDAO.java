package com.advancia.homebanking.dao;



import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.advancia.homebanking.editdto.OperazioneEDTO;
import com.advancia.homebanking.entity.Conto;
import com.advancia.homebanking.entity.Operazione;
import com.advancia.homebanking.util.JPAUtil;

public class OperazioniDAO {
	
	private EntityManager em;
	private EntityTransaction transaction;
	
	
	static Operazione bonificoFromDTO(OperazioneEDTO o, String tipo) {
		Operazione op = new Operazione(o.getEmittente(), o.getRicevente(),o.getAmmonto(),tipo);
		return op;
	}
	
	static Operazione ricaricaFromDTO(OperazioneEDTO o, String tipo) {
		Operazione op = new Operazione(o.getEmittente(), o.getAmmonto(),tipo);
		return op;
	}
	
	public void start() {
		this.em = JPAUtil.getEntityManagerFactory().createEntityManager();
		this.transaction = em.getTransaction();
		transaction.begin();
	}
	
	public String bonifico(OperazioneEDTO op) throws SQLException {
		start();
		
	
		try {
			Operazione o = OperazioniDAO.bonificoFromDTO(op, "bonifico");
			Conto c = em.find(Conto.class, op.getEmittente());
			o.setConto(c);
			em.persist(o);
			transaction.commit();
			return "operazione andata a buon fine";
		}catch(Throwable ex) {
			ex.printStackTrace();
			System.err.println("Errore durante l'operazione: " + ex);
			transaction.rollback();
			return ""+ex;
		}
		finally {
			em.close();
		}
		
	}
	
	public String ricarica(OperazioneEDTO op) throws SQLException {
		start();
		try {
			Operazione o = OperazioniDAO.ricaricaFromDTO(op, "ricarica");
			Conto c = em.find(Conto.class, op.getEmittente());
			o.setConto(c);
			em.persist(o);
			transaction.commit();
			return "operazione andata a buon fine";
		}catch(Throwable ex) {
			ex.printStackTrace();
			System.err.println("Errore durante l'operazione: " + ex);
			transaction.rollback();
			return ""+ex;
		}
		finally {
			em.close();
		}
		
	}
	
}
