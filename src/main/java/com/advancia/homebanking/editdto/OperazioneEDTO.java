package com.advancia.homebanking.editdto;


public class OperazioneEDTO {

	private int ammonto;

	private int emittente;

	private int ricevente;

	private String tipo;
	
	
	public OperazioneEDTO( int emittente, int ricevente, int ammonto) {
		super();
		this.ammonto = ammonto;
		this.emittente = emittente;
		this.ricevente = ricevente;
		
	}

	public OperazioneEDTO( int emittente,int ammonto) {
		super();
		this.ammonto = ammonto;
		this.emittente = emittente;
		this.ricevente = emittente;
		
	}

	public int getAmmonto() {
		return ammonto;
	}

	public void setAmmonto(int ammonto) {
		this.ammonto = ammonto;
	}

	public int getEmittente() {
		return emittente;
	}

	public void setEmittente(int emittente) {
		this.emittente = emittente;
	}

	public int getRicevente() {
		return ricevente;
	}

	public void setRicevente(int ricevente) {
		this.ricevente = ricevente;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
