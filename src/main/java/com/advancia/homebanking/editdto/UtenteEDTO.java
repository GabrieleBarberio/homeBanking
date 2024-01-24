package com.advancia.homebanking.editdto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "UtenteEDTO")
public class UtenteEDTO {

	private String nome;

	private String cognome;

	private String password;

	private int saldoIniziale;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getSaldoIniziale() {
		return saldoIniziale;
	}

	public void setSaldoIniziale(int saldoIniziale) {
		this.saldoIniziale = saldoIniziale;
	}

}
