package com.advancia.homebanking.session;

import java.sql.SQLException;

import javax.ejb.Local;

@Local
public interface ManagerOperazioniLocal {

	public String ricaricaConto(int idConto, int ammonto) throws SQLException;
	
	public String bonifico(int idContoEmittente, int idContoRicevente, int ammonto) throws SQLException;
}
