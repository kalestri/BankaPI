package model;

import java.util.Date;
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

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "DnevnoStanjeRacuna")
public class DnevnoStanjeRacuna {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "broj_izvoda", columnDefinition="INT", unique = true, nullable = false)
	private Integer brojIzvoda;
	
	@Column(name = "datum_prometa", columnDefinition="DATE",  unique = false, nullable = false)
	private Date datumPrometa;
	
	@Column(name = "prethodno_stanje", columnDefinition="DECIMAL(15,2)", unique = false, nullable = false)
	private Float prethodnoStanje;
	
	@Column(name = "promet_u_korist", columnDefinition="DECIMAL(15,2)", unique = false, nullable = false)
	private Float prometUKorist;
	
	@Column(name = "promet_na_teret", columnDefinition="DECIMAL(15,2)", unique = false, nullable = false)
	private Float prometNaTeret;
	
	@Column(name = "novo_stanje", columnDefinition="DECIMAL(15,2)", unique = false, nullable = false)
	private Float novoStanje;
	
	@ManyToOne
	@JoinColumn(name = "broj_racuna", referencedColumnName = "broj_racuna", nullable = false)
	private RacuniPravnihLica dnevniIzvodiBanke;
	
	@OneToMany(cascade = { ALL }, fetch = LAZY, mappedBy = "analitikaIzvodaBanke")
	private Set<AnalitikaIzvoda> analitikaIzvodaBanke = new HashSet<AnalitikaIzvoda>();

	
	public DnevnoStanjeRacuna() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DnevnoStanjeRacuna(Integer brojIzvoda, Date datumPrometa,
			Float prethodnoStanje, Float prometUKorist, Float prometNaTeret,
			Float novoStanje, RacuniPravnihLica dnevniIzvodiBanke,
			Set<AnalitikaIzvoda> analitikaIzvodaBanke) {
		super();
		this.brojIzvoda = brojIzvoda;
		this.datumPrometa = datumPrometa;
		this.prethodnoStanje = prethodnoStanje;
		this.prometUKorist = prometUKorist;
		this.prometNaTeret = prometNaTeret;
		this.novoStanje = novoStanje;
		this.dnevniIzvodiBanke = dnevniIzvodiBanke;
		this.analitikaIzvodaBanke = analitikaIzvodaBanke;
	}

	public Integer getBrojIzvoda() {
		return brojIzvoda;
	}

	public void setBrojIzvoda(Integer brojIzvoda) {
		this.brojIzvoda = brojIzvoda;
	}

	public Date getDatumPrometa() {
		return datumPrometa;
	}

	public void setDatumPrometa(Date datumPrometa) {
		this.datumPrometa = datumPrometa;
	}

	public Float getPrethodnoStanje() {
		return prethodnoStanje;
	}

	public void setPrethodnoStanje(Float prethodnoStanje) {
		this.prethodnoStanje = prethodnoStanje;
	}

	public Float getPrometUKorist() {
		return prometUKorist;
	}

	public void setPrometUKorist(Float prometUKorist) {
		this.prometUKorist = prometUKorist;
	}

	public Float getPrometNaTeret() {
		return prometNaTeret;
	}

	public void setPrometNaTeret(Float prometNaTeret) {
		this.prometNaTeret = prometNaTeret;
	}

	public Float getNovoStanje() {
		return novoStanje;
	}

	public void setNovoStanje(Float novoStanje) {
		this.novoStanje = novoStanje;
	}

	public RacuniPravnihLica getRacuniPravnihLica() {
		return dnevniIzvodiBanke;
	}

	public void setRacuniPravnihLica(RacuniPravnihLica dnevniIzvodiBanke) {
		this.dnevniIzvodiBanke = dnevniIzvodiBanke;
	}

	public Set<AnalitikaIzvoda> getAnalitikaIzvoda() {
		return analitikaIzvodaBanke;
	}

	public void setAnalitikaIzvoda(Set<AnalitikaIzvoda> analitikaIzvodaBanke) {
		this.analitikaIzvodaBanke = analitikaIzvodaBanke;
	}

}
