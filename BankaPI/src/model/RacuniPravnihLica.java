package model;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "RacuniPravnihLica")
public class RacuniPravnihLica {

	@Id
	@Column(name = "broj_racuna", columnDefinition="VARCHAR(30)", unique = true, nullable = false)
	private String brojRacuna;
	
	@Column(name = "datum_otvaranja", columnDefinition="DATE", unique = false, nullable = false)
	private Date datumOtvaranja;
	
	@Column(name = "vazeci", columnDefinition="BIT", unique = false, nullable = false)
	private Boolean vazeci;
	
	@ManyToOne
	@JoinColumn(name = "pibp", referencedColumnName = "pib", nullable = false)
	private PravnaLica poslovnaBanka;
	
	@ManyToOne
	@JoinColumn(name = "pibv", referencedColumnName = "pib", nullable = false)
	private PravnaLica vlasnikRacuna;
	
	@ManyToOne
	@JoinColumn(name = "sifra_valute", referencedColumnName = "sifra_valute", nullable = false)
	private Valute valutaRacuna;
	
	@OneToMany(cascade = { ALL }, fetch = LAZY, mappedBy = "dnevniIzvodiBanke")
	private Set<DnevnoStanjeRacuna> dnevniIzvodiBanke = new HashSet<DnevnoStanjeRacuna>();
	
	@OneToMany(cascade = { ALL }, fetch = LAZY, mappedBy = "ukidanjeRacuna")
	private Set<Ukidanje> ukidanjeRacuna = new HashSet<Ukidanje>();

	
	
	public RacuniPravnihLica() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RacuniPravnihLica(String brojRacuna, Date datumOtvaranja,
			Boolean vazeci, PravnaLica poslovnaBanka, PravnaLica vlasnikRacuna,
			Valute valutaRacuna, Set<DnevnoStanjeRacuna> dnevniIzvodiBanke,
			Set<Ukidanje> ukidanjeRacuna) {
		super();
		this.brojRacuna = brojRacuna;
		this.datumOtvaranja = datumOtvaranja;
		this.vazeci = vazeci;
		this.poslovnaBanka = poslovnaBanka;
		this.vlasnikRacuna = vlasnikRacuna;
		this.valutaRacuna = valutaRacuna;
		this.dnevniIzvodiBanke = dnevniIzvodiBanke;
		this.ukidanjeRacuna = ukidanjeRacuna;
	}

	public String getBrojRacuna() {
		return brojRacuna;
	}

	public void setBrojRacuna(String brojRauna) {
		this.brojRacuna = brojRacuna;
	}

	public Date getDatumOtvaranja() {
		return datumOtvaranja;
	}

	public void setDatumOtvaranja(Date datumOtvaranja) {
		this.datumOtvaranja = datumOtvaranja;
	}

	public Boolean getVazeci() {
		return vazeci;
	}

	public void setVazeci(Boolean vazeci) {
		this.vazeci = vazeci;
	}

	public PravnaLica getPoslovnaBanka() {
		return poslovnaBanka;
	}

	public void setPoslovnaBanka(PravnaLica poslovnaBanka) {
		this.poslovnaBanka = poslovnaBanka;
	}

	public PravnaLica getVlasnikRacuna() {
		return vlasnikRacuna;
	}

	public void setVlasnikRacuna(PravnaLica vlasnikRacuna) {
		this.vlasnikRacuna = vlasnikRacuna;
	}

	public Valute getValutaRacuna() {
		return valutaRacuna;
	}

	public void setValutaRacuna(Valute valutaRacuna) {
		this.valutaRacuna = valutaRacuna;
	}

	public Set<DnevnoStanjeRacuna> getDnevniIzvodiBanke() {
		return dnevniIzvodiBanke;
	}

	public void setDnevniIzvodiBanke(Set<DnevnoStanjeRacuna> dnevniIzvodiBanke) {
		this.dnevniIzvodiBanke = dnevniIzvodiBanke;
	}

	public Set<Ukidanje> getUkidanjeRacuna() {
		return ukidanjeRacuna;
	}

	public void setUkidanjeRacuna(Set<Ukidanje> ukidanjeRacuna) {
		this.ukidanjeRacuna = ukidanjeRacuna;
	}
	
	
	
}
