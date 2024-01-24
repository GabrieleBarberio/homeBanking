package com.advancia.homebanking.editdto;

import java.util.List;

import com.advancia.homebanking.entity.Operazione;

public class ContoEDTO {
	    private int idConto;

	    private long saldoResiduo;

	    private List<Operazione> operazioni;

	    private UtenteEDTO utente;

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

		public UtenteEDTO getUtente() {
			return utente;
		}

		public void setUtente(UtenteEDTO utente) {
			this.utente = utente;
		}
}
