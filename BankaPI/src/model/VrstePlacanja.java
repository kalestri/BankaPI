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
@Table(name = "VrstePlacanja")
public class VrstePlacanja {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "oznaka_vrste", columnDefinition="INT", unique = true, nullable = false)
	private Integer oznakaVrste;
	
	@Column(name = "naziv_vrste", columnDefinition="VARCHAR(120)", unique = false, nullable = false)
	private String nazivVrste;
	
	@OneToMany(cascade = { ALL }, fetch = LAZY, mappedBy = "vrstaPlacanja")
	private Set<AnalitikaIzvoda> analitikaIzvoda = new HashSet<AnalitikaIzvoda>();
	
	

	public VrstePlacanja() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VrstePlacanja(Integer oznakaVrste, String nazivVrste,
			Set<AnalitikaIzvoda> analitikaIzvoda) {
		super();
		this.oznakaVrste = oznakaVrste;
		this.nazivVrste = nazivVrste;
		this.analitikaIzvoda = analitikaIzvoda;
	}

	public Integer getOznakaVrste() {
		return oznakaVrste;
	}

	public void setOznakaVrste(Integer oznakaVrste) {
		this.oznakaVrste = oznakaVrste;
	}

	public String getNazivVrste() {
		return nazivVrste;
	}

	public void setNazivVrste(String nazivVrste) {
		this.nazivVrste = nazivVrste;
	}

	public Set<AnalitikaIzvoda> getAnalitikaIzvoda() {
		return analitikaIzvoda;
	}

	public void setAnalitikaIzvoda(Set<AnalitikaIzvoda> analitikaIzvoda) {
		this.analitikaIzvoda = analitikaIzvoda;
	}
	

	
}
