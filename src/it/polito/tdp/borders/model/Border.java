package it.polito.tdp.borders.model;

import java.time.Year;

public class Border {
	
	private int distanza;
	private int statoUnoCodice;
	private String statoUnoSigla;
	private int statoDueCodice;
	private String statoDueSigla;
	private Year anno;
	private int conttype;
	
	public Border(int distanza, int statoUnoCodice, String statoUnoSigla, int statoDueCodice, String statoDueSigla,
			Year anno, int conttype) {
		super();
		this.distanza = distanza;
		this.statoUnoCodice = statoUnoCodice;
		this.statoUnoSigla = statoUnoSigla;
		this.statoDueCodice = statoDueCodice;
		this.statoDueSigla = statoDueSigla;
		this.anno = anno;
		this.conttype = conttype;
	}

	public int getDistanza() {
		return distanza;
	}

	public void setDistanza(int distanza) {
		this.distanza = distanza;
	}

	public int getStatoUnoCodice() {
		return statoUnoCodice;
	}

	public void setStatoUnoCodice(int statoUnoCodice) {
		this.statoUnoCodice = statoUnoCodice;
	}

	public String getStatoUnoSigla() {
		return statoUnoSigla;
	}

	public void setStatoUnoSigla(String statoUnoSigla) {
		this.statoUnoSigla = statoUnoSigla;
	}

	public int getStatoDueCodice() {
		return statoDueCodice;
	}

	public void setStatoDueCodice(int statoDueCodice) {
		this.statoDueCodice = statoDueCodice;
	}

	public String getStatoDueSigla() {
		return statoDueSigla;
	}

	public void setStatoDueSigla(String statoDueSigla) {
		this.statoDueSigla = statoDueSigla;
	}

	public Year getAnno() {
		return anno;
	}

	public void setAnno(Year anno) {
		this.anno = anno;
	}

	public int getConttype() {
		return conttype;
	}

	public void setConttype(int conttype) {
		this.conttype = conttype;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + statoDueCodice;
		result = prime * result + statoUnoCodice;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Border other = (Border) obj;
		if (statoDueCodice != other.statoDueCodice)
			return false;
		if (statoUnoCodice != other.statoUnoCodice)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("Border [distanza=%s, statoUnoSigla=%s, statoDueSigla=%s, anno=%s]", distanza,
				statoUnoSigla, statoDueSigla, anno);
	}
	
	
	
	
	
	
	
	

}
