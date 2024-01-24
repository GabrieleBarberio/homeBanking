package com.advancia.homebanking.soap.service;

import java.sql.SQLException;

import javax.ejb.Local;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;


@Local
@WebService(name = "OperazioniService", targetNamespace = "http://www.example.org/OperazioniService")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface OperazioniWS {
	
	@WebMethod
	public String bonifico(@WebParam(name = "emittente")int emittente, @WebParam(name = "ricevente")int ricevente, @WebParam(name = "ammonto")int ammonto ) throws SQLException;
	@WebMethod
	public String ricarica(@WebParam(name = "emittente")int emittente, @WebParam(name = "ammonto")int ammonto ) throws SQLException;
}
