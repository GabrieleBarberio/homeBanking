package com.advancia.homebanking.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="UTENTE")
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_UTENTE")
    private int idUtente;

    @Column(name="NOME")
    private String nome;

    @Column(name="COGNOME")
    private String cognome;

    @Column(name="PASSWORD")
    private String password;

    @OneToOne( cascade = CascadeType.ALL)
    private Conto conto;

public int getIdUtente() {
	return idUtente;
}
public void setIdUtente(int idUtente) {
	this.idUtente = idUtente;
}
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
public Conto getConto() {
	return conto;
}
public void setConto(Conto conto) {
	this.conto = conto;
}
}
