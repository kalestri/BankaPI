package model;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Valute")
public class Valute {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "sifra_valute", columnDefinition="INT", unique = true, nullable = false)
	private Integer sifraValute;
	
	@Column(name = "naziv", columnDefinition="VARCHAR(30)", unique = false, nullable = false)
	private String naziv;
	
	@Column(name = "domicilna", columnDefinition="BIT", unique = false, nullable = false)
	private Boolean domicilna;
	
	@ManyToOne
	@JoinColumn(name = "sifra_drzave", referencedColumnName = "sifra_drzave", nullable = false)
	private Drzava drzavnaValuta;
	
	@OneToMany(cascade = { ALL }, fetch = LAZY, mappedBy = "osnovnaValuta")
	private Set<KursUValuti> osnovnaValuta = new HashSet<KursUValuti>();
	
	@OneToMany(cascade = { ALL }, fetch = LAZY, mappedBy = "premaValuti")
	private Set<KursUValuti> premaValuti = new HashSet<KursUValuti>();
	
	@OneToMany(cascade = { ALL }, fetch = LAZY, mappedBy = "valutaRacuna")
	private Set<RacuniPravnihLica> valutaRacuna = new HashSet<RacuniPravnihLica>();
	
	@OneToMany(cascade = { ALL }, fetch = LAZY, mappedBy = "valutaPlacanja")
	private Set<AnalitikaIzvoda> analitikaIzvoda = new HashSet<AnalitikaIzvoda>();
	
	

	public Valute() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Valute(Integer sifraValute, String naziv, Boolean domicilna,
			Drzava drzavnaValuta, Set<KursUValuti> osnovnaValuta,
			Set<KursUValuti> premaValuti, Set<RacuniPravnihLica> valutaRacuna,
			Set<AnalitikaIzvoda> analitikaIzvoda) {
		super();
		this.sifraValute = sifraValute;
		this.naziv = naziv;
		this.domicilna = domicilna;
		this.drzavnaValuta = drzavnaValuta;
		this.osnovnaValuta = osnovnaValuta;
		this.premaValuti = premaValuti;
		this.valutaRacuna = valutaRacuna;
		this.analitikaIzvoda = analitikaIzvoda;
	}

	public Integer getSifraValute() {
		return sifraValute;
	}

	public void setSifraValute(Integer sifraValute) {
		this.sifraValute = sifraValute;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Boolean getDomicilna() {
		return domicilna;
	}

	public void setDomicilna(Boolean domicilna) {
		this.domicilna = domicilna;
	}

	public Drzava getDrzavnaValuta() {
		return drzavnaValuta;
	}

	public void setDrzavnaValuta(Drzava drzavnaValuta) {
		this.drzavnaValuta = drzavnaValuta;
	}

	public Set<KursUValuti> getOsnovnaValuta() {
		return osnovnaValuta;
	}

	public void setOsnovnaValuta(Set<KursUValuti> osnovnaValuta) {
		this.osnovnaValuta = osnovnaValuta;
	}

	public Set<KursUValuti> getPremaValuti() {
		return premaValuti;
	}

	public void setPremaValuti(Set<KursUValuti> premaValuti) {
		this.premaValuti = premaValuti;
	}

	public Set<RacuniPravnihLica> getValutaRacuna() {
		return valutaRacuna;
	}

	public void setValutaRacuna(Set<RacuniPravnihLica> valutaRacuna) {
		this.valutaRacuna = valutaRacuna;
	}

	public Set<AnalitikaIzvoda> getAnalitikaIzvoda() {
		return analitikaIzvoda;
	}

	public void setAnalitikaIzvoda(Set<AnalitikaIzvoda> analitikaIzvoda) {
		this.analitikaIzvoda = analitikaIzvoda;
	}
	

}
