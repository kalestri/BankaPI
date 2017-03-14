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
@Table(name = "NaseljenoMesto")
public class NaseljenoMesto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "sifra_mesta", columnDefinition="INT", unique = true, nullable = false)
	private Integer sifraMesta;
	
	@Column(name = "naziv", columnDefinition="VARCHAR(60)", unique = false, nullable = false)
	private String naziv;
	
	@Column(name = "ptt", columnDefinition="VARCHAR(12)", unique = true, nullable = false)
	private String pttOznaka;
	
	@ManyToOne
	@JoinColumn(name = "sifra_drzave", referencedColumnName = "sifra_drzave", nullable = false)
	private Drzava mestoUDrzavi;
	

	@OneToMany(cascade = { ALL }, fetch = LAZY, mappedBy = "mestoPrijema")
	private Set<AnalitikaIzvoda> mestoPrijema = new HashSet<AnalitikaIzvoda>();
	
	


	public NaseljenoMesto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public NaseljenoMesto(Integer sifraMesta, String naziv, String pttOznaka,
			Drzava mestoUDrzavi, Set<AnalitikaIzvoda> mestoPrijema) {
		super();
		this.sifraMesta = sifraMesta;
		this.naziv = naziv;
		this.pttOznaka = pttOznaka;
		this.mestoUDrzavi = mestoUDrzavi;
		this.mestoPrijema = mestoPrijema;
	}


	public Integer getSifraMesta() {
		return sifraMesta;
	}


	public void setSifraMesta(Integer sifraMesta) {
		this.sifraMesta = sifraMesta;
	}


	public String getNaziv() {
		return naziv;
	}


	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}


	public String getPttOznaka() {
		return pttOznaka;
	}


	public void setPttOznaka(String pttOznaka) {
		this.pttOznaka = pttOznaka;
	}


	public Drzava getMestoUDrzavi() {
		return mestoUDrzavi;
	}


	public void setMestoUDrzavi(Drzava mestoUDrzavi) {
		this.mestoUDrzavi = mestoUDrzavi;
	}


	public Set<AnalitikaIzvoda> getMestoPrijema() {
		return mestoPrijema;
	}


	public void setMestoPrijema(Set<AnalitikaIzvoda> mestoPrijema) {
		this.mestoPrijema = mestoPrijema;
	}
	
	

}
