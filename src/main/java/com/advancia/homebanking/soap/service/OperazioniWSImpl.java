package com.advancia.homebanking.soap.service;

import java.io.Serializable;
import java.sql.SQLException;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import com.advancia.homebanking.dao.OperazioniDAO;
import com.advancia.homebanking.editdto.OperazioneEDTO;

@Stateless
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class OperazioniWSImpl implements OperazioniWS, Serializable {
	private OperazioniDAO dao = new OperazioniDAO();

	private static final long serialVersionUID = 8099059522768722762L;
	public OperazioniWSImpl() {
		
	}
	
	@WebMethod
	public String bonifico(@WebParam(name = "emittente")int emittente, @WebParam(name = "ricevente")int ricevente, @WebParam(name = "ammonto")int ammonto ) throws SQLException {
		OperazioneEDTO op = new OperazioneEDTO(emittente, ricevente, ammonto);
		return dao.bonifico(op);
	}

	@WebMethod
	public String ricarica(@WebParam(name = "emittente")int emittente, @WebParam(name = "ammonto")int ammonto ) throws SQLException {
		OperazioneEDTO op = new OperazioneEDTO(emittente, ammonto);
		return dao.ricarica(op);
	}

	
}
