package com.advancia.homebanking.session;

import javax.ejb.Local;

@Local
public interface ManagerOperazioniLocal {

	public String ricaricaConto(String idConto, int ammonto);
	
	public String bonifico(String idContoEmittente, String idContoRicevente, int ammonto);
}
