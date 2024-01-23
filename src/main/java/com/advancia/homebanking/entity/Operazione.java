package com.advancia.homebanking.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="OPERAZIONI")
public class Operazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_OPERAZIONE")
    private int idOperazione;

    @Column(name = "AMMONTO")
    private int ammonto; 

    @Column(name = "EMITTENTE")
    private int emittente;

    @Column(name = "RICEVENTE")
    private int ricevente;

    @ManyToOne
    @JoinColumn(name="ID_CONTO")
    private Conto conto;

	@Column(name="TIPO")
    private String tipo;
    public Operazione() {
    	
    }
    public Operazione( int emittente, int ricevente, int ammonto, String tipo) {
    	super();
		this.ammonto = ammonto;
		this.emittente = emittente;
		this.ricevente = ricevente;
		this.tipo = tipo;
    }
    public Operazione( int emittente,int ammonto, String tipo) {
		super();
		this.ammonto = ammonto;
		this.emittente = emittente;
		this.ricevente = emittente;
		this.tipo = tipo;
	}
    
	
	public int getIdOperazione() {
		return idOperazione;
	}

	public void setIdOperazione(int idOperazione) {
		this.idOperazione = idOperazione;
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
    public Conto getConto() {
		return conto;
	}
	public void setConto(Conto conto) {
		this.conto = conto;
	}
	
	

}
