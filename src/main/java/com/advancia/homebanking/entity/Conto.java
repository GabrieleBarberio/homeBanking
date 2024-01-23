package com.advancia.homebanking.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "CONTO")
public class Conto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CONTO")
    private int idConto;

    @Column(name = "SALDO_RESIDUO")
    private long saldoResiduo;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "conto", cascade = CascadeType.ALL)
    private List<Operazione> operazioni;

    @OneToOne(cascade = CascadeType.ALL, mappedBy="conto")
    private Utente utente;

	public int getIdConto() {
		return idConto;
	}

	public void setIdConto(int idConto) {
		this.idConto = idConto;
	}

	public long getSaldoResiduo() {
		return saldoResiduo;
	}

	public void setSaldoResiduo(long saldoResiduo) {
		this.saldoResiduo = saldoResiduo;
	}

	public List<Operazione> getOperazioni() {
		return operazioni;
	}

	public void setOperazioni(Operazione operazione) {
		this.operazioni.add(operazione);
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

}
