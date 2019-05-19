package it.polito.tdp.borders.model;

public class Country implements Comparable<Country>{
	
	private String sigla;
	private int code;
	private String nomeCompleto;
	
	public Country(String sigla, int code, String nomeCompleto) {
		super();
		this.sigla = sigla;
		this.code = code;
		this.nomeCompleto = nomeCompleto;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + code;
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
		Country other = (Country) obj;
		if (code != other.code)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return this.nomeCompleto;
	}

	@Override
	public int compareTo(Country altro) {
		return this.nomeCompleto.compareTo(altro.nomeCompleto);
	}
	
	
	
	

}
