package com.advancia.homebanking.dao;



import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.advancia.homebanking.entity.Conto;
import com.advancia.homebanking.entity.Operazione;
import com.advancia.homebanking.util.JPAUtil;
import com.edvancia.homebanking.editdto.OperazioneEDTO;

public class OperazioniDAO {
	
	static Operazione operazioneFromDTO(OperazioneEDTO o, String tipo) {
		Operazione op = new Operazione(o.getEmittente(), o.getRicevente(),o.getAmmonto(),tipo);
		return op;
	}
	
	public String bonifico(OperazioneEDTO op) throws SQLException {
		
		
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		try {
			Operazione o = OperazioniDAO.operazioneFromDTO(op, "bonifico");
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
