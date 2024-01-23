package com.advancia.homebanking.session;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class ManagerOperazioni
 */
@Stateless
public class ManagerOperazioni implements ManagerOperazioniLocal {

    /**
     * Default constructor. 
     */
    public ManagerOperazioni() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public String ricaricaConto(String idConto, int ammonto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String bonifico(String idContoEmittente, String idContoRicevente, int ammonto) {
		// TODO Auto-generated method stub
		return null;
	}

}
