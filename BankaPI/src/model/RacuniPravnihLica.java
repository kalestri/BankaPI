package model;

import java.util.Date;

public class RacuniPravnihLica {

	private String brojRauna;
	private Date datumOtvaranja;
	private boolean vazeci;
	
	public RacuniPravnihLica(){
		
	}
	
	public RacuniPravnihLica(String brojRauna, Date datumOtvaranja, boolean vazeci) {
		this.brojRauna = brojRauna;
		this.datumOtvaranja = datumOtvaranja;
		this.vazeci = vazeci;
	}



	public String getBrojRauna() {
		return brojRauna;
	}



	public void setBrojRauna(String brojRauna) {
		this.brojRauna = brojRauna;
	}



	public Date getDatumOtvaranja() {
		return datumOtvaranja;
	}



	public void setDatumOtvaranja(Date datumOtvaranja) {
		this.datumOtvaranja = datumOtvaranja;
	}



	public boolean isVazeci() {
		return vazeci;
	}



	public void setVazeci(boolean vazeci) {
		this.vazeci = vazeci;
	}
	
}
