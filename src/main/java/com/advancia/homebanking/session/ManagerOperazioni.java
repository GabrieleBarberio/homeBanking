package com.advancia.homebanking.session;

import java.sql.SQLException;

import javax.ejb.Stateless;

import com.advancia.homebanking.dao.OperazioniDAO;
import com.advancia.homebanking.editdto.OperazioneEDTO;

/**
 * Session Bean implementation class ManagerOperazioni
 */
@Stateless
public class ManagerOperazioni implements ManagerOperazioniLocal {

	private OperazioniDAO dao = new OperazioniDAO();

	public ManagerOperazioni() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String ricaricaConto(int idConto, int ammonto) throws SQLException {
		OperazioneEDTO op = new OperazioneEDTO(idConto, ammonto);
		return dao.ricarica(op);
	}

	@Override
	public String bonifico(int idContoEmittente, int idContoRicevente, int ammonto) throws SQLException {
		OperazioneEDTO op = new OperazioneEDTO(idContoEmittente, idContoEmittente, ammonto);
		return dao.bonifico(op);
	}

}
