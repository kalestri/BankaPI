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
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Drzava")
public class Drzava {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "sifra_drzave", columnDefinition="INT", unique = true, nullable = false)
	private Integer sifraDrzave;
	
	@Column(name = "naziv_drzave", columnDefinition="VARCHAR(40)",length=40, unique = true, nullable = false)
	private String nazivDrzave;
	
	@OneToMany(cascade = { ALL }, fetch = LAZY, mappedBy = "drzavnaValuta")
	private Set<Valute> valuta = new HashSet<Valute>();
	
	@OneToMany(cascade = { ALL }, fetch = LAZY, mappedBy = "mestoUDrzavi")
	private Set<NaseljenoMesto> naseljenoMesto = new HashSet<NaseljenoMesto>();
	
	

	public Drzava() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Drzava(Integer sifraDrzave, String nazivDrzave, Set<Valute> valuta,
			Set<NaseljenoMesto> naseljenoMesto) {
		super();
		this.sifraDrzave = sifraDrzave;
		this.nazivDrzave = nazivDrzave;
		this.valuta = valuta;
		this.naseljenoMesto = naseljenoMesto;
	}

	public Integer getSifraDrzave() {
		return sifraDrzave;
	}

	public void setSifraDrzave(Integer sifraDrzave) {
		this.sifraDrzave = sifraDrzave;
	}

	public String getNazivDrzave() {
		return nazivDrzave;
	}

	public void setNazivDrzave(String nazivDrzave) {
		this.nazivDrzave = nazivDrzave;
	}

	public Set<Valute> getValuta() {
		return valuta;
	}

	public void setValuta(Set<Valute> valuta) {
		this.valuta = valuta;
	}

	public Set<NaseljenoMesto> getNaseljenoMesto() {
		return naseljenoMesto;
	}

	public void setNaseljenoMesto(Set<NaseljenoMesto> naseljenoMesto) {
		this.naseljenoMesto = naseljenoMesto;
	}
	
	
}

